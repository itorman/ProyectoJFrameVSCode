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

    // constructorque crea la ventana de informes. Recibe por parametro los arrays de tecnicos y incidencias
    public VentanaInforme(ArrayList<Tecnico> tecnicos, ArrayList<Incidencia> incidencias) {
         super("Ventana de informes");       
         initComponentes();
    }

    public void initComponentes() {

        //ventanaInforme = new JFrame("Panel de informes");

        // inicializo ventana y configuro tamaño
       
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE); // ?? aqui ??
        this.setSize(700, 400);
        // Posicionamos la ventana en la pantalla
        //this.setLocationRelativeTo(null);
        
        

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
    public void calcularInformes(ArrayList tecnicos, ArrayList incidencias) {
        // Calculamos el porcentaje de incidencias cerradas
        int numIncidenciasCerradas = 0;
        int numIncidenciasAbiertas = 0;
        int numIncidenciasEnProgreso = 0;
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
        double porcentajeIncidenciasCerradas = (double) (numIncidenciasCerradas / numIncidencias) * 100;
        txtIncidenciasCerradas.setText(String.format("%.2f", porcentajeIncidenciasCerradas));

        // Calculamos el porcentaje de incidencias abiertas
        double porcentajeIncidenciasAbiertas = (double) (numIncidenciasAbiertas / numIncidencias) * 100;
        txtIncidenciasAbiertas.setText(String.format("%.2f", porcentajeIncidenciasAbiertas));

        // Calculamos el porcentaje de incidencias en progreso
        double porcentajeIncidenciasEnProgreso = (double) (numIncidenciasEnProgreso / numIncidencias) * 100;
        txtIncidenciasEnProgreso.setText(String.format("%.2f", porcentajeIncidenciasEnProgreso));

        // Calculamos el tiempo medio de resolución
        double tiempoMedioResolucion = 0;
        for (int i = 0; i < numIncidencias; i++) {
            Incidencia incidencia = (Incidencia) incidencias.get(i);
            tiempoMedioResolucion += incidencia.getTiempoResolucion();
        }
        tiempoMedioResolucion = tiempoMedioResolucion / numIncidencias;
        txtTiempoMedioResolucion.setText(String.format("%.2f", tiempoMedioResolucion));

        // Calculamos el técnico más activo
       
        
        
    }

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


