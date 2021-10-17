import java.util.Calendar;
import java.util.GregorianCalendar;


//Creamos los hilos
public class hilo implements Runnable{
	private long numero;
	
	public hilo(long numero) {
		this.numero = (long) numero;
		
	}
	
	
	//Sobrescribimos el metodo run
	@Override
	public void run() {
		//Instanciamos la variable que determinara si el numero es primo o no
		boolean primo=true;
		
		//Cogemos el tiempo al empezar
		long inicio = System.currentTimeMillis();
		
		
		Long contador = 2l;
		while ((primo) && (contador!=numero)){
		    if (numero % contador == 0)
		    primo = false;
		    contador++;
		}
		
		//Si el numero es primo
		if (primo == true) {
			//Cogeremos el tiempo y calcularemos cuanto a tardado
			long fin = System.currentTimeMillis();
	        double tiempo = (double) ((fin - inicio)/1000);
	        //Creamos un nuevo objeto numero en el que guardaremos los datos
	        Numero numero = new Numero();
	        numero.setNumero(this.numero);
	        numero.setTiempo(tiempo);
	        numero.setHilo(Thread.currentThread().getName());
	        numero.setPrimo(true);
	        //Imprimimos por pantalla el metodo toString
	        System.out.println(numero.toString());
	        
	    //Si el numero es primo
		}else if (primo == false){
			//Cogeremos el tiempo y calcularemos cuanto a tardado
			long fin = System.currentTimeMillis();
	        double tiempo = (double) ((fin - inicio)/1000);
	        //Creamos un nuevo objeto numero en el que guardaremos los datos
	        Numero numero = new Numero();
	        numero.setNumero(this.numero);
	        numero.setTiempo(tiempo);
	        numero.setHilo(Thread.currentThread().getName());
	        numero.setPrimo(false);
	        //Imprimimos por pantalla el metodo toString
	        System.out.println(numero.toString());
		}
			}
	
		
	}


