const https = require('https');
const fs = require('fs');

const getItems = function (opts) {
    return new Promise(function (resolve, reject) {
        const req = https.get(opts, (res) => {
            console.log(`STATUS: ${res.statusCode}`);
            console.log(`HEADERS: ${JSON.stringify(res.headers)}`);
            res.setEncoding('utf8');

            let body = '';
            res.on('data', (chunk) => {
                //console.log(`BODY: ${chunk}`);
                body += chunk;
            });
            res.on('end', () => {
                body = JSON.parse(body)
                //console.log(body);
                resolve(body)
            });
        });
        req.on('error', (e) => {
            console.error(`problem with request: ${e.message}`);
            reject(e);
        });

        req.end();
    })
}

getItems(
    {
        hostname: 'api.guildwars2.com',
        port: 443,
        path: '/v2/items',
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    }
).then(function (items) {
    //items = items.splice(0, 10);
    //itemsInfo = [];
    //let item = items.pop()
    //console.log(item);
    a(items.pop())
    a(items.pop())
    a(items.pop())
    a(items.pop())
    //let count = 5
    function a(item) {
        getItems(
            {
                hostname: 'api.guildwars2.com',
                port: 443,
                path: `/v2/items/${item}`,
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                }
            }
        ).then(data => {
            return new Promise(function (resolve, reject) {
                //itemsInfo.push(item)
                fs.writeFile(`./tmp/${item}.json`, JSON.stringify(data), function (err) {

                    if (err) {
                        return console.log(err);
                    }

                    console.log("The file was saved!");
                    resolve(true);
                });
            });
        }).then(function (val) {
            if (items.length == 0)
                return;
            console.log("NExt file");
            a(items.pop())
        });
    }

    //return itemsInfo;

    // let promises = items.map(item => {
    //     console.log(`ID = ${item}`)
    //     return new Promise(function (resolve, reject) {
    //         resolve(item);
    //     })
    // });

    // await asyncThrottledMap(-123, promises).then(function(itemInfo){
    //     console.log(itemInfo);
    // });
    // Promise.all(promises).then(function(values) {
    //     console.log(values);
    //   });values


    //let itemsInfo = sys(promises)
    //console.log(itemsInfo);

    // Promise.all(promises).then(function (values) {
    //     console.log(values);
    // });
    // console.log(itemsInfo)
})
var size = 1;
function run(fn, self, args) {
    if (size) {
        size--;
        var result = new Promise(function (resolve) {
            resolve(fn.apply(self, args));
        });
        result.then(release, release);
        return result;
    }
}

function release() {
    size++;
    if (!queue.isEmpty()) {
        var next = queue.shift();
        next.resolve(run(next.fn, next.self, next.args));
    }
}

function sys(ps) {
    let items = []

    function all(ps) {
        return new Promise(function (resolve, reject) {
            if (ps.length == 0) {
                //console.log(ps);
                resolve("asd")
            }

            Promise.all(ps.splice(0, 10)).then(function (values) {
                //console.log(values);
                items = items.concat(values)
                all(ps).then(function (data) {
                    resolve(data);
                })
            });
        })

    }

    all(ps).then(function (a) {
        console.log(items);
    });
}

async function asyncThrottledMap(maxCount, array, f) {
    let inFlight = new Set();
    const result = [];

    // Sequentially add a Promise for each operation.
    for (let elem of array) {

        // Wait for any one of the promises to complete if there are too many running.
        if (inFlight.size >= maxCount) {
            await Promise.race(inFlight);
        }

        // This is the Promise that the user originally passed us back.
        //const origPromise = f(elem);
        // This is a Promise that adds/removes from the set of in-flight promises.
        const handledPromise = wrap(elem);
        result.push(handledPromise);
    }

    return Promise.all(result);

    async function wrap(p) {
        inFlight.add(p);
        const result = await p;
        inFlight.delete(p);
        return result;
    }
}