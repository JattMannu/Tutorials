const superagent = require('superagent')

module.exports = function () {
    return new Promise(async function (resolve, reject) {
        superagent
            .get("https://api.guildwars2.com/v2/races")
            .then(res => resolve(res.body))
    });
}