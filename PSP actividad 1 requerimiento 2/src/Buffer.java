import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
    private final static int MAX_ELEMENTOS = 5;
    private Queue<Emails> buffer = new LinkedList<>();

    private long contador = 0;

    /*
     * Constructor
     */
    public Buffer() {
        super();
        buffer = new LinkedList<>();
    }

    /*
     * Funcion que recibe los emails de los productores
     */
    public synchronized void anyadirCorreo(Emails correo){
    	
    	/*
    	 *  Se bloquea el hilo mientras que el tamaño de la lista sea el máximo establecido (5),
    	 *  interceptando una posible excepción de la espera
    	 */
		while(buffer.size() == MAX_ELEMENTOS){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * Cuando se encuentra un espacio disponible en la lista buffer se introduce
		 * un nuevo correo.
		 * El elemento condicional cumple con el requisito 2: 
		 *		si el reminente es pikachu@gmail.com no se envia el correo
		 *		mostrando en su lugar un mensaje
		 * Nota: el contador cuenta el número de emails procesados.
		 */
		this.contador++;
        if (correo.getReminente() != "pikachu@gmail.com") {
		    buffer.offer(correo);
        } else {
            System.out.println("Correo a pikachu@gmail.com no enviado.");

        }
        
        // Se notifica a los hilos bloqueados que ha ya terminado de trabajar con la lista
		notify();
	}
	
    /*
     * Funcion que envia los emails a los consumidores
     */
	public synchronized Emails cogerCorreo(){

		/*
		 * Si se ha terminado de trabajar se envia un email nulo
		 * para que los consumidores seban que ya se ha terminado de enviar Emails
		 */
		if (this.terminado() == true) {return null;}
		
    	/*
    	 *  Se bloquea el hilo mientras que la lista este vacia,
    	 *  interceptando una posible excepción de la espera
    	 */
		while(buffer.size() == 0){
		
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Se recoge un Email del buffer
		Emails mensaje = buffer.poll();

        // Se notifica a los hilos bloqueados que ha ya terminado de trabajar con la lista
		notify();

		// se retorna el Email recogido
		return mensaje;
		
	}
	
    /*
     * funcion que determina que el buffer ha terminado de trabajar
     */
    public synchronized boolean terminado() {
    	boolean resultado;
    	
    	resultado = false;
    	if (contador > 29) {
    		if (buffer.size() == 0) {
    			resultado = true;
    		}
    	}
    	return resultado;
    }
    

}
