package ModeloProductorConsumidor;

import java.util.ArrayList;

public class PilaNumeros {
	
	private static ArrayList<Integer> numeros = null;

//CONSTRUCTOR
	public PilaNumeros(int size) {
		this.numeros = new ArrayList<Integer>(size); //Le pongo un tamaño fijo al array, lo limito
	}
	
//METODOS
	//Con synchronized me aseguro que más de 1 hilo no puede acceder al mismo método a la vez.
	public synchronized boolean addNumber(int number) { 
		//while(taskIds.size() == ma) meterle wait para dormir si está llena
		numeros.add(number);
		return true;
	}
	
	public synchronized boolean removeNumber() {
		int numTemporal = 0;
		
		if(!numeros.isEmpty()) {
			numeros.remove(0);
			//numeros.remove(numeros.size()-1); //Es LIFO, lo tengo que cambiar
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized void showListNumbers() {
		if(numeros.isEmpty()) {
			System.out.println("\nLista vacía.");
		}else {
			System.out.println();
			for(int i : numeros) {
				System.out.print(i + ", ");
			}
		}
	}
}

//Es mas rapido numeros.remove(numeros.size()-1); que las lineas de abajo
//numeros.remove(0);
////Subo un puesto todos los numeros de la lista
//for(int x=1; x < numeros.size(); x++) {
//	numTemporal = numeros.get(x);	//Cojo el numero que esta en la posicion 1
//	numeros.set(x-1, numTemporal);	//Meto ese numero en la misma lista pero una posicion mas arriba
//}	