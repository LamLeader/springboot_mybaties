"use strict";
var privates=angular.module('product',[]);
/**
 * 服务
 */
privates.service('productData',function () {
    return[
        {   id:1,
            name:'iphone1',
            price:3400
        }, {   id:2,
            name:'iphone2',
            price:3500
        }, {
            id:3,
            name:'iphone3',
            price:3600
        }, {
            id:4,
            name:'iphone4',
            price:3400
        }, {
            id:5,
            name:'iphone5',
            price:4588
        }
    ];
});

privates.controller('productController',function ($scope,productData) {

    $scope.productDatas=productData;
    $scope.orderType='id';
    $scope.order='-';

    $scope.changeOrder=function (type) {
        $scope.orderType=type;
        if ($scope.order===''){
            $scope.order='-';
        }else{
            $scope.order='';
        }
    };

});

