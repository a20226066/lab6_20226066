package pe.edu.pucp.gtics.charlie.entity;
import java.io.Serializable;
public class Simulacion implements Serializable {
 private boolean[][] feromonas;
 private Hormiga hormiga;
 private int movimientos;
 private int aumento;
 public Simulacion(int filas,int columnas,int aumento,Hormiga hormiga){this.feromonas=new boolean[filas][columnas];this.aumento=aumento;this.hormiga=hormiga;}
 public boolean[][] getFeromonas(){return feromonas;} public void setFeromonas(boolean[][] v){feromonas=v;}
 public Hormiga getHormiga(){return hormiga;} public void setHormiga(Hormiga v){hormiga=v;}
 public int getMovimientos(){return movimientos;} public void setMovimientos(int v){movimientos=v;}
 public int getAumento(){return aumento;} public void setAumento(int v){aumento=v;}
 public int getFilas(){return feromonas.length;} public int getColumnas(){return feromonas[0].length;}
}
