"use strict";
/**
 *多个控制器共享数据
 * @type {angular.Module}
 */
var app=angular.module('myApp',[]);

   //共享数据方法一factory方式
    app.factory('Data',function () {
        return {
            message:'共享的数据'
        };
    });
    //第一个控制器
    app.controller('firstController',function ($scope,Data) {
        /**
         * 基本数据类型
         * 1、$scope.name:222
         *引用数据类型 可动态改变数据
         * 2、$scope.data={
            name:'张三'
           };
         * @type {{name: string}}
         */
        $scope.data={
            name:'张三'
        };
        console.log($scope);
        $scope.Data=Data;
    });
/**第二个控制器
 * Data angular的自动注入
 * 调用的方法都是从服务端过来的所有数据是共享的
 */
app.controller('secondController',function ($scope,Data) {
        $scope.data=$scope.$$prevSibling.data;//通过前一个对象值来实现数据共享
        $scope.Data=Data;//通过factory方式来获取全局值达到共享的目的 引用类型
    });