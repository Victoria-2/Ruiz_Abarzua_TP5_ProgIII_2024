package AVL;

public class AVLTree {
    Nodo raiz;

    Nodo insertar(Nodo nodo, char valor){
        if(nodo == null){
            return new Nodo(valor);
        }

        return nodo;
    }

}
