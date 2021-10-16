import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		long numero1;
		long numero2;
		long numero3;
		long numero4;

		Scanner oLector = new Scanner(System.in);
		
		System.out.print("Introduce un número 1: ");
		numero1 = oLector.nextLong();
		System.out.print("Introduce un número 2: ");
		numero2 = oLector.nextLong();
		System.out.print("Introduce un número 3: ");
		numero3 = oLector.nextLong();
		System.out.print("Introduce un número 4: ");
		numero4 = oLector.nextLong();

		oLector.close();

		Primo num1 = new Primo(numero1);
		Primo num2 = new Primo(numero2);
		Primo num3 = new Primo(numero3);
		Primo num4 = new Primo(numero4);
		
	}


}
