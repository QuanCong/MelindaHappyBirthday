/**
 * Created by songxu on 2016/5/8.
 */
'use strict'
happybirthday.controller('saySomethingController', function($scope,$rootScope,$http) {
    //更新url 为左侧导航栏添加标识
    $rootScope.url = "saySomething";
    $scope.msgs=[];
    //页面绑定
    $scope.nameInput = "";
    $scope.msgInput = "";

    /**
     * 初始化
     */
    var init=function () {
        $scope.getAllMsg();
        $scope.nameInput = "";
        $scope.msgInput = "";

    }
    /**
     * 获取所有的留言信息
     */
    $scope.getAllMsg=function() {
        $http({
            method: 'GET',
            url: '/msg/list'
        }).then(function successCallback(response) {
            $scope.msgs=response.data;

        }, function errorCallback(response) {

        });
    };
    /**
     * 取消
     */
    $scope.cancel=function () {
        $scope.nameInput = "";
        $scope.msgInput = "";
        $("#noDisplay").click();
    }
    /**
     * 提交
     */
    $scope.submit=function () {
        if($scope.nameInput=="") {
            alert("姓名不能为空哦！");
            return;
        }
        if($scope.msgInput=="") {
            alert("留言不能为空哦！");
            return;
        }
        var message={
            name:"",
            msg:"",
            timeString:"",
        };
        //深度复制
        message.name=angular.copy($scope.nameInput);
        message.msg=angular.copy($scope.msgInput);
        $http({
            method: 'POST',
            url: '/msg/add',
            data:message
        }).then(function successCallback(response) {
           if(response.data!="null")
               init();

        }, function errorCallback(response) {

        });

    }

    init();

});