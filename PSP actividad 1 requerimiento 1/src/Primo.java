public class Primo extends Thread {
	long numero;
	ResultadoPrimo resultado = new ResultadoPrimo(); 
	
	public Primo(long pNumero) {
		this.numero = pNumero;
		this.start();
	}
		
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
		if (Math.floor(this.numero) != this.numero) {
			esPrimo = false;
			salirBucle = true;
			resultado.setNumeroDivisible(0);
		} else {
			/*
			 *  rechazamos el 0, el 1 y los números negativos al no poder ser primos
			 *  por definición de número primo ( https://dle.rae.es/número#B1Q6FXn )
			 */
			if (numeroTratado < 2) {
				esPrimo = false;
				salirBucle = true;
				divisor = 0;
			} else {
				divisor = 1;
				/*
				 * Si es dos es primo
				 * Sino si es divisible entre 2 no es primo
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
		}
		i = 3;
		while (salirBucle == false) {
			// comprobamos si es divisible por un número
			if (numeroTratado % i == 0) {
				/*
				 *  comprobamos si el numero por el que es divisible es el mismo
				 *  si lo es entonces es primo
				 *  si no es el entonces se puede dividir por otro numero y no es primo
				 */
				if (this.numero == i) {
					esPrimo = true;
				} else {
					esPrimo = false;
					divisor = i;
				}
				// Hacemos que la condicion del bucle no sea cierta
				salirBucle = true;
			}				
			/*
			 *  recorremos los impares
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
