"use strict";
var privates=angular.module('Pratice',[]);
privates.controller('carController',function ($scope) {
     $scope.cart=[
         {   id:1,
             name:'iphone1',
             quanlity:3,
             price:3400
         }, {   id:2,
             name:'iphone1',
             quanlity:4,
             price:3500
         }, {   id:3,
             name:'iphone1',
             quanlity:5,
             price:3600
         }, {   id:4,
             name:'iphone1',
             quanlity:3,
             price:3400
         }, {   id:5,
             name:'iphone1',
             quanlity:7,
             price:4588
         }
     ];
    /**
     * 计算购物车购物总价
     */
    $scope.totalPrice=function () {
         var total=0;
         angular.forEach($scope.cart,function (item) {
             total+=item.quanlity*item.price;
             //alert("总价为："+total);
         });
         return total;
     };
    /**
     * 计算购物车购物总数量
     */
    $scope.totalQuanlity=function () {
         var total=0;
          angular.forEach($scope.cart,function (item) {
              total+=parseInt(item.quanlity);
              //alert("购物车总数量为："+total);
          });
          return total;
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
     * 移除 购物清单
     */
    $scope.removeOrder=function (id) {
        //alert("id:"+id);
        var index= findIndex(id);
        //表示找到数组下标值
        if(index!==-1){
            //splice() 方法向/从数组中添加/删除项目，然后返回被删除的项目。
           $scope.cart.splice(index,1);//删除当前索引 删除一位
    }
    };
    /**
     * 清空购物车
     */
    /*$scope.clearCart=function () {
         alert("Are you sure clarn all the order of cart?");
         $scope.cart={};//让cart数组为空
    };*/

    /**
     * 增加购物车购物数量
     */
    $scope.reduce=function (id) {
        var index= findIndex(id);
        var items=$scope.cart[index].quanlity;
        if(index!==-1){
            if(items>1){
                --$scope.cart[index].quanlity;//订单数量大于1才减少否则这删除该订单
            }else {
                var returnKey=confirm('您确实删除该订单么？');
                if(returnKey){
                    $scope.removeOrder(id);
                }
            }
        }
    };

    /**
     * 增加购物车购物数量
     */
    $scope.add=function (id) {
        var index= findIndex(id);
        if(index!=-1){
            ++$scope.cart[index].quanlity;
        }
    };
    /**
     * 检查数据输入合法性
     */
    $scope.$watch('cart',function (newValue,oldValue) {
        angular.forEach(newValue,function (item,key) {
            var quality= parseInt(item.quanlity);
             if(item.quanlity<1 || !quality){
                 var returnKey=alert("您输入的数据不合法请检查");
                 item.quanlity=oldValue[key].quanlity;
                 /*if(returnKey){
                    $scope.removeOrder(item.id);
                 }else {
                     item.quanlity=oldValue[key].quanlity;
                 }*/
             }
        });
    },true);


});

