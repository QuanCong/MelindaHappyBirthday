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
     * 定义日期格式化输出
     * @param fmt
     * @returns {*}
     * @constructor
     */
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
            "H+" : this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
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
            //因阿里云存在bug 目前只能用date转换一次
            for(var i=0;i<$scope.msgs.length;i++){
                var date=new Date($scope.msgs[i].date);
                $scope.msgs[i].timeString=date.Format("yyyy-MM-dd HH:mm:ss");
            }

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