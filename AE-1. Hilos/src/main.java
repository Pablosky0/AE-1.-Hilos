import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		
		
		System.out.println("Dime cuatro numeros:");
		
		hilo hilo1 = new hilo(lector.nextLong());
		Thread h1 = new Thread(hilo1);
		h1.setName("HILO1");
		h1.start();
		
		hilo hilo2 = new hilo(lector.nextLong());
		Thread h2 = new Thread(hilo2);
		h2.setName("HILO2");
		h2.start();
		
		hilo hilo3 = new hilo(lector.nextLong());
		Thread h3 = new Thread(hilo3);
		h3.setName("HILO3");

		h3.start();
		
		hilo hilo4 = new hilo(lector.nextLong());
		Thread h4 = new Thread(hilo4);
		h4.setName("HILO4");

		h4.start();
	}

}
