package arbolBinario;

public class OperacionesTree {
    public Nodo raiz;

    //----------CONSTRUCTOR-------
    public OperacionesTree() {
        this.raiz = null;
    }
    public OperacionesTree(String cadena) {
        raiz = crearArbol(cadena);
    }

    //----------OTROS-------
    public void crearNodo(Object valor) {
        raiz = new Nodo(valor);
    }
    public boolean arbolVacio() {
        return raiz == null;
    }

    //--------------FORMAS DE IMPRIMIR-----------------//
    private String preOrder(Nodo subArbol, String c) {
        String cadena = "";
        if (subArbol != null) {
            cadena = c + subArbol.valor.toString() + preOrder(subArbol.izquierda, c) + preOrder(subArbol.derecha, c); //A la cadena le agrego el dato que tiene la raiz, con el prefijo del subarbol izquierdo + derecho
        }
        return cadena;
    }
    private String inOrder(Nodo subArbol, String c) {
        String cadena = "";
        if (subArbol != null) {
            cadena = c + inOrder(subArbol.izquierda, c) + " " + subArbol.valor.toString() + inOrder(subArbol.derecha, c);
        }
        return cadena;
    }
    private String postOrder(Nodo subArbol, String c) {
        String cadena = "";
        if (subArbol != null) {
            cadena = c + postOrder(subArbol.izquierda, c) + postOrder(subArbol.derecha, c) + subArbol.valor.toString() + " ";
        }
        return cadena;
    }

    //-------------------------------//

    public String toString(int a){ //Parametro para poder imprimir las tres formas de arbol binario
        String cadena= " ";
        switch(a){
            case 0:
                cadena=preOrder(raiz, cadena);
                break;
            case 1:
                cadena=inOrder(raiz, cadena);
                break;
            case 2:
                cadena=postOrder(raiz, cadena);
                break;
        }
        return cadena;
    }
    private int prioridad(char c) { //Verifica las prioridades de los operadores
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

    //--------------ARBOLES-----------------//
    public Nodo crearSubArbol(Nodo valor2, Nodo valor1, Nodo operador) { //Estructura del sub arbol
        operador.izquierda = valor1;
        operador.derecha = valor2;
        return operador;
    }
    private Nodo crearArbol(String cadena) {
        OperacionesPila pilaOperadores = new OperacionesPila();
        OperacionesPila pilaExpresiones = new OperacionesPila();
        Nodo token;
        Nodo operando1;
        Nodo operando2;
        Nodo operador;
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

    //----------EVALUAR OPERADORES------
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
                break;
            default:
                resultado = false;

        }
        return resultado;
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

