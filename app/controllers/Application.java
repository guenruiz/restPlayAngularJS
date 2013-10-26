package controllers;

import play.*;
import play.mvc.*;
import java.util.*;  
import models.*;
import com.google.gson.*;

public class Application extends Controller {

    public static void index() {
      render();
    }
  
    public static void productos() {
        
        List<Producto> productos = Producto.findAll();
        renderJSON(productos);
              
    }
  
    public static void deleteProducto(Long id) {
      
        Producto p = Producto.findById(id);
      
        if(p!=null){
            p.delete();
            renderJSON(id);
        }else{
            id *= -1;
        }
        
        renderJSON(id);
    }
  
    public static void saveProducto() {
      
        Gson g = new Gson();
        Producto newProducto = g.fromJson(params.get("body"), Producto.class);
        newProducto.save();
        renderJSON(newProducto);
      
    }
  
    public static void updateProducto(Long id) {
      
        Gson g = new Gson();
      
        Producto newProducto = g.fromJson(params.get("body"), Producto.class);
        Producto dbProducto = Producto.findById(id);
        
        dbProducto.nombre = newProducto.nombre;
        dbProducto.precio = newProducto.precio;
      
        dbProducto.save();
        renderJSON(dbProducto);
      
    }

}