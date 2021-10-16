import java.time.LocalDateTime;
import java.util.Date;
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
     * funcion que determina que se ha terminado de trabajar
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
		 * El elemento condicional cumple con el requisito 2: si el reminente es pikachu@gmail.com
		 * no se envia el correo mostrando en su lugar un mensaje 
		 */
		this.contador++;
        if (correo.getReminente() != "pikachu@gmail.com") {
		    buffer.offer(correo);
        } else {
            System.out.println("Correo a pikachu@gmail.com no enviado.");

        }
        
        /*
         *  Se notifica a los hilos bloqueados que ha ya terminado de trabajar con la lista
         */
		notify();
	}
	
    /*
     * Funcion que envia los emails a los consumidores
     */
	public synchronized Emails cogerCorreo(){

		/*
		 * Si se ha terminado de trabajar se envia un email nulo
		 * para que el consumidor no se quede colgado esperando un Email 
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

		/*
		 * Se saca un Email del buffer y se establece la hora a la que se envia el email
		 */
		Emails mensaje = buffer.poll();

        /*
         *  Se notifica a los hilos bloqueados que ha ya terminado de trabajar con la lista
         */
		notify();

		/*
		 * se retorna el Email sacado del buffer
		 */
		return mensaje;
		
	}
	

}
