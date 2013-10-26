package models;


import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;



@Entity
public class Producto extends Model{
  
  
  public String nombre;
  public Double precio;
  
  
  public Producto(String nombre, Double precio){
    
    this.nombre = nombre;
    this.precio = precio;
    
  }
  
  
}