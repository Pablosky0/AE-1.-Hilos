
/*
 * Clase que determina si un numero es primo o no
 */
public class Primo extends Thread {
		
	long numero;
	ResultadoPrimo resultado = new ResultadoPrimo(); 

	/*
	 * Constructores
	 */
	public Primo() {
		super();
	}
	
	public Primo(long pNumero) {
		super();
		this.numero = pNumero;
		this.start();
	}
	
	/*
	 * Unicamente implementamo el set y el get del numero
	 * ya que el objeto resultado lo mostraremos al finalizar el hilo
	 */
	public double getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
		this.start();
	}

	@Override
	public void run() {
		int i = 0;
		boolean esPrimo;
		long numeroTratado;
		long miliSegundosInicial = System.currentTimeMillis();
		boolean salirBucle;
		long divisor = 0;
		
		numeroTratado = (long)this.numero;
		esPrimo = true;
		/*
		 * No es primo al no ser un número entero
		 */
		/*
		 *  rechazamos el 0, el 1 y los números negativos al no poder ser primos
		 *  por definición de número primo ( https://dle.rae.es/número#B1Q6FXn )
		 *  Esto se indica poniendo a 0 el divisor.
		 */
		if (numeroTratado < 2) {
			esPrimo = false;
			salirBucle = true;
			divisor = 0;
		} else {
			divisor = 1;
			/*
			 * Si es dos es primo, sino no lo es comprobamos que es par en cuyo caso
			 * no es primo. Se separa las dos comprobaciones porque el 2 es divisible
			 * entre dos, es decir, el modulo es 0.
			 * 
			 * En cualquiera de los dos casos no dejaremos que entre en el bucle
			 * para comprobar si es divisible por otro número.
			 */
			if (numeroTratado == 2) {
				esPrimo = true;
				salirBucle = true;
			} else {
				if (numeroTratado % 2 == 0) {
					esPrimo = false;
					salirBucle = true;
					divisor = 2;
				} else {
					esPrimo = true;
					salirBucle = false;
				}		
			}
		}
		/*
		 * Bucle para comprobar que el número no es divisible por un número impar,
		 * por lo que empezamos por el numero impar mas pequeño, el 3.
		 */
		i = 3;
		while (salirBucle == false) {
			/*
			 * comprobamos si el numeroTatado es divisible por un número y si ese
			 * divisor es el numeroTatado, 
			 * 	si se puede dividir por un número que no es el mismo entonces no es primo,
			 *  si se divide por si mismo no se ha encontrado un divisor >1 entonces es primo.
			 *  
			 */
			if (numeroTratado % i == 0) {
				if (this.numero == i) {
					esPrimo = true;
					divisor = 1;
				} else {
					esPrimo = false;
					divisor = i;
				}
				// Hacemos que la condicion del bucle no sea cierta
				salirBucle = true;
			}
			/*
			 * En esta parte determinamos si hemos llegado al limite superior de los
			 * números que utilizamos para comprobar que el numero introducido es primo
			 * Si el contador del bucle es mayor que el numero tratado entre el contador
			 * entonces se sale del bucle al ser cierta la inecuación
			 * 
			 * 		x * i > numeroTratado
			 * 
			 * no pudiendo cumplirse para las siguientes iteracciones la ecuación
			 * 
			 * 		x * i = numeroTratado
			 * 
			 *   Sino se sale del bucle incrementamos en 2 para evitar los pares
			 */
			if (i >= numeroTratado / i) {
				salirBucle = true;
			} else {
				i = i + 2;
			}
		}
			
		//  
		resultado.setNumeroDivisible(divisor);
		resultado.setNumero(this.numero);
		resultado.setNombreHilo(this.getName());
		resultado.setTiempoEmpleado(System.currentTimeMillis() - miliSegundosInicial);
		resultado.setEs_primo(esPrimo);
		
		System.out.println(resultado.toString());

	}

	
}
