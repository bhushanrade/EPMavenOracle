angular.module('appRoutes', ['ui.router'])
.config(function($stateProvider, $urlRouterProvider,$locationProvider) {
  $urlRouterProvider.otherwise("/login");
        
  //
  // Now set up the states
  $stateProvider
    .state('login', {
      url: "/login",
      templateUrl: "./Login.html",
  controller : "login"
    })
.state('signup', {
      url: "/signup",
      templateUrl: "./signup.html",
  controller : "signup"
    })
.state('showemployee', {
      url: "/showemployee",
      templateUrl: "./showemployee.html",
  controller : "showemployee"
    })
.state('showEmpForAdmin', {
      url: "/showEmpForAdmin",
      templateUrl: "./showEmpForAdmin.html",
  controller : "showemployee"
    })
    
    .state('EmployeeUpdate', {
      url: "/EmployeeUpdate",
      templateUrl: "./EmployeeUpdate.html",
  controller : "EmployeeUpdate"
    })
.state('employeeinfo', {
      url: "/employeeinfo",
      templateUrl: "./employeeinfo.html",
 controller : "employeeinfo"
    });
    
    

});

var App = angular.module('myApp',['appRoutes']);



App.controller('login', ['$scope', '$http', '$state','$rootScope', function($scope,$http,$state,$rootScope) {
alert('in controller');
$scope.login=function(){
var login={email:$scope.email,
          password:$scope.password };
  $http({
  method:'POST',
  url:'http://employeeportal.apps.eu01.cf.canopy-cloud.com/login',
  data:login,
  header:{'Content-Type':'application/json'}
  }).success(function (data, status, headers, config) {
        //alert('success');
$rootScope.employee=data;
if(data.email=="admin@gmail.com")
{
$state.transitionTo('signup');
}
else
{
$state.transitionTo('employeeinfo');
}
    }).error(function (data, status, headers, config) {
        alert(JSON.stringify(data));
    });
};
}]);








App.controller('signup', ['$scope', '$http', '$state','$rootScope', function($scope,$http,$state,$rootScope) {
//alert('in signup controller');
$scope.signup=function(){
var signup={
  id:$scope.id,
  name:$scope.name,
  location:$scope.location,
  contactno:$scope.contactno,
  email:$scope.email,
    password:$scope.password,
  orgunit:$scope.orgunit,
  skills:$scope.skills,
  project:$scope.project   
  };
  
  
  $http({
  method:'POST',
  url:'http://employeeportal.apps.eu01.cf.canopy-cloud.com/registerEmployee',
  data:signup,
  header:{'Content-Type':'application/json'}
  }).success(function (data, status, headers, config) {
        //alert('success!!! Employee Registerd !!!');
$rootScope.employee=data;
$state.transitionTo('signup');
    }).error(function (data, status, headers, config) {
        alert(JSON.stringify(data));
    });
};

$scope.showEmpForAdmin=function()
{
$state.transitionTo('showEmpForAdmin');
};

$scope.logout=function()
{
$rootScope.employee="";
$state.transitionTo('login');
};
  
  
  
  
}]);



App.controller('employeeinfo', ['$scope', '$http', '$state','$rootScope', function($scope,$http,$state,$rootScope) {
//alert('in employeeinfo to employee search controller');
$scope.search=function(){
//alert('in employeeinfo function');
$state.transitionTo('showemployee');
} ;


$scope.logout=function()
{
$rootScope.employee="";
$state.transitionTo('login');
};
  

}]);




App.controller('showemployee', ['$scope', '$http', '$state','$rootScope', function($scope,$http,$state,$rootScope) {
//alert('in showemployee controller !!! READY TO fetch');

  $http({
  method:'GET',
  url:'http://employeeportal.apps.eu01.cf.canopy-cloud.com/employees',
  
  }).success(function (data, status, headers, config) {
      //  alert('success!!! Employee Fetched !!!');
$scope.employees=data;
    }).error(function (data, status, headers, config) {
        alert(JSON.stringify(data));
    });
$scope.remove=function(id,index){
confirm('Do yo Want to DELETE Employee: employee id'+id);
$http({
  method:'DELETE',
  url:'http://employeeportal.apps.eu01.cf.canopy-cloud.com/delete/'+id
  
  }).success(function (data, status, headers, config) {
        //alert('success!!! Employee Fetched !!!');
$scope.employees.splice(index,1);
    }).error(function (data, status, headers, config) {
        alert(JSON.stringify(data));
    });
};

$scope.edit=function(id){
$rootScope.updateId=id;
alert('id'+$rootScope.updateId);
$state.transitionTo('EmployeeUpdate');
} ;

$scope.logout=function()
{
$rootScope.employee="";
$state.transitionTo('login');
};

}]);




App.controller('EmployeeUpdate', ['$scope', '$http', '$state','$rootScope', function($scope,$http,$state,$rootScope) {
//alert('in EmployeeUpdate controller !!! READY TO fetch');
//alert('id in employee update'+$rootScope.updateId);
var uid=$rootScope.updateId;
$http({
  method:'GET',
  url:'http://employeeportal.apps.eu01.cf.canopy-cloud.com/getEmployeeInfo/'+uid
  
  }).success(function (data, status, headers, config) {
        alert('success!!! Employee Information Fetched !!!');
        $scope.employee = data;
    }).error(function (data, status, headers, config) {
        alert(JSON.stringify(data));
        uid="";
        $rootScope.updateId="";
    });


$scope.update=function(){
var employeeupdatedata={
  id:$scope.employee.id,
  name:$scope.employee.name,
  location:$scope.employee.location,
  contactno:$scope.employee.contactno,
  email:$scope.employee.email,
    password:$scope.employee.password,
  orgunit:$scope.employee.orgunit,
  skills:$scope.employee.skills,
  project:$scope.employee.project   
  };
  

  $http({
  method:'POST',
  url:'http://employeeportal.apps.eu01.cf.canopy-cloud.com/updateEmployee',
  data:employeeupdatedata,
  header:{'Content-Type':'application/json'}
  }).success(function (data, status, headers, config) {
        alert('success!!! Employee Registerd f!!!');
$rootScope.employee=data;
$state.transitionTo('showEmpForAdmin');
    }).error(function (data, status, headers, config) {
        alert(JSON.stringify(data));
    });
};

$scope.logout=function()
{
$rootScope.employee="";
$state.transitionTo('login');
};

}]);

