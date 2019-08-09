"use strict";
/**
 * $provide的provider方法
 * @type {angular.Module}
 */
var privates=angular.module('myApp',[],function ($provide) {
    //自定义服务
    $provide.provider('cousomService1',function () {
        this.$get =function () {
            return {
                message:'消息推送！！！'
            };
        };
    });
    $provide.provider('cousomService2',function () {
        this.$get =function () {
            return {
                message:'消息推送2！！！'
            };
        };
    });
});

privates.controller('proviserCon',function ($scope,cousomService1,cousomService2) {
     $scope.name='44444';
     console.log(cousomService1,cousomService2);
});