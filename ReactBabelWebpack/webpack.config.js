var path = require('path');
var webpack = require('webpack');

module.exports = {
    //All development is done in app.js
    entry: './app.js',
    //Create out 1 big js file called bundle.js in the __dirname
    output: { path: __dirname, filename: 'bundle.js' },
    //This like keep watching all the files.
    watch: true,
    module: {
        loaders: [
            {
                //Take all files ending with js and jsx
                test: /.jsx?$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    presets: ['es2015', 'react']
                }
            }
        ]
    },
};