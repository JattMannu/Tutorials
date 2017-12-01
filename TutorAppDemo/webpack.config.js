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
            },
            {
                test: /\.css$/,
                loader: "style-loader!css-loader"
            },
            {
                test: /\.(png|woff|woff2|eot|ttf|svg)$/,
                loader: 'url-loader?limit=100000'
            },
            {
                test: /\.(gif|png|jpe?g|svg)$/i,
                loaders: [
                    'file-loader?hash=sha512&digest=hex&name=[hash].[ext]',
                    'image-webpack-loader?{optimizationLevel: 7, interlaced: false, pngquant:{quality: "65-90", speed: 4}, mozjpeg: {quality: 65}}'
                ]
            }
        ]
    },
};