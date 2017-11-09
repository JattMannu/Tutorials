'use strict';

var url = require('url');

var Default = require('./DefaultService');

module.exports.demoGET = function demoGET (req, res, next) {
  Default.demoGET(req.swagger.params, res, next);
};

module.exports.demoPOST = function demoPOST (req, res, next) {
  Default.demoPOST(req.swagger.params, res, next);
};

module.exports.folderDELETE = function folderDELETE (req, res, next) {
  Default.folderDELETE(req.swagger.params, res, next);
};

module.exports.folderGET = function folderGET (req, res, next) {
  Default.folderGET(req.swagger.params, res, next);
};

module.exports.folderPOST = function folderPOST (req, res, next) {
  Default.folderPOST(req.swagger.params, res, next);
};
