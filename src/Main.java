import AVL.OperacionesTree;

public class Main {
    public static void main(String[] args) {
        OperacionesTree arbol = new OperacionesTree();
        arbol = new OperacionesTree("1+2");

        System.out.println("PreOrder:");
        System.out.println(arbol.toString(0));

        System.out.println("InOrder:");
        System.out.println(arbol.toString(1));

        System.out.println("PostOrder:");
        System.out.println(arbol.toString(2));

        double resultado = arbol.evaluarExpresion();
        System.out.println("Resultado de la expresión: " + resultado);
    }
}