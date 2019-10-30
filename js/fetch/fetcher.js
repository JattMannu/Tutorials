const https = require('https');

const baseUrl = 'https://api.guildwars2.com';

const hostname = 'api.guildwars2.com'
const version = ''
const action = '/v2/guild/search?name=Edit%20Conflict'

const _url = `${baseUrl}${version}${action}`

// https://api.guildwars2.com/v2/guild/search?name=Edit%20Conflict

console.log(_url) 

  
  const options = {
    hostname: hostname,
    port: 443,
    path: '/v2/guild/search?name=Edit%20Conflict',
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    }
  };
  
  const req = https.get(options, (res) => {
    console.log(`STATUS: ${res.statusCode}`);
    console.log(`HEADERS: ${JSON.stringify(res.headers)}`);
    res.setEncoding('utf8');
    res.on('data', (chunk) => {
      console.log(`BODY: ${chunk}`);
    });
    res.on('end', () => {
      console.log('No more data in response.');
    });
  });
  
  req.on('error', (e) => {
    console.error(`problem with request: ${e.message}`);
  });
  
  req.end();