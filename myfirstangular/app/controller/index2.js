"use strict";
var Prative = angular.module('Pratice',[]);
Prative.controller('MyController',function ($scope,$timeout) {
    var updateClock = function () {
        $scope.clock = new Date();
        $timeout(function () {
            updateClock();
        },1);
    };
   updateClock();
})
