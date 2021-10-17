
public class ResultadoPrimo {
	long numero;
	long tiempoEmpleado;
	long numeroDivisible;
	String nombreHilo;
	boolean es_primo;
	
	public ResultadoPrimo(long numero, long tiempoEmpleado, String nombreHilo, boolean es_primo) {
		super();
		this.numero = numero;
		this.tiempoEmpleado = tiempoEmpleado;
		this.nombreHilo = nombreHilo;
		this.es_primo = es_primo;
	}

	public ResultadoPrimo() {
		super();
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public long getTiempoEmpleado() {
		return tiempoEmpleado;
	}

	public void setTiempoEmpleado(long tiempoEmpleado) {
		this.tiempoEmpleado = tiempoEmpleado;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public boolean getEs_primo() {
		return es_primo;
	}

	public void setEs_primo(boolean es_primo) {
		this.es_primo = es_primo;
	}

	public long getNumeroDivisible() {
		return numeroDivisible;
	}

	public void setNumeroDivisible(long numeroDivisible) {
		this.numeroDivisible = numeroDivisible;
	}

	@Override
	public String toString() {
		return "ResultadoPrimo [numero=" + numero + ", tiempoEmpleado=" + tiempoEmpleado + "ms, numero Divisor="
				+ numeroDivisible + ", nombreHilo=" + nombreHilo + ", es_primo=" + es_primo + "]";
	}


}
