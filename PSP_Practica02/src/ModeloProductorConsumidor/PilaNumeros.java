package ModeloProductorConsumidor;

import java.util.ArrayList;

public class PilaNumeros {
	
	private static ArrayList<Integer> numeros = null;

//CONSTRUCTOR
	public PilaNumeros() {
		this.numeros = new ArrayList<Integer>(3); //Le pongo un tamaño fijo al array, lo limito
	}
	
//METODOS
	//Con synchronized me aseguro que más de 1 hilo no puede acceder al mismo método a la vez.
	public synchronized void addNumber(int number) { 
		numeros.add(number);
	}
	
	public synchronized void removeNumber() {
		int numTemporal = 0;
		
		if(!numeros.isEmpty()) {
			numeros.remove(numeros.size()-1);
		} 
	}
	
	public synchronized void showListNumbers() {
		for(int i : numeros) {
			System.out.print(i + ", ");
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