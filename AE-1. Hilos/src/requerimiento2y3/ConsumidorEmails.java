package requerimiento2y3;

public class ConsumidorEmails extends Thread{
	public String nombre;
	public Cola cola;
	
	public ConsumidorEmails() {
		super();
	}
	
	public ConsumidorEmails(String nombre, Cola cola) {
		super();
		this.nombre = nombre;
		this.cola = cola;
	}
	
	public void run() {
		for (int i = 1; i <=15; i++) {
			Email email = cola.getMensaje();
			System.out.println(nombre + " ha enviado el email: " + email);
		}
	}
}
