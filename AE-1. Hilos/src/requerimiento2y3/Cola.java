package requerimiento2y3;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	//El maximo numero de elementos en la cola sera 5
	public final static int MAX_ELEMENTS = 5;
	
	private Queue<Email> cola = new LinkedList<>();
	
	public synchronized void addMensaje(Email email) {
		//Si el email es pikachu@gmail.com no se procesara
		if (email.getDestinatario()=="pikachu@gmail.com") {
			System.out.println("No se pueden enviar emails a pikachu@gmail.com");
		}else {
		//Si la cola esta llena espera
		while (cola.size() == MAX_ELEMENTS) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Si tiene un hueco procesa el email y lo notifica
		cola.offer(email);
		notify();
	}
}
public synchronized Email getMensaje(){
	//Si la cola esta vacia espera
	while (cola.size() == 0) {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Si hay un elemento en la cola lo consume y lo notifica
	Email s = cola.poll();
	notify();
	return s;
	}
}

