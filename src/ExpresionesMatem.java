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
    ExpresionesMatem(){
        setFrame();
        configurarAcciones();
    }

    //basico para inicializacion
    private void setFrame(){ //lo que hace es generar la ventana con otros valores iniciales
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel1);
        frame.setSize(225, 220);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    private void configurarAcciones(){
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoTexto.setText( String.valueOf(realizarCalculoArbolAVL()) ); //de un int lo pasa a un String para que se pueda poner el texto en el resultado
            }
        });
    }

    //------------------

    private int realizarCalculoArbolAVL(){

        String expresionAOperar = expresionIngresada.toString();
        for (char valores : expresionAOperar.toCharArray()){

        }

        int resultado = 0;
        return resultado;
    }
}
