package ModeloProductorConsumidor;

import java.util.ArrayList;

public class PilaNumeros {
	
	private static ArrayList<Integer> numeros = new ArrayList<Integer>();

//CONSTRUCTOR
	public PilaNumeros() {		
	}
	
//METODOS
	public synchronized void addNumber(int number) {
		numeros.add(number);
	}
	
	public synchronized void removeNumber() {
		int numTemporal = 0;
		
		numeros.remove(0);
		
		//Subo un puesto todos los numeros de la lista
		for(int x=1; x< numeros.size(); x++) {
			numTemporal = numeros.get(x);	//Cojo el numero que esta en la posicion 1
			numeros.set(x-1, numTemporal);	//Meto ese numero en la misma lista pero una posicion mas arriba
		}
		
		//Mover toda la lista una posicion arriba.
		
	}
	
	public synchronized void showListNumbers() {
		for(int i : numeros) {
			System.out.print(i + ", ");
		}
	}
}
