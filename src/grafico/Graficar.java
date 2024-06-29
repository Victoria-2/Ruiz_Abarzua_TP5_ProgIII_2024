package grafico;
import arbolBinario.Nodo;
import arbolBinario.OperacionesTree;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Graficar extends JPanel{
    private OperacionesTree arbol;
    public static final int diametro = 30;
    public static final int radio = diametro/2;
    public static final int ancho = 30;

    public void setArbol(OperacionesTree arbol){
        this.arbol = arbol;
        repaint();
    }

    @Override
    public void paint(Graphics grafico){
        super.paint(grafico);
        Nodo nodoRaiz = arbol.raiz;
        dibujarNodos(grafico, getWidth()/2, 20, nodoRaiz);
    }

    public void dibujarNodos(Graphics grafico, int x, int y, arbolBinario.Nodo subArbol){
        if(subArbol != null){
            int espExtra = ancho * 3;
            grafico.drawOval(x,y, diametro, diametro);
            grafico.drawString(subArbol.valor.toString(),x+12,y+18);

            if(subArbol.izquierda != null){
                grafico.drawLine(x, y+radio, x+radio-ancho-espExtra, y+ancho);
            }
            if(subArbol.derecha != null){
                grafico.drawLine(x+diametro, y+radio, x+radio+ancho+espExtra, y+ancho);
            }

            dibujarNodos(grafico, x-ancho-espExtra, y+ancho,subArbol.izquierda);
            dibujarNodos(grafico, x+ancho+espExtra, y+ancho,subArbol.derecha);

        }
    }

}
