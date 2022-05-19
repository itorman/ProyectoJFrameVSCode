import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

import java.awt.Font;

public class App {

    // create a test class for the Incidencia and Tecnico classes
    public static void main(String[] args) {
       // create a new instance of the Incidencia class
       
       
        //create a new instance of the Tecnico class
        Tecnico tecnico = new Tecnico("Luis Perez", "N1");
        // create a new instance of the Tecnico class
        Tecnico tecnico2 = new Tecnico("Juan Sanchez", "N2");
        // create a new instance of the Tecnico class
        Tecnico tecnico3 = new Tecnico("Igor Eroa", "N3");
        // create a new instance of the Tecnico class
        Tecnico tecnico4 = new Tecnico("Aitor Sanchez", "N2");
        // create a new instance of the Tecnico class

        // print the name of the tecnico
        System.out.println(tecnico.toString());
        System.out.println(tecnico2.toString());
        
        Incidencia incidencia = new Incidencia("IC0001", "Problema de la pantalla", "01/01/2019", "Abierta", tecnico, 0);
        Incidencia incidencia2 = new Incidencia("IC0002", "Wifi no funciona", "02/01/2022", "Cerrada", tecnico4, 120);
        // print the name of the incidencia
        incidencia.setFechaCierre("03/05/2022");
        System.out.println(incidencia.toString());
        System.out.println(incidencia2.toString());
        //crea una ventanaPrincipal
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.setVisible(true);
        //ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
}
