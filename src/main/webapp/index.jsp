<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<!--
亲爱的李欢：
希望你能快乐每一天！就像我曾经看到的你一样。
多么希望能每天都能看到你
-->
<html>
<head>

  <meta charset="utf-8">

  <title>生日快乐</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="static/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="static/css/font-awesome.min.css">

  <!-- Theme style -->
  <link rel="stylesheet" href="static/css/AdminLTE.min.css">
  <link rel="stylesheet" href="static/css/skin-blue.min.css">

</head>
<!--

-->
<body ng-app="happybirthday" class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="#" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>李</b>欢</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>生日</b>快乐</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a style="" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

       <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">

            <!--网易云音乐-->
            <li class="dropdown tasks-menu" >

                <iframe
                frameborder="no"
                border="0" marginwidth="0"
                marginheight="0" width=298 height=40
                src="http://music.163.com/outchain/player?type=2&id=16607021&auto=1&height=32">
                </iframe>
            </li>


          </ul>
       </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="static/img/lihuan.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p> Melinda</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i>1991-07-22</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">导航</li>
        <!-- Optionally, you can add icons to the links -->
        <li ng-class="{'active':url=='welcome'}"><a href="/#/welcome"><i class="fa fa-birthday-cake"></i> <span>for you</span></a></li>
        <li ng-class="{'active':url=='saySomething'}"><a href="/#/saysomething"><i class="fa fa-commenting-o"></i> <span>留言板</span></a></li>
       <!-- <li></li>-->
      </ul>
      <!-- /.sidebar-menu -->

    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div   class="content-wrapper">
        <div ng-view></div>
  </div>
  <!-- /.content-wrapper -->





<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.0 -->
<script src="static/js/foundation/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="static/js/foundation/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="static/js/foundation/app.min.js"></script>
<!--AngularJS-->
<script src="static/js/foundation/angular.min.js"></script>
<script src="static/js/foundation/angular-route.min.js"></script>

<script src="static/js/foundation/angular-animate.min.js"></script>


<!--personal-->
<script src="static/js/common/main.js"></script>
<script src="static/js/common/router.js"></script>
<script src="static/js/common/welcomeController.js"></script>
<script src="static/js/common/saySomethingController.js"></script>
<!--welcomepage-->


</body>
</html>
