package pe.edu.pucp.gtics.charlie.entity;
import java.io.Serializable;
public class Hormiga implements Serializable {
 private int fila, columna, direccion; // 0=N,1=R,2=S,3=L
 public Hormiga(){}
 public Hormiga(int f,int c,String d){fila=f;columna=c;direccion=convertir(d);}
 private int convertir(String d){return switch(d==null?"R":d.toUpperCase()){case "N","U"->0;case "S","D"->2;case "L","I"->3;default->1;};}
 public int getFila(){return fila;} public void setFila(int v){fila=v;}
 public int getColumna(){return columna;} public void setColumna(int v){columna=v;}
 public int getDireccion(){return direccion;} public void setDireccion(int v){direccion=v;}
 public String getSimbolo(){return switch(direccion){case 0->"↑";case 1->"→";case 2->"↓";default->"←";};}
}
