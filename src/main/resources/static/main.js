/*1. Declaing module & storing it into varible for feature Use 
var app = angular.module("stApp",[]);*/
var app = angular.module("stApp", [ 'ngRoute' ]);

/* 2. Defining Controller logic for Displaying Title */
app.controller("homeController", function($scope) {
	$scope.title = "Student Appliction";
})

/* 3. Defining footer logic for RootSCope Title */
app.controller("footerController", function($scope, $rootScope) {
	$rootScope.footer = "@ 2019 StudentApp ";
})

/* 4. Clicking User defiend functon */
app.controller("clickController", function($scope) {
	$scope.showdate = function() {
		alert("Hello");
	}
})

/*
 * 5.Now its Time to Configure Template urls with $routeProvider
 * Ref:https://jsfiddle.net/cmckeachie/aq676/
 */
app.config(function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html',
		controller : 'homeController'
	}).when('/add', {
		templateUrl : 'add.html',
		controller : 'addController'
	}).when('/edit', {
		templateUrl : 'edit.html',
		controller : 'editController'
	}).when('/delete', {
		templateUrl : 'delete.html',
		controller : 'deleteController'
	}).when('/show', {
		templateUrl : 'show.html',
		controller : 'showController'
	}).when('/search', {
		templateUrl : 'search.html',
		controller : 'searchController'
	}).when('/mongo', {
		templateUrl : 'mongo.html',
		controller : 'mongoController'
	}).when('/help', {
		templateUrl : 'help.html',
		controller : 'helpController'
	}).otherwise({
		redirectTo : '/'
	});

});

/*
 * 6. Define Each controller Logic ERROR : ReferenceError: $http is not defined
 * SOLUTION: Probably you haven't injected $http service to your controller.
 * There are several ways of doing that
 * 
 * function MyController($scope, $http) { // ... your code } You can also use
 * $inject to add a dependency: var MyController = function($scope, $http) { //
 * ... } MyController.$inject = ['$scope', '$http'];
 * 
 */

app.controller('addController', function($scope, $http) {
	$scope.title = "Add Student";
	$scope.addStudent = function() {
		var method = "POST";
		var url = '/api/add';
		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.studentForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.student = response.data;
			$scope.status = "Student Saved";
		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};
});

/** ------------ EDIT Controller Start ---------------- */
app.controller('editController', function($scope, $http) {
	/*
	 * we need to declare all the varibles with def. values before using them.
	 * otherwise we will get the Error "Angular cannot set property of
	 * undefined"
	 */

	$scope.title = "Edit Student";
	$scope.student = null;
	$scope.studentForm = {
		sno : -1,
		name : "",
		city : "",
		marks : -1
	};
	/* 1.for getting Student by id */
	$scope.getStudent = function(student) {
		var id = $scope.getForm.sno;
		console.log('/api/get/' + id);
		$http({
			method : 'GET',
			url : '/api/get/' + id
		}).then(function successCallback(response) {
			// alert(response.data);
			console.log(response.data);
			$scope.student = response.data;
			console.log($scope.student.sno);
			$scope.studentForm.sno = $scope.student.sno;
			$scope.studentForm.name = $scope.student.name;
			$scope.studentForm.city = $scope.student.city;
			$scope.studentForm.marks = $scope.student.marks;

		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};

	/* updating Student data */
	$scope.updateStudent = function() {
		var method = "POST";
		var url = '/api/update';
		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.studentForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.student = response.data;
			$scope.status = "Data Updated";
		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};

});
/** ------------ EDIT Controller End ---------------- */

/** ------------ Delete Controller Start ---------------- */
app.controller('deleteController', function($scope, $http) {
	/*
	 * we need to declare all the varibles with def. values before using them.
	 * otherwise we will get the Error "Angular cannot set property of
	 * undefined"
	 */

	$scope.title = "Delete Student";
	$scope.student = null;
	$scope.studentForm = {
		sno : -1,
		name : "",
		city : "",
		marks : -1
	};
	/* 1.for getting Student by id */
	$scope.getStudent = function(student) {
		var id = $scope.getForm.sno;
		console.log('/api/get/' + id);
		$http({
			method : 'GET',
			url : '/api/get/' + id
		}).then(function successCallback(response) {
			// alert(response.data);
			console.log(response.data);
			$scope.student = response.data;
			console.log($scope.student.sno);
			$scope.studentForm.sno = $scope.student.sno;
			$scope.studentForm.name = $scope.student.name;
			$scope.studentForm.city = $scope.student.city;
			$scope.studentForm.marks = $scope.student.marks;

		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};

	/* updating Student data */
	$scope.deleteStudent = function() {
		var method = "POST";
		var url = '/api/delete';
		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.studentForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.student = response.data;
			$scope.status = "Student Deleted";
		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};

});
/** ------------ Delete Controller End ---------------- */

app.controller('showController', function($scope, $http) {
	$scope.title = "Show All Students";
	$scope.students = [];
	$http({
		method : 'GET',
		url : '/api/list'
	}).then(function successCallback(response) {
		$scope.students = response.data;
	}, function errorCallback(response) {
		console.log(response.statusText);
	});
});

app.controller('searchController', function($scope, $http) {
	$scope.title = "Search Student";

	/* 1.for getting Student by id */
	$scope.searchStudent = function(student) {
		var id = $scope.getForm.sno;
		console.log('/api/get/' + id);
		$http({
			method : 'GET',
			url : '/api/get/' + id
		}).then(function successCallback(response) {
			// alert(response.data);
			console.log(response.data);
			$scope.student = response.data;

		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};

});

app.controller('helpController', function($scope) {
	$scope.title = "Help Student";
});







