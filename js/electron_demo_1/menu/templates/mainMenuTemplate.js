const { app } = require('electron')

module.exports =
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
                    }
                },
                {
                    label: 'Search by Player Name'
                },
                {
                    label: 'test',
                    async click() {
                        console.log('test')
                    }
                }
            ]
        }
    ];