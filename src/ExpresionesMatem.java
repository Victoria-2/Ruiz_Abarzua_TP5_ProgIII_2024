import AVL.OperacionesTree;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpresionesMatem {
    private JTextField expresionIngresada;
    private JButton calcularButton;
    private JLabel resultadoTexto;
    private JLabel ingresarExpresionTexto;
    private JPanel panel1;
    private JButton preOrderButton;
    private JButton inOrderButton;
    private JButton postOrderButton;

    private final JFrame frame = new JFrame("Ruiz Abarzua - TP5");
    OperacionesTree arbol;
    boolean excepcion;

    //constructor
    ExpresionesMatem() {
        setFrame();
        configurarAcciones();
    }

    //basico para inicializacion
    private void setFrame() { //lo que hace es generar la ventana con otros valores iniciales
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel1);
        frame.setSize(500, 250);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void configurarAcciones() {
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    resultadoTexto.setText("El resultado es: " + String.valueOf(realizarCalculo()));
                } catch (NumberFormatException exception){
                    excepcion = true;
                    resultadoTexto.setText("Ingrese una expresion valida sin espacios!");
                }


            }
        });

        preOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(excepcion){
                    resultadoTexto.setText("No se puede calcular sin una expresión valida");
                } else{
                    resultadoTexto.setText("La expresión Pre Order es:" + arbol.toString(0));
                }
            }
        });
        inOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(excepcion){
                    resultadoTexto.setText("No se puede calcular sin una expresión valida");
                } else{
                    resultadoTexto.setText("La expresión Pre Order es:" + arbol.toString(1));
                }
            }
        });
        postOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(excepcion){
                    resultadoTexto.setText("No se puede calcular sin una expresión valida");
                } else{
                    resultadoTexto.setText("La expresión Pre Order es:" + arbol.toString(2));
                }
            }
        });
    }

    //------------------

    private double realizarCalculo() {
        arbol = new OperacionesTree(expresionIngresada.getText());
        return arbol.evaluarExpresion();
    }
}



