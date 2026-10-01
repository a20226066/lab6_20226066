package pe.edu.pucp.gtics.charlie.service;
import org.springframework.stereotype.Service;
import pe.edu.pucp.gtics.charlie.entity.*;
@Service
public class CharlieService {
 public Simulacion crear(Configuracion c){
   if(c.getFilas()<1||c.getColumnas()<1||c.getAumento()<1) throw new IllegalArgumentException("Dimensiones y aumento deben ser positivos");
   if(c.getFilaInicial()<0||c.getFilaInicial()>=c.getFilas()||c.getColumnaInicial()<0||c.getColumnaInicial()>=c.getColumnas()) throw new IllegalArgumentException("La posición inicial está fuera de la zona");
   return new Simulacion(c.getFilas(),c.getColumnas(),c.getAumento(),new Hormiga(c.getFilaInicial(),c.getColumnaInicial(),c.getDireccion()));
 }
 public void avanzar(Simulacion s,int cantidad){for(int i=0;i<cantidad;i++) paso(s);}
 private void paso(Simulacion s){
   Hormiga h=s.getHormiga(); boolean hayFeromona=s.getFeromonas()[h.getFila()][h.getColumna()];
   if(!hayFeromona){s.getFeromonas()[h.getFila()][h.getColumna()]=true; h.setDireccion((h.getDireccion()+1)%4);} // miga -> feromona y derecha
   else {s.getFeromonas()[h.getFila()][h.getColumna()]=false; h.setDireccion((h.getDireccion()+3)%4);} // feromona -> miga e izquierda
   int nf=h.getFila()+new int[]{-1,0,1,0}[h.getDireccion()];
   int nc=h.getColumna()+new int[]{0,1,0,-1}[h.getDireccion()];
   if(nf<0||nc<0||nf>=s.getFilas()||nc>=s.getColumnas()){expandir(s,nf,nc);}
   else {h.setFila(nf);h.setColumna(nc);}
   s.setMovimientos(s.getMovimientos()+1);
 }
 private void expandir(Simulacion s,int nf,int nc){
   int add=s.getAumento(); int top=nf<0?add:0, left=nc<0?add:0;
   int newRows=s.getFilas()+add, newCols=s.getColumnas()+add;
   boolean[][] nuevo=new boolean[newRows][newCols];
   for(int r=0;r<s.getFilas();r++) System.arraycopy(s.getFeromonas()[r],0,nuevo[r+top],left,s.getColumnas());
   s.setFeromonas(nuevo);
   s.getHormiga().setFila(nf+top); s.getHormiga().setColumna(nc+left);
 }
}
