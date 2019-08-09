"use strict";
var Prative = angular.module('Pratice',[]);
Prative.controller('FirstController',function ($scope) {
    //$scope 作用域
    //声明一个model
    $scope.name='张三';
    $scope.age=20;
});
