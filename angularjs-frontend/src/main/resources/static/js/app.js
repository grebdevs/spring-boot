/**
 * Created by Pär Svedberg on 2016-10-19.
 */

var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/explorer',{
            templateUrl: '/views/explorer.html',
            controller: 'explorerController'
        })
        .when('/about',{
            templateUrl: '/views/about.html',
            controller: 'aboutController'
        })
        .when('/',{
            templateUrl: 'views/first.html',
            controller: 'firstController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});