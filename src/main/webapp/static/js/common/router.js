/**
 * Created by songxu on 2016/5/8.
 */
'use strict'
happybirthday.config(['$routeProvider',function ($routeProvider) {
    $routeProvider
        .when('/welcome', {
            templateUrl: 'static/html/welcome.html',
            controller: 'welcomeController'
        })
        .when('/saysomething', {
            templateUrl: 'static/html/saysomething.html',
            controller: 'saySomethingController'
        })
        .otherwise({
            redirectTo: '/welcome'
        });
}]);


