package ModeloProductorConsumidor;

import java.util.ArrayList;

public class PilaNumeros {
	
	private static ArrayList<Integer> numeros = null;
	private int size;

//CONSTRUCTOR
	public PilaNumeros(int size) {
		this.size = size;
		PilaNumeros.numeros = new ArrayList<Integer>(size); 	//Le pongo un tamaño fijo al array, lo limito
	}
	
//METODOS
	//Con synchronized me aseguro que más de 1 hilo no puede acceder al mismo método a la vez.
	public synchronized boolean addNumber(int number) throws InterruptedException { 
		while(numeros.size() == size) {
			wait();												//Se pone en espera si esta llena la pila.
		}
		System.out.println("Produzco el numero " + number);
		numeros.add(number);
		notify();												//Despierta a los demas hilos cuando produce un numero y lo mete en la pila.
		return true;
	}
	
	public synchronized boolean removeNumber() throws InterruptedException {		
		if(!numeros.isEmpty()) {
			System.out.println("Consumo el numero " + numeros.get(0));
			numeros.remove(0);
			notify();											//Despierta a los demas hilos si consume un numero de la pila.
			return true;
		} else {
			notify();
			wait();												//Si la pila esta vacia, se pone en espera.
			return false;
		}
	}
	
	public synchronized void showListNumbers() {
		if(numeros.isEmpty()) {									//Si la pila esta vacia imprimira un mensaje y si tiene numeros los imprimira.
			System.out.println("\nLista vacía.");
		}else {
			System.out.println();
			for(int i : numeros) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}
}
