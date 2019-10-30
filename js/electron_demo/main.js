const electron = require('electron')
const url = require('url');
const path = require('path');
const createSearchGuildByGuildNameWindow = require("./guild/searchGuildByGuildName")

const { app, BrowserWindow, Menu, ipcMain, MenuItem , ipcRenderer } = electron;


// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let win

function createWindow() {
  // Create the browser window.
  win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      nodeIntegration: true
    }
  })

  // and load the index.html of the app.
  win.loadFile('main.html')


  // Emitted when the window is closed.
  win.on('closed', () => {
    // Dereference the window object, usually you would store windows
    // in an array if your app supports multi windows, this is the time
    // when you should delete the corresponding element.
    win = null
    app.quit();
  })

  //Build menu via template
  const mainMenu = Menu.buildFromTemplate(mainMenuTemplate)
  Menu.setApplicationMenu(mainMenu)

  require("./gw2/getRaces")().then(function (racesList) {
    let races = new Menu();
    console.log(racesList);
    let menu = Menu.getApplicationMenu();

    menu.append(new MenuItem({
      label: 'Races',
      submenu: racesList.map(race => new MenuItem({
        label: race, 
        click() {
          console.log(race);
          win.loadFile('races.html').then(function(msg){
            console.log(msg);
          })

          ipcMain.handleOnce('my-invokable-ipc', async (event, ...args) => {
            console.log("ipcMain");
            return race;
          })
          
        }
      }))
    }));

    return menu;

  }).then(function (menu) {
    Menu.setApplicationMenu(menu);
  })


}



// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.on('ready', createWindow)

// Quit when all windows are closed.
app.on('window-all-closed', () => {
  // On macOS it is common for applications and their menu bar
  // to stay active until the user quits explicitly with Cmd + Q
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

app.on('activate', () => {
  // On macOS it's common to re-create a window in the app when the
  // dock icon is clicked and there are no other windows open.
  if (win === null) {
    createWindow()
  }
})



// In this file you can include the rest of your app's specific main process
// code. You can also put them in separate files and require them here.
let mainMenuTemplate =

  [
    {
      label: 'Menu',
      submenu: [
        {
          label: 'Quit',
          accelerator: process.platform == 'darwin' ? 'Command+Q' : 'Alt+Q',
          click() {
            console.log('Quit');
            app.quit();
          }

        },
      ]
    },
    {
      label: 'Guild',
      submenu: [
        {
          label: 'Search by Name',
          click() {
            console.log('Search by Name')
            createSearchGuildByGuildNameWindow(win)
            //searchGuildByName()
          }
        },
        {
          label: 'Search by Player Name'
        },
        {
          label: 'test',
          async click() {
            console.log(await require("./gw2/getRaces")().then(function (races) {
              return [{ label: 'Test' }]
            }))
          }
        }
      ]
    }
  ];

mainMenuTemplate = process.platform == 'darwin' ? mainMenuTemplate.unshift({}) : mainMenuTemplate


//Developer tools
process.env.NODE_ENV !== 'production' ? mainMenuTemplate.push({
  label: 'Debugging',
  submenu: [
    {
      label: 'Toggle DevTools',
      accelerator: process.platform == 'darwin' ? 'Command+I' : 'Alt+I',
      click(item, focusedWindow) {
        //console.log(item);
        focusedWindow.toggleDevTools();
      },

    },
    {
      role: 'reload'
    }
  ]
}) : mainMenuTemplate;
  // Open the DevTools.
//  win.webContents.openDevTools()
