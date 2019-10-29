const faker = require("json-schema-faker")

console.log('faker run');

let s = faker.generate({
    "type": "array",
    "minItems": 10,
    "maxItems": 10,
    "items": {
        "language" :  "en-sg",
        "providers" : [],
        "minAnnualSalary": {
            "type": "integer",
            "minimum": 0,
            "maximum": 600000,
            "exclusiveMinimum": true
        },
        //
        "list": {
            "type": "string",
            "enum": [
                'debit-cards',
                'savings-accounts'
            ]
        },
        "staticTextKeys": ["resultsCountLabel"]
    }
});

console.log(s)
