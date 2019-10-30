const superagent = require('superagent')

module.exports = function (race) {
        new Promise(async function (resolve, reject) {
                superagent
                        .get(`https://api.guildwars2.com/v2/races/${race}`)
                        .then(res => resolve(res.body))
        });
}