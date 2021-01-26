package ModeloProductorConsumidor;


public class Productor implements Runnable{
	
	private int id;
	private PilaNumeros numeros = null;
	private int veces = 0;
	
//CONSTRUCTOR
	public Productor(int id, PilaNumeros numeros, int veces) {
		this.id = id;
		this.numeros = numeros;
		this.veces = veces;
	}
	
//METODOS
	@Override
	public void run() {
		int cont = 0;
		while(cont < veces) {					//Mientras el contador sea menor que las veces que va a producir, añade un numero a la pila y suma uno al contador.
			try {
				if(numeros.addNumber(cont)) {
					cont++;
				};
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}		
		numeros.showListNumbers();				//Cuando termina de producir, muestra los numeros que quedan en la pila.
	}
	
}
