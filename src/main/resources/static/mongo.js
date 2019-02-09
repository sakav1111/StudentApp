
/** 
=========================================================
			MongoDB Controllers
			
  <button type="button" class="btn btn-primary" ng-click="mongoSave()">Save</button>
  <button type="button" class="btn btn-success" ng-click="mongoUpdate()">Update</button>
  <button type="button" class="btn btn-danger"  ng-click="mongoDelete()">Delete</button>
  <button type="button" class="btn btn-dark btn-lg btn-block" ng-click="mongoGet()">Get</button>
  
=========================================================
 */

/** ------------ Delete Controller Start ---------------- */
app.controller('mongoController', function($scope, $http) {
	

	//=============== ALL STUDENTS, Defalut itt will run at loading time ===========================
	$scope.mongoStudentsList = [];
	$http({
		method : 'GET',
		url : '/mongo/list'
	}).then(function successCallback(response) {
		$scope.mongoStudentsList = response.data;
	}, function errorCallback(response) {
		console.log(response.statusText);
	});

	
	
	$scope.title = "MongoDB Student APPLICATION"
	$scope.student = null;
	$scope.mongoForm = {
		sno : -1,
		name : "",
		city : "",
		marks : -1
	};
	//=============== GET BY ID===========================
	$scope.mongoGet = function(student) {
		var id = $scope.mongoForm.sno;
		console.log('/mongo/get/' + id);
		$http({
			method : 'GET',
			url : '/mongo/get/'+id
		}).then(function successCallback(response) {
			// alert(response.data);
			console.log(response.data);
			$scope.student = response.data;
			console.log($scope.student.sno);
			$scope.mongoForm.sno = $scope.student.sno;
			$scope.mongoForm.name = $scope.student.name;
			$scope.mongoForm.city = $scope.student.city;
			$scope.mongoForm.marks = $scope.student.marks;

		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};
	
	//=============== GET BY ID mongoIdforTable===========================
	$scope.mongoIdforTable = function(sno) {
		console.log('Sno : ' + sno);
		var id = sno;
		console.log('/mongo/get/' + id);
		$http({
			method : 'GET',
			url : '/mongo/get/'+id
		}).then(function successCallback(response) {
			// alert(response.data);
			console.log(response.data);
			$scope.student = response.data;
			console.log($scope.student.sno);
			$scope.mongoForm.sno = $scope.student.sno;
			$scope.mongoForm.name = $scope.student.name;
			$scope.mongoForm.city = $scope.student.city;
			$scope.mongoForm.marks = $scope.student.marks;

		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};
	
	
	
	//===============1. SAVE ===========================
		$scope.mongoSave = function() {
			
		console.log('/mongo/save/' );
			
		var method = "POST";
		var url = '/mongo/save';
		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.mongoForm),
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

	
		
	//=============== UPDATE ===========================
	$scope.mongoUpdate = function() {
				console.log('/mongo/update/' );
		
		$http({
			method :'POST',
			url : '/mongo/update',
			data : angular.toJson($scope.mongoForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.student = response.data;
			$scope.status = "Student Updated";
		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};


	//=============== DELETE ===========================
		$scope.mongoDelete = function() {
					console.log('/mongo/delete/' );
			
			$http({
				method :'POST',
				url : '/mongo/delete',
				data : angular.toJson($scope.mongoForm),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(function successCallback(response) {
				$scope.student = response.data;
				$scope.status = "Student DELETED";
			}, function errorCallback(response) {
				console.log(response.statusText);
			});

		};

	//=========================================================


		//=============== deleteByName ===========================
			$scope.mongoDeleteByName = function() {
						console.log('/mongo/deleteByName/' );
				
				$http({
					method :'POST',
					url : '/mongo/deleteByName/',
					data : angular.toJson($scope.mongoForm),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(function successCallback(response) {
					$scope.student = response.data;
					$scope.status = "Student DELETED";
				}, function errorCallback(response) {
					console.log(response.statusText);
				});

			};

		//=========================================================

			
	
	
});



