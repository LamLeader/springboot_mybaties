"use strict";
var Prative = angular.module('Pratice',[]);
Prative.controller('FirstController1',function ($scope) {
   $scope.name="张三";
   $scope.data={
       name:'李四',
       count:20
    }
    $scope.count=20;
   //$watch 监听model 当model值改变 则触发（比较新值和旧值 如果值改变了就会触发调用）
    $scope.$watch('name',function (newValue,oldValue) {
         ++$scope.count;
         console.log(newValue+oldValue);
         if($scope.count>30){
             $scope.name="name已经大于30次了";
         }
    });

    $scope.$watch('data',function () {
        
    },true);





});
