//Creamos el objeto numero donde se guardaran los datos del numero
public class Numero {
	private long numero;
	private boolean primo;
	private double tiempo;
	private String hilo;
	
	public Numero(long numero, boolean primo, double tiempo, String hilo) {
		super();
		this.numero = numero;
		this.primo = primo;
		this.tiempo = tiempo;
		this.hilo = hilo;
	}

	//Sobrescribimos el metodo toString para que nos sace por pantalla los datos que queremos.	
	@Override
	public String toString() {
		if (primo == true ) {
			return "El numero: " + numero + " ha sido procesado por el hilo: " + Thread.currentThread().getName() + " y ha tardado " + tiempo + " segundos,  es un numero primo";
		}
		if (primo == false) {
			return "El numero: " + numero + " ha sido procesado por el hilo: " + Thread.currentThread().getName() + " y ha tardado " + tiempo + " segundos,  no es un numero primo";
		}
		return "";
	}

	public Numero() {
		super();
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public boolean isPrimo() {
		return primo;
	}

	public void setPrimo(boolean primo) {
		this.primo = primo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public String getHilo() {
		return hilo;
	}

	public void setHilo(String string) {
		this.hilo = string;
	}
	
}
