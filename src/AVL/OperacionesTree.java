package AVL;

public class OperacionesTree {
    public Nodo raiz;

    public OperacionesTree() {
        this.raiz = null;
    }

    public OperacionesTree(String cadena) {
        raiz = crearArbol(cadena);
    }

    public void crearNodo(char valor) {
        raiz = new Nodo(valor);
    }

    public Nodo crearSubArbol(Nodo valor2, Nodo valor1, Nodo operador) {
        operador.izquierda = valor1;
        operador.derecha = valor2;
        return operador;
    }

    public boolean arbolVacio() {
        return raiz == null;
    }

    private String preOrder(Nodo subArbol, char c) {
        String cadena = " ";
        if (subArbol != null) {
            cadena = c + subArbol.valor.toString() + "\n" + preOrder(subArbol.izquierda, c) + preOrder(subArbol.derecha, c);
        }
        return cadena;
    }

    private String inOrder(Nodo subArbol, char c) {
        String cadena = " ";
        if (subArbol != null) {
            cadena = c + inOrder(subArbol.izquierda, c) + subArbol.valor.toString() + "\n" + inOrder(subArbol.derecha, c);
        }
        return cadena;
    }

    private String postOrder(Nodo subArbol, char c) {
        String cadena = " ";
        if (subArbol != null) {
            cadena = c + postOrder(subArbol.izquierda, c) + postOrder(subArbol.derecha, c) + subArbol.valor.toString() + "\n";
        }
        return cadena;
    }

    private int prioridad(char c) {
        int p = 10;
        switch (c) {
            case '/':
            case '*':
                p = 5;
                break;
            case '+':
            case '-':
                p = 1;
                break;
            default:
                p = 0;
        }
        return p;
    }

    private boolean esOperador(char c) {
        boolean resultado;
        switch (c) {
            case '(':
            case ')':
            case '+':
            case '-':
            case '*':
            case '/':
                resultado = true;
            default:
                resultado = false;
        }
        return resultado;
    }

    private Nodo crearArbol(String cadena) {
        OperacionesPila pilaOperadores;
        OperacionesPila pilaExpresiones;
        Nodo token;
        Nodo operando1;
        Nodo operando2;
        Nodo operador;
        pilaOperadores = new OperacionesPila();
        pilaExpresiones = new OperacionesPila();
        char caracterEvaluado;
        for (int i = 0; i < cadena.length(); i++) {
            caracterEvaluado = cadena.charAt(i);
            token = new Nodo(caracterEvaluado);
            if (!esOperador(caracterEvaluado)) {  //Es un operando
                pilaExpresiones.insertar(token);
            } else { //Es un operador
                switch (caracterEvaluado) {
                    case '(':
                        pilaOperadores.insertar(token);
                        break;
                    case ')':
                        while (!pilaOperadores.pilaVacia() && !pilaOperadores.topePila().valor.equals('(')) {
                            operando2 = pilaExpresiones.quitar();
                            operando1 = pilaExpresiones.quitar();
                            operador = pilaOperadores.quitar();
                            operador = crearSubArbol(operando2, operando1, operador);
                            pilaExpresiones.insertar(operador);
                        }
                        pilaOperadores.quitar();
                        break;
                    default:
                        while (!pilaOperadores.pilaVacia() && prioridad(caracterEvaluado) <= prioridad(pilaOperadores.topePila().valor.toString().charAt(0))) {
                            operando2 = pilaExpresiones.quitar();
                            operando1 = pilaExpresiones.quitar();
                            operador = pilaOperadores.quitar();
                            operador = crearSubArbol(operando2, operando1, operador);
                            pilaExpresiones.insertar(operador);
                        }
                        pilaOperadores.insertar(token);
                }
            }

        }
        while (!pilaOperadores.pilaVacia()) {
            operando2 = pilaExpresiones.quitar();
            operando1 = pilaExpresiones.quitar();
            operador = pilaOperadores.quitar();
            operador = crearSubArbol(operando2, operando1, operador);
            pilaExpresiones.insertar(operador);

        }
        operador = pilaExpresiones.quitar();
        return operador;

    }

    public double evaluarExpresion() {
        return evalua(raiz);
    }
    private double evalua(Nodo subArbol){
        double acumulador=0;
        if (!esOperador(subArbol.valor.toString().charAt(0))){
            return Double.parseDouble(subArbol.valor.toString());
        }else{
            switch(subArbol.valor.toString().charAt(0)) {
                case '*':
                    acumulador = acumulador + evalua(subArbol.izquierda) * evalua(subArbol.derecha);
                    break;
                case '/':
                    acumulador = acumulador + evalua(subArbol.izquierda) / evalua(subArbol.derecha);
                    break;
                case '+':
                    acumulador = acumulador + evalua(subArbol.izquierda) + evalua(subArbol.derecha);
                    break;
                case '-':
                    acumulador = acumulador + evalua(subArbol.izquierda) - evalua(subArbol.derecha);
                    break;
            }
            return acumulador;
        }
    }

}


   /*
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



