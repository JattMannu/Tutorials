const { app, BrowserWindow, Menu, MenuItem } = require('electron');
const MenuBuilder = require("./menu/menuBuilder");

let mainWindow;


function createWindow() {

    mainWindow = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true
        }
    });

    mainWindow.loadFile('main.html');

    mainWindow.on('close', () => {
        win = null;
        app.quit();
    });


    new MenuBuilder("mainMenuTemplate")
        .enableDevMode()
        .addCustomMenuItem(
            new MenuItem({
                label: 'Races'
                
            })
        )
        .build();
}

app.on('ready', createWindow);

