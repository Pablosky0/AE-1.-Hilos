import java.util.Calendar;
import java.util.GregorianCalendar;

public class hilo implements Runnable{
	private long numero;
	
	public hilo(long numero) {
		this.numero = (long) numero;
		
	}
	
	@Override
	public void run() {
		Long contador = 2l;
		boolean primo=true;
		long inicio = System.currentTimeMillis();
		while ((primo) && (contador!=numero)){
		    if (numero % contador == 0)
		    primo = false;
		    contador++;
		}
		if (primo == true) {
			long fin = System.currentTimeMillis();
	        double tiempo = (double) ((fin - inicio)/1000);
	        Numero numero = new Numero();
	        numero.setNumero(this.numero);
	        numero.setTiempo(tiempo);
	        numero.setHilo(Thread.currentThread().getName());
	        numero.setPrimo(true);
	        System.out.println(numero.toString());
		}else if (primo == false){
			long fin = System.currentTimeMillis();
	        double tiempo = (double) ((fin - inicio)/1000);
	        Numero numero = new Numero();
	        numero.setNumero(this.numero);
	        numero.setTiempo(tiempo);
	        numero.setHilo(Thread.currentThread().getName());
	        numero.setPrimo(false);
	        System.out.println(numero.toString());
		}
			}
	
		
	}


