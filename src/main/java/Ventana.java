import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements Runnable {

    private JButton buttonClearArea;
    private JTextArea textAreaGrande;
    private JPanel panel;
    private JTextField palabra;
    private JLabel palabraEncontrar;
    private JLabel coincidenciasLabel;
    private JLabel contador;
    private JButton limbiarPalabra;
    private JButton buttonSalir;

    public Ventana() {

        setSize(600, 400);
        setLocationRelativeTo(null); //Centrar la ventna en la pantalla
        setContentPane(panel);
        setVisible(true);
        setTitle("Contador de Palabras");

        //Accion del boton limpiar el texto, con un mensaje que se ha borrado el texto
        buttonClearArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textAreaGrande.setText("");
                JOptionPane.showMessageDialog(null, "Texto Borrado");
            }
        });

        //Accion del boton borrar palabra
        limbiarPalabra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                palabra.setText("");
                contador.setText("0");
            }
        });

        //Accion del boton salir, se sale de la aplicacion
        buttonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /* Metodo para comprobar el texto con la palabra a buscar.
        Usamos el espacio vacio detrás de una palabara para contar palabras, no parte de una palabra
        Tuve crear otra variable String str2 porque sino contaba los espacios vacios tambien*/

    public void checkPalabras() {
        String str = textAreaGrande.getText();
        str = StringUtils.lowerCase(str);
        String str2 = palabra.getText() + " ";
        if (!str2.equals(" ")) {
            int coincidencias = StringUtils.countMatches(str, str2);
            contador.setText(String.valueOf(coincidencias));
        }
    }

    /*creamos el metodo run(), obliglado en esta clase porque hemos implementado la interfaz Runnable
     aqui le decimos que ejecute el metodo checkPalabras cominado con el metodo Thread.sleep para ralentizarlo
     durante 5 segundos las comprobaciones que se hace sobre el texto*/
    public void run() {
        while (true) {
            checkPalabras();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
