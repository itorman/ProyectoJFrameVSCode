// dependencias para entorno de ventanas
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


public class VentanaPrincipal extends JFrame implements ActionListener {
    
    //atributos
    private JFrame ventanaAsignacion;
    private JTextField txtDescripcion;
    private JTextField txtFechaCreacion;
    private Incidencia actual;

    
    // componentes de la interfaz gráfica
    private JLabel lbIncidencias;
    private JComboBox<String> cbIncidencias;
    private JLabel lbTecnicos;
    private JComboBox<String> cbTecnicos;
    private JLabel lbinfoIncidencia;
    private JButton btInformes;

    private JLabel lbDescripcion;   
    private JLabel lbFechaCreacion;
    
    private JLabel lbtecnico;
    private JTextField txtTecnico;
    private JLabel lbEstado;
    private JTextField txtEstado;
    private JLabel lbTiempoResolucion;
    private JTextField txtTiempoResolucion;
    private JButton btActualizar;
    private JButton btAsignar;
    private JButton btCancelar;
    // incidencias y tecnicos    
    ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();	
    ArrayList<Incidencia> incidencias = new ArrayList<Incidencia>();
    // resto atributos
    //ventana informe
    private VentanaInforme ventanaInforme;
    

    // constructorque crea la ventana principal
    public void VentanaPrincipal() {

        //creo los tecnicos
        Tecnico tecnico1 = new Tecnico("Andres Quiron Perez", "NIVEL 1");
        Tecnico tecnico2 = new Tecnico("Alberto Jimenez Garcia", "NIVEL 2");
        //añado los tecnicos a la lista
        tecnicos.add(tecnico1);
        tecnicos.add(tecnico2);
        //anado las incidencias al array de incidencias a la vez que las creo
        incidencias.add(new Incidencia("IC001", "Problema aplicacion Outlook", "02/03/2020", "En progreso", tecnico1));
        incidencias.add(new Incidencia("IC002", "Problema en disco", "07/04/2021", "En progreso", tecnico1));
        incidencias.add(new Incidencia("IC003", "Problema en Sharepoint", "07/04/2021", "En progreso", tecnico1));
        incidencias.add(new Incidencia("IC004", "Problema en Sharepoint", "08/04/2021", "Cerrada", tecnico2));
        incidencias.add(new Incidencia("IC005", "Problema en Adobe", "07/04/2021", "Abierta", null));

        // inicializo con un metodo propio llamado init. este seria parte del constructor
        initComponentes();
    }

