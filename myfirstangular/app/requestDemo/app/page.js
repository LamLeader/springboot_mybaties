'use strict';
var app = angular.module("user", ['tmPagination']);
app.controller('userController',function($scope,$http){

    /*分页控件配置currentPage:当前页
    totalItems :总记录数
    itemsPerPage:每页记录数
    perPageOptions :分页选项
    onChange:当页码变更后自动触发的方法 */
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            alert("6666");
            $scope.reloadList();
            console.log("分页");
        }
    };

    //刷新列表
    $scope.reloadList=function(){
        $scope.search( $scope.paginationConf.currentPage ,  $scope.paginationConf.itemsPerPage );
    }

    //分页
    $scope.findPage=function(page,size){
       /* $http.get('http://192.168.0.100:9091/queryUser.do?callback=JSON_CALLBACK?pageNum='+0 +'&pageSize='+6).success(
            function(response){
                $scope.list = response.data.userList;//显示当前页数据
                $scope.paginationConf.totalItems=response.data.total;//更新总记录数
                alert("数据："+$scope.list);
            }
        );*/
        $http.get('http://192.168.0.100:9091/queryUser.do?callback=JSON_CALLBACK?pageNum='+0 +'&pageSize='+6).then(function (response) {
            $scope.list = response.data.userList;//显示当前页数据
            $scope.paginationConf.totalItems=response.data.total;//更新总记录数
            alert("数据："+$scope.list);
        });
    };

});
