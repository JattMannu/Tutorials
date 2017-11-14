var mongoose = require('mongoose');

mongoose.connect('mongodb://admin:admin@ds036577.mlab.com:36577/db_information');

var conn = mongoose.connection;


var user = {
    command: 'abc',
    data: 'sampleData'
};


conn.collection('VaultQ').insert(user);

console.log('User:');
console.log(user);