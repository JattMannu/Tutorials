How to Import CSS for webpack?
npm install style-loader --save
npm install url-loader --save
npm install file-loader --save
npm install css-loader --save

module.exports = {
  module: {
    loaders: [
      { test: /\.css$/, loader: "style-loader!css-loader" },
      // ...
    ]
  }
};