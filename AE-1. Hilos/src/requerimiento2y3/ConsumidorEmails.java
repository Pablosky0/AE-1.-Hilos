package requerimiento2y3;
//Creamos el hilo Conumidor
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
	
	//Sobrescribimos el metodo run de tal manera que consumira 30 emails y lo sacara por pantalla
	public void run() {
		for (int i = 1; i <=15; i++) {
			Email email = cola.getMensaje();
			System.out.println(nombre + " ha enviado el email: " + email);
		}
	}
}
