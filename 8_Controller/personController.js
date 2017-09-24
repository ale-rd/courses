app = angular.module('myApp', []);

app.controller('personCtrl', function($scope){
    $scope.firstName = "Juan";
    $scope.lastName = "Pérez";

    $scope.fullName = function(){
        return $scope.firstName + ' ' + $scope.lastName;
    }
});