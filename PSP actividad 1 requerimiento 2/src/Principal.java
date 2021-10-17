
public class Principal {

	public static void main(String[] args) {
		// Se inicializa vacia la cola de Emails.
		Buffer Emails = new Buffer();

		// Se crean los productores y consumidores.
		Productor productor1 = new Productor(Emails);
		Productor productor2 = new Productor(Emails);
		Productor productor3 = new Productor(Emails);

		Consumidor consumidor1 = new Consumidor(Emails);
		Consumidor consumidor2 = new Consumidor(Emails);

		// Se ponen a funcionar los hilos tanto de los productores como de los consumidores
		productor1.comenzar();
		productor2.comenzar();
		productor3.comenzar();
		consumidor1.comenzar();
		consumidor2.comenzar();

	}

}
