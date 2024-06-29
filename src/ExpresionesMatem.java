import AVL.OperacionesTree;
import AVL.Nodo;
import AVL.OperacionesPila;
import AVL.Pila;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpresionesMatem {
    private JTextField expresionIngresada;
    private JButton calcularButton;
    private JLabel resultadoTexto;
    private JLabel ingresarExpresionTexto;
    private JPanel panel1;

    private final JFrame frame = new JFrame("Ruiz Abarzua - TP5");

    //constructor
    ExpresionesMatem() {
        setFrame();
        configurarAcciones();
    }

    //basico para inicializacion
    private void setFrame() { //lo que hace es generar la ventana con otros valores iniciales
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel1);
        frame.setSize(225, 220);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void configurarAcciones() {
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoTexto.setText("El resultado es: " + String.valueOf(realizarCalculo())); //de un int lo pasa a un String para que se pueda poner el texto en el resultado
            }
        });
    }

    //------------------

    private int realizarCalculo() {
 /*       AVLTree arbol = new AVLTree();




        /*String expresionAOperar = expresionIngresada.toString();
        for (char valor : expresionAOperar.toCharArray()){
            //tree.root = arbol.insert(tree.root, valor); (?
        }

        int resultado = 0; //esto es para que no salte el error, no va
        return resultado;
    }*/
        return 0;
    }} //Lo puse solo para que no salte error



