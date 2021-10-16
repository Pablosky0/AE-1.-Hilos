
public class Emails {

    private String id;
    private String destinatario;
    private String reminente;
    private String asunto;
    private String cuerpo;

    /*
     *  Constructores
     */
    public Emails() {
        super();
        this.id = "";
        this.destinatario = "";
        this.reminente = "";
        this.asunto = "";
        this.cuerpo = "";
    }

    public Emails( String id, String destinatario, String reminente, String asunto, String cuerpo) {
        super();
        this.id = id;
        this.destinatario = destinatario;
        this.reminente = reminente;
        this.asunto = asunto;
        this.cuerpo = cuerpo;    
    }

    /*
     * Setters y getters
     */
    public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

    public String getDestinatario() {
		return this.destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

    public String getReminente() {
		return this.reminente;
	}
	public void setReminente(String reminente) {
		this.reminente = reminente;
	}

    public String getAsunto() {
		return this.asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

    public String getCuerpo() {
		return this.cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	/*
	 *  Conversión a cadena
	 */
	@Override
    public String toString() {
        String resultado;
        resultado ="Email = id: " + this.id + "\n";
        resultado += " destinatario: " + this.destinatario + "\n";
        resultado += " remitente: " + this.reminente + "\n";
        resultado += " asunto: " + this.asunto + "\n";
        resultado += " cuerpo: " + this.cuerpo + "\n";
        return resultado;
    }

}
