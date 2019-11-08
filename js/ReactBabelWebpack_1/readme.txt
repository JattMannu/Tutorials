NodeJS is install
NPM is installed

Step 1 :
npm init
    package.json file is created

Step 2 :
npm install babel-loader babel-core babel-preset-es2015 babel-preset-react --save
    package.json is updated
          "dependencies": {
                "babel-core": "^6.26.0",
                "babel-loader": "^7.1.2",
                "babel-preset-es2015": "^6.24.1",
                "babel-preset-react": "^6.24.1"
                }
    package-lock.json is created.
Reason why you should not install babel or webpack globally, So that when you updated
webpack or babel you do not break other project's dependencies

Step 3 :
npm install webpack --save
    package.json is updated

Step 4 :
How to use locally installed webpack and babel?
Add them as scripts under package.json
      "scripts": {
                "test": "echo \"Error: no test specified\" && exit 1",
                "babel": "babel",
                "webpack": "webpack"
            },
How to call scripts?
    npm run babel 
    npm run webpack

Step 5 :
Create a webpack.config.js file.

Step 6 : 
Create app.js

Step 7 :
npm install react react-dom --save

Step 8 :
To build run 
    npm run webpack
 
Step 9 : 
npm install webpack-dev-server --save

Step 10:
Add webpack-dev-server to script section of the package.json

Step 11:
To Run webpack-dev-server 
    npm run webpack-dev-server

Step 12:
You will see a website with all the files in the folder.
We need to create a HTML file.
If we make a index.html file it will be pick up by default.
Make index.html