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
import java.awt.Font;


public class VentanaPrincipal extends JFrame implements ActionListener {
    
    //atributos
    private JTextField txtDescripcion;
    private JTextField txtFechaCreacion;
    private Incidencia actual;
    private Tecnico tecnicoActual ;

    
    // componentes de la interfaz gráfica
    private JLabel lbIncidencias;
    private JComboBox<Incidencia> cbIncidencias;
    private JLabel lbTecnicos;
    private JComboBox<Tecnico> cbTecnicos;
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
    

    // constructor que crea la ventana principal
    public VentanaPrincipal() {

        super("Ventana asignacion de incidencias");
        //creo los tecnicos
        Tecnico tecnico1 = new Tecnico("Andres Quiron Perez", "NIVEL 1");
        Tecnico tecnico2 = new Tecnico("Alberto Jimenez Garcia", "NIVEL 2");
        //añado los tecnicos a la lista
        tecnicos.add(tecnico1);
        tecnicos.add(tecnico2);
        //anado las incidencias al array de incidencias a la vez que las creo
        incidencias.add(new Incidencia("IC001", "Problema aplicacion Outlook", "02/03/2020", "En progreso", tecnico1, 0));
        incidencias.add(new Incidencia("IC002", "Problema en disco", "07/04/2021", "En progreso", tecnico1, 0));
        incidencias.add(new Incidencia("IC003", "Problema en Sharepoint", "07/04/2021", "Cerrada", tecnico1, 120));
        incidencias.add(new Incidencia("IC004", "Problema en Sharepoint", "08/04/2021", "Abierta", null, 0));
        incidencias.add(new Incidencia("IC005", "Problema en Adobe", "07/04/2021", "Abierta", null, 0));
        // la incidencia por defecto es la primera
        //Incidencia actual = incidencias.get(0);
        // inicializo con un metodo propio llamado init. este seria parte del constructor
        initComponentes();
    }

    public void initComponentes() {
        
        
        // inicio la incidencia actual que se mostrara en la ventana
        
        // creo la ventana principal
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1150, 300);
             
        // Incidencias
        lbIncidencias = new JLabel("Incidencias");
        lbIncidencias.setFont(new Font("Tahoma", Font.BOLD, 14));
        cbIncidencias = new JComboBox<Incidencia>();
        cbIncidencias.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        // añado las incidencias al combobox
        for (Incidencia incidencia : incidencias) {
            cbIncidencias.addItem(incidencia);
        }
        // añado el listener al combobox
        cbIncidencias.addActionListener(this);

        // Tecnicos
        lbTecnicos = new JLabel("Tecnicos");
        lbTecnicos.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        
        cbTecnicos = new JComboBox<Tecnico>();
        cbTecnicos.setFont(new Font("Tahoma", Font.PLAIN, 10));
        //cbTecnicos.addItem("Seleccione un tecnico");
        // añado los tecnicos al combobox
        for (Tecnico tecnico : tecnicos) {
            cbTecnicos.addItem(tecnico);
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
        txtDescripcion.setColumns(20);
        //txtDescripcion.setText(actual.getDescripcion());  --debo establecer aqui? u en otro sitio

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
        txtTiempoResolucion.setColumns(5);
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

        this.setVisible(true);
        
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
        Object o = e.getSource();

        if (o.equals(cbIncidencias)) {
            // Se ha pulsado el combo de incidencias
            // Selecciono una incidencia
            actual = (Incidencia) cbIncidencias.getSelectedItem();
            // Actualizo los campos de texto
            txtDescripcion.setText(actual.getDescripcion());
            txtFechaCreacion.setText(actual.getFechaCreacion().toString());
            if (actual.getTecnico() == null) {
                txtTecnico.setText("");                
            }
            else {
                txtTecnico.setText(actual.getTecnico().getNombre());                
            }         
            txtEstado.setText(actual.getEstado());
            int tiempo = actual.getTiempoResolucion();
            if (tiempo == 0) {
                txtTiempoResolucion.setText("");
            } else txtTiempoResolucion.setText(Integer.toString(tiempo));
            
            
        } else if (o.equals(cbTecnicos)) {
            // Se ha pulsado el combo de tecnicos
            // Selecciono un tecnico
            tecnicoActual = (Tecnico) cbTecnicos.getSelectedItem();
            

        } else if (o.equals(btInformes)) {
            System.out.println("Entro a ventana informes");
            // Creo la ventana de informes
            VentanaInforme ventanaInforme = new VentanaInforme(tecnicos, incidencias);
            


        } else if (o.equals(txtEstado)) {
            // Se ha pulsado el campo de estado
            System.out.println("Actualizo");

        } else if (o.equals(txtTiempoResolucion)) {
            // Se ha pulsado el campo de tiempo de resolucion
            System.out.println("Asignado tiempo de resolucion");
            

        } else if (o.equals(btActualizar)) {
            System.out.println("Actualizo");
            String tiempoString;
            int tiempo;
            tiempoString = txtTiempoResolucion.getText();
            // convertir tiempoString a int
            try {
                tiempo = Integer.parseInt(tiempoString);
            } catch (NumberFormatException e1) {
                tiempo = 0;
            }
            // Actualizo el tiempo de resolucion de la incidencia
            actual.setTiempoResolucion(tiempo);
            actual.setEstado("Cerrada");

        } else if (o.equals(btAsignar)) {
            //  Asigno el tecnico a la incidencia
            System.out.println("Asigno tecnico");
            actual.setTecnico(tecnicoActual);
            txtTecnico.setText(actual.getTecnico().getNombre());

        } else if (o.equals(btCancelar)) {
            System.out.println("Cancelo");

        } else {
            System.out.println("Error de algun tipo");
        }

    }
    
}