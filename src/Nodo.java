public class Nodo {
    //public Nodo raiz;
    private int valor; //no se si tiene que ir el private o no
    private int altura;
    private Nodo izquierda;
    private Nodo derecha;

    Nodo(int valor){
        this.valor = valor;
        this.altura = 1;
        this.derecha = this.izquierda = null;
    }

}
