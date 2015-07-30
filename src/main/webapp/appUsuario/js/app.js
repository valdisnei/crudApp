'use strict';

var module = angular.module('ngdemo', [ 'ngRoute' ]);

		module.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.
				when('/login', {
				templateUrl : 'login.html',
				controller : 'loginCtrl'
			}).			
				when('/cadastro', {
				templateUrl : 'cadastroUsuario.html',
				controller : 'MyCtrl1'
			}).			
				when('/pagina1', {
				templateUrl : 'pagina1.html',
				controller : 'loginCtrl'					
			}).otherwise({
				redirectTo : '/login'
			})			
		} ]);
		
		
		module.run(['$rootScope', function($rootScope) {
		    $rootScope.page = {
		        setTitle: function(title) {
		            this.title = title ;
		        }
		    }
		    $rootScope.$on('$routeChangeSuccess', function(event, current, previous) {
		        $rootScope.page.setTitle('App Crud ');
		    });
		}]);		
		

module.controller(
				'loginCtrl',
				[
						'$scope',
						'$http',
						'$window',
						function($scope, $http, $window) {

							$scope.mensagem = "";
							
							$scope.page.setTitle(" valdis App");

							$scope.usuario = {
								"cpf" : "",
								"nome" : "",
								"id" : 0,
								"login" : {
									"usuario" : "",
									"password" : ""
								}
							};

							$scope.login = function() {

								var headers = {
									'Access-Control-Allow-Origin' : '*',
									'Access-Control-Allow-Methods' : 'POST, GET, OPTIONS, PUT',
									'Content-Type' : 'application/json',
									'Accept' : 'application/json'
								};

								$http(
										{
											url : 'http://crudweb-educall.rhcloud.com/login',
											method : "PATCH",
											headers : headers,
											  data: {
									        		"usuario": this.usuario.login.usuario,
									        		"password": this.usuario.login.password
									      			}
										}).success(function(result) {
									$scope.mensagem = result;
									$window.location.href = '#/pagina1';
								})
										.error(
												function(data, status, headers,
														config) {
													$scope.mensagem = data.message;
												});

							};

							$scope.limpar = function() {
								$scope.mensagem = '';
								$scope.usuario = {
									"cpf" : "",
									"nome" : "",
									"id" : 0,
									"login" : {
										"usuario" : "",
										"password" : ""										
									}
								};

							}

						} ]);



