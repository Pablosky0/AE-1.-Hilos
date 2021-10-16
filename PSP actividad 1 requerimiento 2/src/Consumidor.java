
public class Consumidor extends Thread {
    
    private Buffer bufferEmails;
    /*
     * Constructor del Consumidor. Tiene un parametro a traves del cual se podrá referenciar
     * el buffer general donde se almacenan los Email que se reciben.  
     */
    public Consumidor(Buffer bufferEmails) {
        super();
        this.bufferEmails = bufferEmails;
    }

    /*
     * Esta subrutina tiene la función de hacer que el hilo empieze a funcionar
     */
    public void comenzar() {
        this.start();
    }

    /*
     * rutina que realiza las tareas del hilo
     */
    @Override
    public void run() {
        Emails correo = new Emails();
        boolean salirBucle;
        
        
        /*
         * En este bucle recogemos los correos que esten en el buffer de Emails.
         * Este bucle seguirá hasta que el buffer nos entrege un Emails nulo, esto
         * nos indicara que el buffer no ofrecera mas emails, por lo cual, no es
         * necesario estar esperando un nuevo email.
         * Cuando nos entrega una Email que no sea nulo, se presentara por pantalla. 
         */
        salirBucle = false;
        while (salirBucle == false) {
            try {
                correo = bufferEmails.cogerCorreo();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (correo == null) {
            	salirBucle = true;
            } else {
            	System.out.println(correo.toString());
            }
        }
    }


}
