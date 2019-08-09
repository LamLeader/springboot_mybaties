"use strict";
var  app=angular.module('myApp', []);
var httpWeb="http://192.168.0.107:9091/";
app.controller('customersCtrl',['$scope','$http','$timeout',function ($scope,$http,$timeout) {
    //定义数据数组
   $scope.userList=[
      /*{   userId:1,
           userName:'iphone1',
           psw:3222
       }, {
           userId:2,
           userName:'iphone2',
           psw:3111
       }, {
           userId:3,
           userName:'iphone3',
           psw:344
       }, {
           userId:4,
           userName:'iphone4',
           psw:36666
       }, {
           userId:5,
           userName:'iphone5',
           psw:37777
       }*/
   ];
    /*-------初始化和点击时调用刷新列表 begin ----*/
    $scope.paginationConf = {
        currentPage : 1,//当前页
        totalItems : 10,//总数
        itemsPerPage : 10,//每页个数
        perPageOptions : [ 10, 20, 30, 40, 50 ],//分页选项
        onChange : function() {//当更改页码时，自动触发事件
            $scope.reloadList();
        }
    };
    //刷新列表
    $scope.reloadList = function() {
        $scope.findPage($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    }
    //分页
    $scope.findPage = function(pageNum, pageSize) {
        $http.get(
            httpWeb+'queryUser.do?callback=JSON_CALLBACK&pageNum=' + pageNum + '&pageSize='+ pageSize + '').success(function(response) {
            $scope.list=response.data.userList;//显示当前页数据
            alert("数据："+$scope.list);
            $scope.paginationConf.totalItems=response.data.total;//更新总记录数
        });
    };
    /*-------初始化和点击时调用刷新列表 end ----*/


    /**
     * 初始化页面数据
     */

    $scope.initPages=function(){

       /*
        -- 请求方式二 2019年7月9日17:40:41
         $http.get("http://192.168.0.100:9091/queryUser.do?callback=JSON_CALLBACK").then(function (response) {
            $scope.userList = response.data.userList;
        });*/
        $http({
            method:"GET",
            url:httpWeb+"queryUser.do?callback=JSON_CALLBACK",
            datatype:'json',
            //params:{name:$scope.name}  // 传递数据作为字符串，从前台传到后台*!/
        }).success(function(data,status){
            //alert(status);
            $scope.userList =data.userList;
            $scope.total =data.total;
        }).error(function (response, status) {
            alert('请求错误:'+status);
            console.log('请求错误'+status);
            if (status == 408) {
                alert(status);
                console.log('超时');
                alert('超时');
            }
        });
    };

    /**
     * 用户查询
     */
    $scope.queryAllUser=function () {
                 var urls=httpWeb+'queryUser.do?callback=JSON_CALLBACK';
                 //var urls='http://192.168.43.186:9091/queryUser1.do?callback=JSON_CALLBACK';
                 //网络请求
                 $http({
                     method  : 'POST',
                     url:urls,
                     datatype:'json',
                     params:{name:$scope.userName}  // 传递数据作为字符串，从前台传到后台*/
                 }/*,timeout(1000)*/).success(function (data) {
                    /* alert(JSON.stringify(data));*/
                     $scope.userList =data.userList;
                     $scope.total =data.total;
                }
                ).error(function (response, status) {
                     alert('请求错误:'+status);
                     if (status == 408) {
                         $scope.has_more = true;
                         $scope.query_flag = true;
                         console.log('超时');
                         alert('超时');
                     }
               });
    };

    /**
     * 添加用户
     */
    $scope.addUser=function () {
       // return $http.get('http://192.168.43.186:9091/insertUser.do');
        var urls=httpWeb+'insertUser.do?callback=JSON_CALLBACK';
        var name=$scope.name;
        var psw=$scope.psw;
        var age=$scope.age;
        if(name==''||name==null){
            alert("名称不能为空！");
            return;
        }if(psw==''||psw==null){
            alert("密码不能为空！");
            return;
        }if(age==''||age==null){
            alert("年龄不能为空！");
            return;
        }if(name!=''&&psw!=''&&age!=''){
            //网络请求
            $http({
                method  : 'POST',
                url:urls,
                datatype:'json',
                params    :{name:name,psw:psw,age:age},  // 传递数据作为字符串，从前台传到后台
            }).success(function (data) {
                    alert("add User was success!!!");
                    $scope.queryAllUser();//刷新页面
                }
            ).error(function (response, status) {
                alert('请求错误:'+status);
                if (status == 408) {
                    $scope.has_more = true;
                    $scope.query_flag = true;
                    console.log('超时');
                    alert('超时');
                }
            });
        }

    };
    /**
     * 找到一个元素的索引
     */
    var findIndex=function(id){
        var index=-1;
        angular.forEach($scope.cart,function (item,key) {
            if(item.id==id){
                index=key;
            }
        });
        return index;
    };
    /**
     * 根据id移除用户信息
     */
    $scope.removeUserById=function (id) {
        var returnKey=confirm('您确定移除该用户信息么？');
        if(returnKey){
            var urls=httpWeb+'removeUserById.do?callback=JSON_CALLBACK';
            //网络请求
            $http({
                method  : 'POST',
                url:urls,
                datatype:'json',
                params    :{id:id},  // 传递数据作为字符串，从前台传到后台
            }).success(function (data) {
                    alert("remove User was success!!!");
                    $scope.queryAllUser();//刷新页面
                }
            ).error(function (response, status) {
                alert('请求错误:'+status);
                if (status == 408) {
                    $scope.has_more = true;
                    $scope.query_flag = true;
                    console.log('超时');
                    alert('超时');
                }
            });
        }
    };
    /**
     * 根据id获取用户详细信息
     */
    $scope.getUserById=function (id) {
        var urls=httpWeb+'getUserById.do?callback=JSON_CALLBACK';
        //网络请求
        $http({
            method  : 'POST',
            url:urls,
            datatype:'json',
            params    :{id:id},  // 传递数据作为字符串，从前台传到后台
        }).success(function (data) {
                /*alert(JSON.stringify(data.userInfo));
                console.log(JSON.stringify(data.userInfo));*/
                 $scope.name=data.userInfo.name;//数据赋值
                 $scope.age=data.userInfo.age;
                 $scope.psw=data.userInfo.psw;
                 $scope.id=data.userInfo.id;
            }
        ).error(function (response, status) {
            alert('请求错误:'+status);
            if (status == 408) {
                $scope.has_more = true;
                $scope.query_flag = true;
                console.log('超时');
                alert('超时');
            }
        });

    };
    /**
     * 根据id修改用户信息
     */
    $scope.updateUserById=function () {
        var returnKey=confirm('您确定修改该用户信息么？');
        if(returnKey){
            var urls=httpWeb+'updateUserById.do?callback=JSON_CALLBACK';
            //网络请求
            $http({
                method  : 'POST',
                url:urls,
                datatype:'json',
                params    :{id:$scope.id,name:$scope.name,psw:$scope.psw,age:$scope.age},  // 传递数据作为字符串，从前台传到后台
            }).success(function (data) {
                    alert("update User was success!!!");
                    $scope.queryAllUser();//刷新页面
                }
            ).error(function (response, status) {
                alert('请求错误:'+status);
                if (status == 408) {
                    $scope.has_more = true;
                    $scope.query_flag = true;
                    console.log('超时');
                    alert('超时');
                }
            });
        }
    };
}]);