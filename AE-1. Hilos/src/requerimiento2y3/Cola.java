package requerimiento2y3;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	
	public final static int MAX_ELEMENTS = 5;
	
	private Queue<Email> cola = new LinkedList<>();
	
	public synchronized void addMensaje(Email email) {
		if (email.getDestinatario()=="pikachu@gmail.com") {
			System.out.println("No se pueden enviar emails a pikachu@gmail.com");
		}else {
		while (cola.size() == MAX_ELEMENTS) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	cola.offer(email);
	notify();
	}
}
public synchronized Email getMensaje(){
	
	while (cola.size() == 0) {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	Email s = cola.poll();
	notify();
	return s;
	}
}

