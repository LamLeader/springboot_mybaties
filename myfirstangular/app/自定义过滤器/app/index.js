'use strict';
var app=angular.module('myApp',function ($filer) {

   app.service('data',function () {
       return[
          {
             id:1,
             name: '张三',
             city:'北京'
          }
       ];

   });
   app.controller('filterController',function () {

   });
});