const readline = require("readline");
const fs = require("fs");

const pathToFile = './node-readline.text'


async function checkFileExist(path) {
    return new Promise(function (resolve, reject) {
        fs.access(path, fs.F_OK, (err) => {
            if (err)
                reject(err);
            resolve(path);
        })
    });
}

async function getContentOfFile(path) {
    await checkFileExist(path)
    return new Promise(function (resolve, reject) {
        fs.readFile(path, {
            encoding: 'utf8',
            flag: 'r'
        }, (err, data) => {
            if (err)
                reject(data)
            resolve(data)
        });
    });
}

async function main() {
    let c = await getContentOfFile(pathToFile);
    console.log(c);
}

main().then(() => console.log("node-readline-end"));


module.exports = getContentOfFile;
