'use strict';

var module = angular.module('ngdemo', [ 'ngRoute' ])
		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.
				when('/login', {
				templateUrl : 'login.html',
				controller : 'loginCtrl'
			}).			
				when('/cadastro', {
				templateUrl : 'cadastroUsuario.html',
				controller : 'MyCtrl1'
			}).otherwise({
				redirectTo : '/login'
			})
		} ]);

module.controller(
				'loginCtrl',
				[
						'$scope',
						'$http',
						'$window',
						function($scope, $http, $window) {

							$scope.mensagem = "";						

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
											url : 'http://salty-dawn-2852.herokuapp.com/login',
											method : "POST",
											headers : headers,
											  data: {
									        		"usuario": this.usuario.login.usuario,
									        		"password": this.usuario.login.password
									      			}
										}).success(function(result) {
									$scope.mensagem = result;
//									$window.location.href = '#/outraTela';
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

