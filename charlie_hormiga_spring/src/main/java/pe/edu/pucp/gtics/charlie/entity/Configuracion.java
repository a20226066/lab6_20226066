package pe.edu.pucp.gtics.charlie.entity;
import java.io.Serializable;
public class Configuracion implements Serializable {
 private int filas=5, columnas=5, aumento=4, filaInicial=2, columnaInicial=2;
 private String direccion="R";
 private int fotosPorActualizacion=10;
 public int getFilas(){return filas;} public void setFilas(int v){filas=v;}
 public int getColumnas(){return columnas;} public void setColumnas(int v){columnas=v;}
 public int getAumento(){return aumento;} public void setAumento(int v){aumento=v;}
 public int getFilaInicial(){return filaInicial;} public void setFilaInicial(int v){filaInicial=v;}
 public int getColumnaInicial(){return columnaInicial;} public void setColumnaInicial(int v){columnaInicial=v;}
 public String getDireccion(){return direccion;} public void setDireccion(String v){direccion=v;}
 public int getFotosPorActualizacion(){return fotosPorActualizacion;} public void setFotosPorActualizacion(int v){fotosPorActualizacion=v;}
}
