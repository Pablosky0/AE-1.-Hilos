import java.util.ArrayList;

public class Productor extends Thread {

    private ArrayList<Emails> listaEmails = new ArrayList<Emails>();
    private Buffer bufferEmails;

    /*
     * Constructor del productor. Tiene un parametro a traves del cual se podrá referenciar
     * el buffer general donde se almacenaran los Email que se envien.  
     */
    public Productor(Buffer bufferEmails) {
        super();

        this.bufferEmails = bufferEmails;
        
        generarListaEmails();

    }

    /*
     * Esta subrutina tiene la función de hacer que el hilo empieze a funcionar
     */
    public void comenzar() {
        this.start();
    }
    
    /*
     * Subrutina que genera la lista de Emails de donde se escogerá los emails a enviar.
     */
    public void generarListaEmails() {

    	int i,j,k,l;
    	Integer contador;
    	ArrayList<String> direcciones = new ArrayList<String>();
        ArrayList<String> asuntos = new ArrayList<String>();
        ArrayList<String> cuerpos = new ArrayList<String>();

        /*
         * crear componentes de los emails
         */
        anyadirDirecciones(direcciones);
        anyadirAsuntos(asuntos);
        anyadirCuerpos(cuerpos);       

        /*
         * Anidamos varios bucles para crear todas las combinaciones de Email posibles
         * con los datos que hemos introducido
         */
        contador = 0;
        for (i=0;i<direcciones.size();i++) {
            for (j=0;j<direcciones.size();j++) {
                for (k=0;k<direcciones.size();k++) {
                    for (l=0;l<direcciones.size();l++) {
                    this.listaEmails.add(new Emails(contador.toString(),direcciones.get(i),
                    		direcciones.get(j),asuntos.get(k),cuerpos.get(l)));
                    contador++;
                    }                	
                }
            }
        }
        
    }
    
    /*
     * Se crean las direcciones de emails, tanto de destinatario como de remitente 
     */
    public void anyadirDirecciones(ArrayList<String> direcciones) {  	
        
    	direcciones.add("ejemplo@contoso.com");
        direcciones.add("megausuario.gmail.com");
        direcciones.add("pikachu@gmail.com");
        direcciones.add("viejuno007@yahoo.es");
        direcciones.add("programador@hotmail.com");
        direcciones.add("ultrahacker@linux.org");
    	
    }

    /*
     * Se crean los asuntos de los Emails 
     */
    public void anyadirAsuntos(ArrayList<String> asuntos) {
        
        asuntos.add("saludos");
        asuntos.add("asistencia tecnica");
        asuntos.add("importate");
        asuntos.add("juegos");
        asuntos.add("asistencia tecnica");
        asuntos.add("dime una cosa");
        asuntos.add("sin sentido");
        asuntos.add("recordatorio");
        asuntos.add("importante");
        asuntos.add("saludos");
        
    }
    
    /*
     * Se crean los cuerpos de los Emails 
     */
    public void anyadirCuerpos(ArrayList<String> cuerpos) {
        
        cuerpos.add("¿que tal esta usted?");
        cuerpos.add("dime como generas electricidad");
        cuerpos.add("en tu epoca los pokemon aun no existiamos");
        cuerpos.add("me podrias pasar algunos juegos antiguos");
        cuerpos.add("ya he resuelto el problema que tenia");
        cuerpos.add("que he de aprender para saber programar");
        cuerpos.add("adasdfqefserqwewrqthsd");
        cuerpos.add("que tengo una reunion el proximo martes");
        cuerpos.add("frotandome mucho y generando electricidad estatica");
        cuerpos.add("queria saudar a un magnifico usuario");

    }
    
    /*
     * rutina que realiza las tareas del hilo
     */
    @Override
    public void run() {
        int i;
        int indice;

        /*
         *  Para iteracion del bucle (que se repite 10 veces) se genera un número
         *  aleatorio que nos indexara el email que queremos mandar.
         *  Una vez enviado el email al buffer esperamos medio segundo para realizar
         *  otra acción.
         */
        for (i=0;i<10;i++) {
            indice = (int) (Math.random() * listaEmails.size() - 1);
            try {
                this.bufferEmails.anyadirCorreo(listaEmails.get(indice));
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
