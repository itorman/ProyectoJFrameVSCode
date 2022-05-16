
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
        
        Incidencia incidencia = new Incidencia("IC0001", "Problema de la pantalla", "01/01/2019", "Abierta", tecnico);
        Incidencia incidencia2 = new Incidencia("IC0002", "Wifi no funciona", "02/01/2022", "Cerrada", tecnico4);
        // print the name of the incidencia
        incidencia.setFechaCierre("03/05/2022");
        System.out.println(incidencia.toString());
        System.out.println(incidencia2.toString());
        //crea una ventanaPrincipal
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        //ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
}
