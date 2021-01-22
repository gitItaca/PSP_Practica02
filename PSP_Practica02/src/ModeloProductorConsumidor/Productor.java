package ModeloProductorConsumidor;

import java.util.ArrayList;
import java.util.Random;

public class Productor implements Runnable{
	
	private int id;
	private PilaNumeros numeros = null;
	private int veces = 0;
	
//CONSTRUCTOR
	public Productor(int id, PilaNumeros numeros, int veces) {
		super();
		this.id = id;
		this.numeros = numeros;
		this.veces = veces;
	}
	
//METODOS
	@Override
	public void run() {
		int cont = 0;
		while(cont < veces) {
			numeros.addNumber(cont);
			cont++;
		}
		
		numeros.showListNumbers();
				
	}

	
	
}
