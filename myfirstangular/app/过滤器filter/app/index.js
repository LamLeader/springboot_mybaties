"use strict";
var app =angular.module('myApp',[]);

app.factory('Data',function () {
   return {
       message: 'Helloe World',
       city:[
           {
               name:'上海',
               py:'shanghai'
           },{
               name:'北京',
               py:'beijing'
           },{
               name:'贵阳',
               py:'guiyang'
           }
       ]
   };

});

app.controller('firstController',function ($scope,Data,$filter) {
    $scope.data=Data;
    $scope.today=new Date();

    //过滤器
    var number=$filter('number')(3000);

    var jsonString=$filter('json')($scope.data);
    console.log(jsonString);

    /**
     * 自定义方法名字检查
     */
    $scope.checkName=function (obj) {
        console.log(obj);
    };

});