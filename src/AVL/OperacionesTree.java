package AVL;

public class OperacionesTree {
    public Nodo raiz;

    public OperacionesTree(){
        this.raiz= null;
    }

    public void InsertarNodo(char valor){ //Inserta un nodo en el arbol
        this.raiz = insertarRecursivo(this.raiz, valor);
    }

    public Nodo insertarRecursivo(Nodo nodo, char valor){
        if (nodo == null){
            return new Nodo(valor);
        }
       return nodo;
    }

    public int evaluarExpresion(){ //Proceso para evaluar la expresion aritmetica del arbol
        return evaluarRecursivo(this.raiz);
    }

    private int evaluarRecursivo(Nodo nodo){ //Recorre y evalua en recursividad
        if (nodo==null){
            return 0;
        }
        return 0; //Valor de retorno temporal
    }

}
