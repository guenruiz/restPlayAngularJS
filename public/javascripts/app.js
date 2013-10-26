var app = angular.module("myApp",['ngResource']);

var ctrl = function Ctrl($scope, $resource)
{
  $scope.misProductos = [];
  
  var Producto = $resource('/productos/:id',
                          {id:'@id'},
                           {
                             update: { method : 'put', isArray : false},
                             delete: { method : 'delete', isArray : false } 
                           }
                  );
  
  $scope.newProducto = new Producto();
    
  $scope.agregar = function()
                   {
                     $scope.newProducto.id 
                       ?
                       $scope.newProducto.$update(function(){
                         $scope.newProducto = Producto();                               
                       })
                       :                     
                         $scope.newProducto.$save(function(data)
                                              {
                                                $scope.misProductos.push($scope.newProducto);
                                                $scope.newProducto = Producto();
                                              });  
                   }
  
  Producto.query(function(data)
                  {
                    $scope.misProductos = data;
                    console.log("Productos del server");
                    console.log(data);
                  });
  
  $scope.update = function(p)
                  {
                    $scope.newProducto = p;
                  }
  
  $scope.borrar = function(p,i)
                  {
                    p.$delete(function()
                              {
                                $scope.misProductos.splice(i,1);
                              }
                             );
                  }
}

app.controller('Ctrl',ctrl);