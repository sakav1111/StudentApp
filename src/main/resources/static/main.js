/*1. Declaing module & storing it into varible for feature Use 
var app = angular.module("stApp",[]);*/
var app = angular.module("stApp", ['ngRoute']);


/* 2. Defining Controller logic for Displaying Title */
app.controller("homeController", function($scope){
	$scope.title= "Student Appliction";
})

/* 3. Defining footer logic for RootSCope Title */
app.controller("footerController", function($scope,$rootScope){
	$rootScope.footer= "@ 2019 StudentApp ";
})

/* 4. Clicking User defiend functon */
app.controller("clickController", function($scope){
	$scope.showdate = function(){
		alert("Hello");
	}
})


/*5.Now its Time to Configure Template urls with $routeProvider 
Ref:https://jsfiddle.net/cmckeachie/aq676/
 */
app.config(function($routeProvider) {
	$routeProvider
		.when('/home', {
			templateUrl: 'home.html',
			controller: 'homeController'
		})
		.when('/add', {
			templateUrl: 'add.html',
			controller: 'addController'
		})
		.when('/edit', {
			templateUrl: 'edit.html',
			controller: 'editController'
		})
		.when('/delete', {
			templateUrl: 'delete.html',
			controller: 'deleteController'
		})
		.when('/show', {
			templateUrl: 'show.html',
			controller: 'showController'
		})
		.when('/search', {
			templateUrl: 'search.html',
			controller: 'searchController'
		})
		.when('/help', {
			templateUrl: 'help.html',
			controller: 'helpController'
		})
		.otherwise({
			redirectTo: '/'
		});
	 
});

 /*6. Define Each controller Logic*/
app.controller('addController', function($scope) {	 
	$scope.title = "Add Student";
});

app.controller('editController', function($scope) {	 
	$scope.title = "Edit Student";
});

app.controller('deleteController', function($scope) {	 
	$scope.title = "Delete Student";
});

app.controller('showController', function($scope) {	 
	$scope.title = "Show All Students";
});

app.controller('searchController', function($scope) {	 
	$scope.title = "Search Student";
});

app.controller('helpController', function($scope) {	 
	$scope.title = "Help Student";
});