const { Menu, MenuItem } = require('electron')


class MenuBuilder {
    constructor(template) {
        this.template = `./templates/${template}.js`;
        this.menuItems = []
    }

    enableDevMode() {
        this.devMode = true;
        return this;
    }

    addCustomMenuItem(menuItem) {
        this.menuItems.push(menuItem)
        return this;
    }

    addCustomMenuFunction(func) {
        this.menuItems.push(func())
        return this;
    }

    build() {
        let template = require(this.template);
        this.menuItems.forEach(menuItem => template.push(menuItem));

        process.env.NODE_ENV !== 'production' ? template.push({
            label: 'Debugging',
            submenu: [
                {
                    label: 'Toggle DevTools',
                    accelerator: process.platform == 'darwin' ? 'Command+I' : 'Alt+I',
                    click(item, focusedWindow) {
                        focusedWindow.toggleDevTools();
                    },

                },
                {
                    role: 'reload'
                }
            ]
        }) : template;

        process.platform == 'darwin' ? template.unshift({}) : template

        return Menu.setApplicationMenu(Menu.buildFromTemplate(template));;
    }

}


module.exports = MenuBuilder;