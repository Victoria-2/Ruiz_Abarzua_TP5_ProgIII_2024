package AVL;

public class OperacionesTree {
    public Nodo raiz;

    public OperacionesTree(){
        this.raiz= null;
    }
    public int toInt(char c){
        return c - '0';
    }
    public int evaluarExpresion(Nodo nodo){
        if (nodo == null){
            return 0;
        }
        if (nodo.izquierda == null && nodo.derecha == null){
            return toInt(nodo.valor);
        }
        int izquierda = evaluarExpresion(nodo.izquierda);
        int derecha = evaluarExpresion(nodo.derecha);

        switch(nodo.valor){
            case '+':
                return izquierda + derecha;
            case '-':
                return izquierda - derecha;
            case '*':
                return izquierda * derecha;
            case '/':
                return izquierda / derecha;
        }
        return 0;
    }


   /*

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
    */


}
