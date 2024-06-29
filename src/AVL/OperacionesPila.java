package AVL;

public class OperacionesPila {
    private Pila tope;

    public OperacionesPila(){
        this.tope = null;
    }

    public void insertar(Nodo elemento){
        Pila nuevo;
        nuevo = new Pila(elemento); //Primer token para la pila
        nuevo.siguiente=tope;
        tope=nuevo; //Nuevo nodo que creamos
    }

    public boolean pilaVacia(){ //Metodo para verificar que la pila esta vacia
        return tope==null;
    }

    public Nodo topePila(){
        return tope.valor;
    }

    public Nodo quitar(){
        Nodo aux= null;
        if (!pilaVacia()){ //Mientras la pila no esta vacia podemos sacar el valor
            aux=tope.valor;
            tope=tope.siguiente;
        }
        return aux;
    }



}
