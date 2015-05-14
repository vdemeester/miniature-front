angular
    .module('miniature', ['ngResource'])
    .service('TodosService', function ($log, $resource) {
        return {
            getAll: function () {
                var todoResource = $resource('todos', {}, {
                    query: {method: 'GET', params: {}, isArray: true}
                });
                return todoResource.query();
            }
        }
    })
    .controller('TodosController', function ($scope, $log, TodosService) {
        $scope.todos = TodosService.getAll();
    });
