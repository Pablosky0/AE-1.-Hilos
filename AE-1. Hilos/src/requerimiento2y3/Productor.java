package requerimiento2y3;

//Creamos el hilo productor
public class Productor extends Thread{
	public String nombre;
	public Cola cola;
	
	public Productor(String nombre, Cola cola) {
		super();
		this.nombre = nombre;
		this.cola = cola;
	}
	//Sobrescribimos el metodo run para que procese 30 emails
	public void run() {
		GeneradorEmails ge = new GeneradorEmails();
		for (int i = 1; i <= 10;i++) {
			Email email = ge.generarEmail();
			System.out.println(nombre + " ha Producido el email " + email.getId());
			cola.addMensaje(email);
			//Tiene que esperar 0,5 segundos antes de volver a producir
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
