'use strict';

/* Controllers */


var app = angular.module('ngdemo');


app.controller('MyCtrl1', ['$scope', '$http', function ($scope, $http) {
	
	$scope.mensagem="";

    $scope.usuario ={
  			"cpf": "",
  			"nome": "",
  			"id": 0,
  			"login": {
    		"usuario": "",
    		"password": ""
  		}};
    
   


    $scope.cadastrar =function(){

    	var headers = {
				'Access-Control-Allow-Origin' : '*',
				'Access-Control-Allow-Methods' : 'POST, GET, OPTIONS, PUT',
				'Content-Type': 'application/json',
				'Accept': 'application/json'};
    	
	    $http({
        url: 'http://educall-crudweb.rhcloud.com/addUsuario',
        method: "POST",
        headers: headers,
        data: {
      			"cpf": this.usuario.cpf,
      			"nome": this.usuario.nome,
      			"id": 0,
      			"login": {
        		"usuario": this.usuario.login.usuario,
        		"password": this.usuario.login.password
      		}}
		    }).success(function(result) {
		    	$scope.usuario.id=result.id;
		    	$scope.mensagem=result;
							
		    }).error(function(data, status, headers, config) {
				$scope.mensagem=data.message;
		    });

    };    
    
  


}]);
