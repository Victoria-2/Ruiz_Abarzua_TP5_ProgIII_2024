package AVL;

public class Nodo {
    char valor; //es un char porque almacena los '/+*-' y numeros, asi q solo operaciones de un digito
    int altura; //no se si tiene que ir el private o no
    Nodo izquierda;
    Nodo derecha;

    Nodo(char valor){
        this.valor = valor;
        this.altura = 1;
        this.derecha = this.izquierda = null;
    }

}
