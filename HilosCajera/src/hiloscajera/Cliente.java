/*
 
 */
package hiloscajera;

/**
 *
 * @author ArturoExamen
 */
public class Cliente {
     private String nombre;
 private int [] carroCompra;
     public Cliente(){

 }

public Cliente(String nombre, int[] carroCompra){
    this.nombre = nombre;
    this.carroCompra = carroCompra;
}

public int [] getCarroCompra(){
    return carroCompra;
}
public String getNombre(){
    return nombre;
}
public void setCarroCompra(int[] carroCompra){
    this.carroCompra = carroCompra;
}

public void setNombre (String nombre){
    this.nombre = nombre;
}





}
    
