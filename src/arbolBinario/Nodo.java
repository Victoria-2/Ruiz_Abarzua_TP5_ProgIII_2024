package arbolBinario;
public class Nodo {
    public Object valor; //es un char porque almacena los '/+*-' y numeros, asi q solo operaciones de un digito
    public Nodo izquierda;
    public Nodo derecha;

    Nodo(Object valor){
        this.valor = valor;
        this.derecha = this.izquierda = null;
    }

}


