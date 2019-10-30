const {BrowserWindow , ipcMain ,ipcRenderer} = require("electron");
const path = require('path')
const superagent = require('superagent')


module.exports = function createSearchGuildByGuildNameWindow(parentWin){
  let thisWindow = new BrowserWindow({
    width: 300,
    height: 200,
    webPreferences: {
      nodeIntegration: true
    }   
  })

  console.log( path.join(__dirname, 'index.html'))

  thisWindow.loadFile( path.join(__dirname, 'index.html'))

  thisWindow.once('closed', () => {
    // Dereference the window object, usually you would store windows
    // in an array if your app supports multi windows, this is the time
    // when you should delete the corresponding element.
    thisWindow = null;    
  })
  // Catch GuildName
  ipcMain.once("searchGuildByGuildName" , function(e, guildName){
    //console.log("ipcMain : "+ guildName);
    superagent
    .get("https://api.guildwars2.com/v2/guild/search?name=Edit%20Conflict")
    .then(res =>{
        console.log(res.body[0]);
        parentWin.webContents.send('searchGuildByGuildName' , res.body[0]);    
    })
    //parentWin.webContents.send('searchGuildByGuildName' , guildName);
    thisWindow.close()
  });

//   ipcMain.on("searchGuildByGuildName" , function(e, guildName){
//     console.log("ipcMain : "+ guildName);
//   });
}

