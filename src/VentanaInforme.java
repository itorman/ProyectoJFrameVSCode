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
    ArrayList<Tecnico> tecnicos;	
    ArrayList<Incidencia> incidencias;

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

    // constructorque crea la ventana de informes. Recibe por parametro los arrays de tecnicos y incidencias
    public VentanaInforme(ArrayList<Tecnico> tecnicos, ArrayList<Incidencia> incidencias) {
        super("Ventana de informes");  
        this.tecnicos = tecnicos;
        this.incidencias = incidencias;              
        initComponentes();
    }

    public void initComponentes() {

        // inicializo ventana y configuro tamaño
       
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(700, 400);

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
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(titulo);
        this.getContentPane().add(lbIncidenciasCerradas);
        this.getContentPane().add(txtIncidenciasCerradas);
        this.getContentPane().add(lbIncidenciasAbiertas);
        this.getContentPane().add(txtIncidenciasAbiertas);
        this.getContentPane().add(lbIncidenciasEnProgreso);
        this.getContentPane().add(txtIncidenciasEnProgreso);
        this.getContentPane().add(lbTiempoMedioResolucion);
        this.getContentPane().add(txtTiempoMedioResolucion);
        this.getContentPane().add(lbTecnicoMasActivo);
        this.getContentPane().add(txtTecnicoMasActivo);
        this.getContentPane().add(lbTecnicoMasInactivo);
        this.getContentPane().add(txtTecnicoMasInactivo);
        this.getContentPane().add(btCerrar);

        this.setVisible(true); // hacemos visible la ventana
        

        // Calculamos los datos de los informes
        calcularInformes(tecnicos, incidencias);
        
    }
    // FIN DEL CONSTRUCTOR

    // Método que calcula los datos de los informes
    private void calcularInformes(ArrayList<Tecnico> tecnicos, ArrayList<Incidencia> incidencias) {
        // Calculamos el porcentaje de incidencias cerradas
        double numIncidenciasCerradas = 0;
        double numIncidenciasAbiertas = 0;
        double numIncidenciasEnProgreso = 0;
        int numIncidencias = incidencias.size();
        for (int i = 0; i < numIncidencias; i++) {
            Incidencia incidencia = (Incidencia) incidencias.get(i);
            if (incidencia.getEstado().equals("Cerrada")) {
                numIncidenciasCerradas++;
            } else if (incidencia.getEstado().equals("Abierta")) {
                numIncidenciasAbiertas++;
            } else if (incidencia.getEstado().equals("En progreso")) {
                numIncidenciasEnProgreso++;
            }
        }

        numIncidenciasCerradas = (int) (numIncidenciasCerradas / numIncidencias *100);
		numIncidenciasAbiertas = (int) (numIncidenciasAbiertas / numIncidencias *100);
        numIncidenciasEnProgreso = (int) (numIncidenciasEnProgreso / numIncidencias * 100);
        
        txtIncidenciasCerradas.setText(Double.toString(numIncidenciasCerradas));
        txtIncidenciasAbiertas.setText(Double.toString(numIncidenciasAbiertas));
        txtIncidenciasEnProgreso.setText(Double.toString(numIncidenciasEnProgreso));
       
        double tiempoMedioResolucion = 0;
        for (int i = 0; i < numIncidencias; i++) {
            Incidencia incidencia = (Incidencia) incidencias.get(i);
            tiempoMedioResolucion += incidencia.getTiempoResolucion();
        }
        tiempoMedioResolucion = tiempoMedioResolucion / numIncidencias;
        txtTiempoMedioResolucion.setText(Double.toString(tiempoMedioResolucion));

        // Metodo para calcular el técnico más activo y menos inactivo. No funciona !!!
        int numTecnicos = tecnicos.size();
        int numIncidenciasTecnico = 0;
        int numIncidenciasTecnicoMasActivo = 0;
        int numIncidenciasTecnicoMasInactivo = 0;
        String nombreTecnicoMasActivo = "";
        String nombreTecnicoMasInactivo = "";
        for (int i = 0; i < numTecnicos; i++) {
            Tecnico tecnico = (Tecnico) tecnicos.get(i);
            numIncidenciasTecnico = 0;
            for (int j = 0; j < numIncidencias; j++) {
                Incidencia incidencia = (Incidencia) incidencias.get(j);
                if (incidencia.getTecnico().getNombre().equalsIgnoreCase(tecnico.getNombre())) {
                    numIncidenciasTecnico++;
                }
            }
            if (numIncidenciasTecnico > numIncidenciasTecnicoMasActivo) {
                numIncidenciasTecnicoMasActivo = numIncidenciasTecnico;
                nombreTecnicoMasActivo = tecnico.getNombre();
            }
            if (numIncidenciasTecnico < numIncidenciasTecnicoMasInactivo) {
                numIncidenciasTecnicoMasInactivo = numIncidenciasTecnico;
                nombreTecnicoMasInactivo = tecnico.getNombre();
            }
        }
        txtTecnicoMasActivo.setText(nombreTecnicoMasActivo);
        txtTecnicoMasInactivo.setText(nombreTecnicoMasInactivo);
       
        

    }
    // INICIO MANEJADOR DE EVENTOS

    @Override
    public void actionPerformed(ActionEvent e) {
       // La propia ventana es el manejador de los eventos que se generan en sus controles
		Object o= e.getSource();
		
		if(o.equals(btCerrar)){			
            System.out.println("Cerrar");
            dispose();         
        } else {
            System.out.println("Error de algun tipo");
        }        
    }
}


