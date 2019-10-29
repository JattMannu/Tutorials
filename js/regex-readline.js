const search = require("./regex");
const getContent = require("./node-readline");
const pathToFile = './node-readline.text'

search(/[a-zA-Z]*.gql/gm,getContent(pathToFile)).then(function(msg){
    console.log(msg)
})