    public void initComponentes() {
        // creo la ventana principal
        ventanaAsignacion = new JFrame("Panel de asignacion de incidencias");
        //ventanaAsignacion.setLocationRelativeTo(null);
        ventanaAsignacion.setVisible(true); // hacemos visible la ventana
        ventanaAsignacion.setSize(900, 500);
        //ventanaAsignacion.setBounds(100, 100, 677, 497);
        //ventanaAsignacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         
        // Incidencias
        lbIncidencias = new JLabel("Incidencias");
        lbIncidencias.setFont(new Font("Tahoma", Font.BOLD, 14));
        cbIncidencias = new JComboBox<String>();
        cbIncidencias.setFont(new Font("Tahoma", Font.PLAIN, 10));
        cbIncidencias.addItem("Seleccione una incidencia");
        // añado las incidencias al combobox
        for (Incidencia incidencia : incidencias) {
            cbIncidencias.addItem(incidencia.getId());
        }
        // añado el listener al combobox
        cbIncidencias.addActionListener(this);

        // Tecnicos
        lbTecnicos = new JLabel("Tecnicos");
        lbTecnicos.setFont(new Font("Tahoma", Font.BOLD, 14));
        cbTecnicos = new JComboBox<String>();
        cbTecnicos.setFont(new Font("Tahoma", Font.PLAIN, 10));
        cbTecnicos.addItem("Seleccione un tecnico");
        // añado los tecnicos al combobox
        for (Tecnico tecnico : tecnicos) {
            cbTecnicos.addItem(tecnico.getNombre());
        }
        // añado el listener al combobox
        cbTecnicos.addActionListener(this);

        // Informacion de la incidencia (label)
        lbinfoIncidencia = new JLabel("Informacion de la incidencia -------------------------");
        lbinfoIncidencia.setFont(new Font("Tahoma", Font.BOLD, 14));

        // Boton de informes
        btInformes = new JButton("Informes");
        btInformes.setFont(new Font("Tahoma", Font.ITALIC, 14));
        btInformes.addActionListener(this);

        // Descripcion
        lbDescripcion = new JLabel("Descripcion");
        lbDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtDescripcion = new JTextField();
        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtDescripcion.setColumns(15);

        // Fecha de creacion

        lbFechaCreacion = new JLabel("Creada");
        lbFechaCreacion.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtFechaCreacion = new JTextField();
        txtFechaCreacion.setEditable(false);
        txtFechaCreacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtFechaCreacion.setColumns(10);

        // Tecnico
        lbtecnico = new JLabel("Tecnico");
        lbtecnico.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtTecnico = new JTextField();
        txtTecnico.setEditable(false);
        txtTecnico.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtTecnico.setColumns(15);

        // Estado
        lbEstado = new JLabel("Estado");
        lbEstado.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtEstado = new JTextField();
        txtEstado.setEditable(true);
        txtEstado.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtEstado.setColumns(10);
        // añado el listener a estado
        txtEstado.addActionListener(this);

        // Tiempo de resolucion
        lbTiempoResolucion = new JLabel("Tiempo de resolucion");
        lbTiempoResolucion.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtTiempoResolucion = new JTextField();
        txtTiempoResolucion.setEditable(true);
        txtTiempoResolucion.setFont(new Font("Tahoma", Font.PLAIN, 10));
        // Añado el listener 
        txtTiempoResolucion.addActionListener(this);

        // Boton de actualizar
        btActualizar = new JButton("Actualizar");
        btActualizar.setFont(new Font("Tahoma", Font.ITALIC, 14));
        //añado el listener al boton actualizar
        btActualizar.addActionListener(this);

        // Boton de asignar
        btAsignar = new JButton("Asignar");
        btAsignar.setFont(new Font("Tahoma", Font.ITALIC, 14));
        //añado el listener al boton asignar
        btAsignar.addActionListener(this);

        // Boton de cancelar
        btCancelar = new JButton("Cancelar");
        btCancelar.setFont(new Font("Tahoma", Font.ITALIC, 14));
        //añado el listener al boton cancelar
        btCancelar.addActionListener(this);       
       
        
        
        // Disponemos los controles en el panel de la ventana
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(lbIncidencias);
        this.getContentPane().add(cbIncidencias);
        this.getContentPane().add(lbTecnicos);
        this.getContentPane().add(cbTecnicos);
        this.getContentPane().add(lbinfoIncidencia);
        this.getContentPane().add(btInformes);
        this.getContentPane().add(lbDescripcion);
        this.getContentPane().add(txtDescripcion);
        this.getContentPane().add(lbFechaCreacion);
        this.getContentPane().add(txtFechaCreacion);
        this.getContentPane().add(lbtecnico);
        this.getContentPane().add(txtTecnico);
        this.getContentPane().add(lbEstado);
        this.getContentPane().add(txtEstado);
        this.getContentPane().add(lbTiempoResolucion);
        this.getContentPane().add(txtTiempoResolucion);
        this.getContentPane().add(btActualizar);
        this.getContentPane().add(btAsignar);
        this.getContentPane().add(btCancelar);

        // Aqui se añaden los manejadores de eventos a los controles
        cbIncidencias.addActionListener(this);
        cbTecnicos.addActionListener(this);
        btInformes.addActionListener(this);
        txtEstado.addActionListener(this);
        txtTiempoResolucion.addActionListener(this);
        btActualizar.addActionListener(this);
        btAsignar.addActionListener(this);
        btCancelar.addActionListener(this);
    }
    // FIN DEL CONSTRUCTOR

    // INICIO MANEJADOR DE EVENTOS sobreescrito de la clase JFrame

    @Override
    public void actionPerformed(ActionEvent e) {
       // La propia ventana es el manejador de los eventos que se generan en sus controles
		Object o= e.getSource();
		
		if(o.equals(cbIncidencias)){			
			System.out.println("Selecciono incidencia");
			
        } else if (o.equals(cbTecnicos)) {
            System.out.println("Selecciono tecnico");

        } else if (o.equals(btInformes)) {
            System.out.println("Entro a ventana informes");

        } else if (o.equals(txtEstado)) {
            System.out.println("Actualizo");
            
        } else if (o.equals(txtTiempoResolucion)) {
            System.out.println("Asigno tecnico");
            
        } else if (o.equals(btActualizar)) {
            System.out.println("Actualizo");

        } else if (o.equals(btAsignar)) {
            System.out.println("Asigno");
        
        } else if (o.equals(btCancelar)) {
            System.out.println("Cancelo");
            
        } else {
            System.out.println("Error de algun tipo");
        }
		
    }
}



   
