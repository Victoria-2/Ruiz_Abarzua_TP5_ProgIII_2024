package AVL;
public class Nodo {
    Object valor; //es un char porque almacena los '/+*-' y numeros, asi q solo operaciones de un digito
    Nodo izquierda;
    Nodo derecha;

    Nodo(Object valor){
        this.valor = valor;
        this.derecha = this.izquierda = null;
    }

}


