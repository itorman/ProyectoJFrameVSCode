import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

public class VentanaInforme extends JFrame implements ActionListener {
    
    //atributos
    private JFrame ventanaInforme;
     // incidencias y tecnicos pasados desde ventana principal
    ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();	
    ArrayList<Incidencia> incidencias = new ArrayList<Incidencia>();

   // componentes de la interfaz gráfica
   
    private JLabel titulo;
    
    private JLabel lbIncidenciasCerradas;
    private JTextField txtIncidenciasCerradas;
    private JLabel lbIncidenciasAbiertas;
    private JTextField txtIncidenciasAbiertas;
    private JLabel lbIncidenciasEnProgreso;
    private JTextField txtIncidenciasEnProgreso;
    private JLabel lbTiempoMedioResolucion;
    private JTextField txtTiempoMedioResolucion;
    private JLabel lbTecnicoMasActivo;
    private JTextField txtTecnicoMasActivo;
    private JLabel lbTecnicoMasInactivo;
    private JTextField txtTecnicoMasInactivo;
    
    private JButton btCerrar;

    // constructorque crea la ventana de informes
    public void VentanaInformes() {
        //super("Aplicacion para asignación de incidencias a tecnicos");  --> no es necesario
        super.setTitle("Panel de informes");       
        initComponentes();
    }

    public void initComponentes() {

        ventanaInforme = new JFrame("Panel de informes");
        // inicializo ventana y configuro tamaño
        ventanaInforme.setVisible(true); // hacemos visible la ventana
        ventanaInforme.setSize(700, 400);
        // Posicionamos la ventana en la pantalla
        ventanaInforme.setLocationRelativeTo(null);
        
        

        // Creación de controles gráficos
        titulo = new JLabel("Informes");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 20));

        lbIncidenciasCerradas = new JLabel("% Incidencias cerradas: ");
        lbIncidenciasCerradas.setFont(new Font("Tahoma", Font.PLAIN, 15));

        txtIncidenciasCerradas = new JTextField(5);
        txtIncidenciasCerradas.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtIncidenciasCerradas.setEditable(false);

        lbIncidenciasAbiertas = new JLabel("% Incidencias abiertas: ");
        lbIncidenciasAbiertas.setFont(new Font("Tahoma", Font.PLAIN, 15));

        txtIncidenciasAbiertas = new JTextField(5);
        txtIncidenciasAbiertas.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtIncidenciasAbiertas.setEditable(false);

        lbIncidenciasEnProgreso = new JLabel("% Incidencias en progreso: ");
        lbIncidenciasEnProgreso.setFont(new Font("Tahoma", Font.PLAIN, 15));

        txtIncidenciasEnProgreso = new JTextField(5);
        txtIncidenciasEnProgreso.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtIncidenciasEnProgreso.setEditable(false);

        lbTiempoMedioResolucion = new JLabel("Tiempo medio de resolución: ");
        lbTiempoMedioResolucion.setFont(new Font("Tahoma", Font.PLAIN, 15));

        txtTiempoMedioResolucion = new JTextField(5);
        txtTiempoMedioResolucion.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTiempoMedioResolucion.setEditable(false);

        lbTecnicoMasActivo = new JLabel("Tecnico más activo: ");
        lbTecnicoMasActivo.setFont(new Font("Tahoma", Font.PLAIN, 15));

        txtTecnicoMasActivo = new JTextField(5);
        txtTecnicoMasActivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTecnicoMasActivo.setEditable(false);

        lbTecnicoMasInactivo = new JLabel("Tecnico más inactivo: ");
        lbTecnicoMasInactivo.setFont(new Font("Tahoma", Font.PLAIN, 15));

        txtTecnicoMasInactivo = new JTextField(5);
        txtTecnicoMasInactivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTecnicoMasInactivo.setEditable(false);

        btCerrar = new JButton("Cerrar");
        btCerrar.setFont(new Font("Tahoma", Font.BOLD, 15));
        // asignamos el listener para el botón
        btCerrar.addActionListener(this);
        
        // Disponemos los controles en el panel de la ventana
        ventanaInforme.getContentPane().setLayout(new FlowLayout());
        ventanaInforme.getContentPane().add(titulo);
        ventanaInforme.getContentPane().add(lbIncidenciasCerradas);
        ventanaInforme.getContentPane().add(txtIncidenciasCerradas);
        ventanaInforme.getContentPane().add(lbIncidenciasAbiertas);
        ventanaInforme.getContentPane().add(txtIncidenciasAbiertas);
        ventanaInforme.getContentPane().add(lbIncidenciasEnProgreso);
        ventanaInforme.getContentPane().add(txtIncidenciasEnProgreso);
        ventanaInforme.getContentPane().add(lbTiempoMedioResolucion);
        ventanaInforme.getContentPane().add(txtTiempoMedioResolucion);
        ventanaInforme.getContentPane().add(lbTecnicoMasActivo);
        ventanaInforme.getContentPane().add(txtTecnicoMasActivo);
        ventanaInforme.getContentPane().add(lbTecnicoMasInactivo);
        ventanaInforme.getContentPane().add(txtTecnicoMasInactivo);
        ventanaInforme.getContentPane().add(btCerrar);
    
    }
    // FIN DEL CONSTRUCTOR

    // INICIO MANEJADOR DE EVENTOS

    @Override
    public void actionPerformed(ActionEvent e) {
       // La propia ventana es el manejador de los eventos que se generan en sus controles
		Object o= e.getSource();
		
		if(o.equals(btCerrar)){			
			System.out.println("Cerrar");           
        } else {
            System.out.println("Error de algun tipo");
        }        
    }
}


