
public class Principal {

	public static void main(String[] args) {
		Buffer Emails = new Buffer();

		Productor productor1 = new Productor(Emails);
		Productor productor2 = new Productor(Emails);
		Productor productor3 = new Productor(Emails);

		Consumidor consumidor1 = new Consumidor(Emails);
		Consumidor consumidor2 = new Consumidor(Emails);

		productor1.comenzar();
		productor2.comenzar();
		productor3.comenzar();
		consumidor1.comenzar();
		consumidor2.comenzar();

	}

}
