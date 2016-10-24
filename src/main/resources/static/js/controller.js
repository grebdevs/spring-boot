/**
 * Created by Pär Svedberg on 2016-10-19.
 */

app.controller('explorerController', function($scope) {
    $scope.headingTitle = "Explore my tiny API!";
});

app.controller('aboutController', function($scope, $document) {
    $scope.headingTitle = "About Pär";
});

app.controller('firstController', function($scope, $http) {
    $http.get('/svedberg/experience/current').success(function(data) {
        var jsonData = JSON.stringify(data, null, 2);
        $scope.myData = jsonData;
        console.log(jsonData);
        $scope.my_text_area = jsonData;
    })
});