
package edu.uan.fis.jeesample.dto;

public class Ordencompra {
    private Integer Idordencompra;
    private String nombre;
    
public Integer getIdordencompra(){
return Idordencompra;
}    
 
public Ordencompra(){}

public Ordencompra(int IdOrden){
this.Idordencompra=IdOrden;
}
public Ordencompra( String nombre, int Idordencompra){
    this.Idordencompra=Idordencompra;
    this.nombre=nombre;
}

public void setIdcompra(Integer Idordencompra){
this.Idordencompra=Idordencompra;
}

public String getNombre(){
return nombre;
}

public void setNombre(String nombre){
this.nombre=nombre;
}
}
