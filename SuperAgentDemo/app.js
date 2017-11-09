const request = require('superagent');
const convert = require('xml-js');

console.log('Learing Superagent')
const VaultURL = 'http://ecs-92033903.ecs.ads.autodesk.com/AutodeskDM/Services/'


// request
//     .get('http://ecs-92033903.ecs.ads.autodesk.com/AutodeskDM/Services/Filestore/v21/')
//     .end(function (err, res) {
//         console.log(err);
//         console.log(res.tex);
//     })


// request
//     .post(VaultURL + 'Filestore/v23/IdentificationService.svc')
//     .set('Content-Type', 'text/xml')
//     .set('SOAPAction', 'http://AutodeskDM/Filestore/Identification/1/6/2017/IdentificationService/GetServerIdentities')
//     .send('<s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/"><s:Body xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"><GetServerIdentities xmlns="http://AutodeskDM/Filestore/Identification/1/6/2017/"/></s:Body></s:Envelope>')
//     .end(function (err, res) {
//         console.log(err);
//         const resJson = convert.xml2json(res.text, { compact: false, spaces: 4 });
//         console.log(resJson);
//     });

request
    .post(VaultURL + 'Filestore/v23/FilestoreVaultService.svc')
    .set('Content-Type', 'text/xml')
    .set('SOAPAction', 'http://AutodeskDM/Filestore/FilestoreVault/1/6/2017/FilestoreVaultService/GetAllKnowledgeVaults')
    .send('<s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/"><s:Body xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"><GetAllKnowledgeVaults xmlns="http://AutodeskDM/Filestore/FilestoreVault/1/6/2017/"/></s:Body></s:Envelope>')
    .end(function (err, res) {
        console.log(err);
        const { elements: [{ elements: [{ elements: [{ elements: [{ elements }] }] }] }] } = JSON.parse(convert.xml2json(res.text, { compact: false, spaces: 4 }));

        console.log(elements[0].attributes);
        console.log(elements[1].attributes);
        //console.log(elements);
    })