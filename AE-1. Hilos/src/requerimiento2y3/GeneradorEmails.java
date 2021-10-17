package requerimiento2y3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//Creamos un generador de emails random que a base de ArrayLit cogera un elemento con un numero aleatorio y los ira combinando para crear los emails
public class GeneradorEmails {
	
	public Email generarEmail() {
		Email email = new Email();
		email.setId(generarId());
		email.setRemitente(generarRemitente());
		email.setDestinatario(generarDestinatario());
		email.setAsunto(generarAsunto());
		email.setCuerpo(generarCuerpo());
		return email;
	}
	
	public int generarId() {
		int numero =  (int) (Math.random()*30+1);
		return numero;
	}
	
	public String generarRemitente() {
		List<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Steve Rogers");
		listaNombres.add("Tony Stark");
		listaNombres.add("Bruce Banner");
		listaNombres.add("Thor");
		listaNombres.add("Clint Burton");
		listaNombres.add("Natasha Romanoff");
		listaNombres.add("Stephen Strange");
		listaNombres.add("Peter Parker");
		listaNombres.add("Scott Lang");
		listaNombres.add("Loki");
		
		int numero = (int) (Math.random()*9);
		return listaNombres.get(numero);
	}
	
	public String generarDestinatario() {
		List<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Bruce Wayne");
		listaNombres.add("Clark Kent");
		listaNombres.add("Diana Prince");
		listaNombres.add("Arthur Curry");
		listaNombres.add("Barry Allen");
		listaNombres.add("Victor Stone");
		listaNombres.add("Joker");
		listaNombres.add("Harley Quinn");
		listaNombres.add("Comisario Gordon");
		listaNombres.add("pikachu@gmail.com");
		
		int numero = (int) (Math.random()*9);
		return listaNombres.get(numero);
	}
	
	public String generarAsunto() {
		List<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Lo que tu ya sabes");
		listaNombres.add("Nos estan atacando");
		listaNombres.add("Que pasa tron");
		listaNombres.add("Te hecho de menos");
		listaNombres.add("A la torre de los vengadores ya");
		listaNombres.add("Al atalaya ahora");
		listaNombres.add("Tenemos asuntos pendientes");
		listaNombres.add("Esto tiene que acabar ya");
		listaNombres.add("Buenos dias cariño");
		listaNombres.add("Preparate para la guerra");
		
		int numero = (int) (Math.random()*9);
		return listaNombres.get(numero);
	}
	public String generarCuerpo() {
		List<String> listaNombres = new ArrayList<String>();
		listaNombres.add("TONTO EL QUE LO LEEA XD");
		listaNombres.add("Siempre me has caido mal que lo sepas");
		listaNombres.add("Sabes siempre he pensado que hariamos buena pareja ^-^");
		listaNombres.add("Esto es la guerra, preparate a ti y a tu equipo por solo uno quedara en pie");
		listaNombres.add("Coge tu las bebidas yo llevare las patatas, menuda fiesta tio.");
		listaNombres.add("Desde el dia en el que te conoci siempre supe que esto acabaria asi");
		listaNombres.add("En el lugar y la hora de siempe :3 <3");
		listaNombres.add("Concurso de beerpong esta noche, prohibidos los superpoderes");
		listaNombres.add("No sabia como sacar el tema en persona pero me gusta mucho tu amiga...¿Me la presentas?");
		listaNombres.add("HAS SIDO HACKEADO POR DEADPOOL PRINGAO!!!!");
		
		
		int numero = (int) (Math.random()*9);
		return listaNombres.get(numero);
	}
	
}
