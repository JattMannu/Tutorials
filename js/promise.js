let name = "maple";

console.log(name)

let p = new Promise((resolve,reject)=>{
    let name = "mark"
    if(name === "mark")
        resolve("good")
    reject("error , not mark!")
} )

p.then((msg)=>{
    console.log(msg);
}).catch((err)=>{
    console.log("error : " + err);
})

var age = 4;

{
    var age = 3;
    console.log(age)
}

console.log(age)




const https = require('https');



function myPromise(){
    return new Promise((resolve, reject)=>{
        https.get('https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY', (resp) => {
  let data = '';
        resp.on('data', (chunk) => {
            data += chunk;
        });
        resp.on('end', () => {
            resolve(data);

        });

        }).on("error", (err) => {
            reject(err);
        
        });
    })
}

myPromise().then((msg) =>{
    console.log(JSON.parse(msg).explanation);
}).catch((err)=>{
    console.log("Error: " + err.message);
})