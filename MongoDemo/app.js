var express = require('express')
var app = express()


var mongoose = require('mongoose');

mongoose.connect('mongodb://admin:admin@ds036577.mlab.com:36577/db_information');

var conn = mongoose.connection;

app.get('/add', function (req, res) {
    new Promise(function (resolve, reject) {
        const entry = {
            headers: req.headers,
            url: req.url,
            body: req.body
        }
        conn.collection('VaultQ').insert(entry);
        return resolve('Done');
    }).then(function (data) {
        res.send(data);
    }).catch(function (err) {
        console.log(err);
    });
});

app.post('/add', function (req, res) {
    new Promise(function (resolve, reject) {
        const entry = {
            headers: req.headers,
            url: req.url,
            body: req.body
        }
        conn.collection('VaultQ').insert(entry);
        return resolve('Done');
    }).then(function (data) {
        res.send(data);
    }).catch(function (err) {
        console.log(err);
    });
});


app.get('/getData', function (req, res) {
    new Promise(function (resolve, reject) {
        let data = conn.collection('VaultQ').find().toArray(function (err, docs) {
            resolve(docs)
        })

    }).then(function (data) {
        res.send(data);
    }).catch(function (err) {
        console.log(err);
    });
})

app.listen(3000)