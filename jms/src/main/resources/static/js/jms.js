/**
 * Created by Pär Svedberg on 2016-11-02.
 */

var myApp = angular.module('myApp', []);

myApp.controller('pubController', function ($scope, $http) {
    var resetForm = function () {
        $scope.pub.queue = "";
        $scope.pub.message = "";
        $scope.pubForm.$setPristine();
    }
    $scope.publish = function () {
        $http.post('/produce', null, {
                params: { queue: $scope.pub.queue, msg: $scope.pub.message }
            }).then(resetForm());

    }
});

myApp.controller('subController', function ($scope, $http) {
    $scope.messages = [{queue: "foo", msg: "bar"}];

    $scope.receive = function () {
        $http.get('/receive',
            {params: { queue: $scope.queue }}
        ).success(function (data) {
            console.log(data)
            $scope.messages.push(data);

        })
    }

});