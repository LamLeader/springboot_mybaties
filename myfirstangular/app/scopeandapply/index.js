"use strict";
var Prative = angular.module('Pratice',[]);
Prative.controller('FirstController',function ($scope) {
    $scope.date = new Date();
    $interval(function () {


        $scope.apply(function () {
            $scope.date = new Date();
            //会触发脏检查
        });
    },1000);




})
