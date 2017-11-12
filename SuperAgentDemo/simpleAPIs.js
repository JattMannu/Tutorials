const request = require('superagent');

const root = 'https://jsonplaceholder.typicode.com';

//Easy way of exporting all the functions.
module.exports = {

    Demo1() {
        return new Promise(function (resolve, reject) {
            request
                .get(root + '/posts/1')
                .end(function (err, res) {
                    //Return an error if err is not null.
                    if (err) return reject(err); //Do return to that it does not continue with next line of code.
                    return resolve(res.text);
                });
        });
    }
}


//module.exports.Demo1 = Demo1;


