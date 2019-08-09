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
    //自定义工厂
    $provide.factory('myFactory',function () {

        return 'return my factory';

    });
    //自定义服务 service和factory类似 返回的东西必须是对象
    $provide.service('myService',function () {

        return 'return my  myService';
    });
});

privates.controller('proviserCon',function ($scope,cousomService1,myFactory,myService) {
     $scope.name='消息推送';
     console.log(cousomService1,myFactory,myService);
});
myApp.service();
myApp.factory();