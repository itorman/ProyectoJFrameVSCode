import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaInforme extends JFrame implements ActionListener {
    
    // componentes de la interfaz gráfica
   
    private JLabel titulo;
    private JTextField incidenciasCerradas;    
    private JTextField incidenciasAbiertas;
    private JTextField incidenciasEnProgreso;
    private JTextField tiempoMedioResolucion;
    private JTextField tecnicoMas;
    private JTextField tecnicoMenos;
    private JButton cerrar;
    // incidencias y tecnicos pasados desde ventana principal
    private Incidencia[] incidencias = new Incidencia[5];
    private Tecnico[] tecnicos = new Tecnico[2];
    
    
    // constructorque crea la ventana de informes
    public void VentanaPrincipal() {
        //super("Aplicacion para asignación de incidencias a tecnicos");  --> no es necesario
        super.setTitle("Panel de informes");       
        initComponentes();
    }

    public void initComponentes() {

        // Creación de controles gráficos
        titulo = new JLabel("Informes");
        incidenciasCerradas = new JTextField(10);
        incidenciasAbiertas = new JTextField(10);
        incidenciasEnProgreso = new JTextField(10);
        tiempoMedioResolucion = new JTextField(10);
        tecnicoMas = new JTextField(10);
        tecnicoMenos = new JTextField(10);
        cerrar = new JButton("Cerrar");

        
        // Dimensionamos la ventana principal
        this.setSize(500, 200);
        // Posicionamos la ventana en la pantalla
        this.setLocationRelativeTo(null);
        // Hacemos que la ventana sea visible
        this.setVisible(true);


        // Disponemos los controles en el panel de la ventana
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(titulo);
        this.getContentPane().add(incidenciasCerradas);
        this.getContentPane().add(incidenciasAbiertas);
        this.getContentPane().add(incidenciasEnProgreso);
        this.getContentPane().add(tiempoMedioResolucion);
        this.getContentPane().add(tecnicoMas);
        this.getContentPane().add(tecnicoMenos);
        this.getContentPane().add(cerrar);

        // Aqui se añaden los manejadores de eventos a los controles
        cerrar.addActionListener(this);
        
    }
    // FIN DEL CONSTRUCTOR

    // INICIO MANEJADOR DE EVENTOS

    @Override
    public void actionPerformed(ActionEvent e) {
       // La propia ventana es el manejador de los eventos que se generan en sus controles
		Object o= e.getSource();
		
		if(o.equals(cerrar)){			
			System.out.println("Cerrar");           
        } else {
            System.out.println("Error de algun tipo");
        }
		System.out.println(e.getActionCommand().toString()); // TODO Auto-generated method stub
        
    }
}


