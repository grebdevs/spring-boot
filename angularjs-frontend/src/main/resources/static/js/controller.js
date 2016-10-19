/**
 * Created by Pär Svedberg on 2016-10-19.
 */

app.controller('explorerController', function($scope) {
    $scope.headingTitle = "Explore my tiny API!";
});

app.controller('aboutController', function($scope) {
    $scope.headingTitle = "About Pär";
});

app.controller('firstController', function($scope, $http) {
    $http.get('/svedberg/experience/').success(function(data) {
        $scope.greeting = myData;
})