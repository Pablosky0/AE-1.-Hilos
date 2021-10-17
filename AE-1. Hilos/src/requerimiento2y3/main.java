package requerimiento2y3;

public class main {

	public static void main(String[] args) {
		//Creamos una cola
		Cola cola = new Cola();
		
		//Creamos los tres productores
		Productor p1 = new Productor("Productor 1",cola);
		Productor p2 = new Productor("Productor 2",cola);
		Productor p3 = new Productor("Productor 3",cola);

		//Creamos los dos consumidores
		ConsumidorEmails c1 = new ConsumidorEmails("Consumidor 1", cola);
		ConsumidorEmails c2 = new ConsumidorEmails("Consumidor 2", cola);

		//Iniciamos los hilos 
		p1.start();
		p2.start();
		p3.start();
		
		c1.start();
		c2.start();
		
	}

}
