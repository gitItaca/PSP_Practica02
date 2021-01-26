package ModeloProductorConsumidor;

public class Consumidor implements Runnable{
	
	private int id;
	private PilaNumeros numeros = null;
	private int veces = 0;
	
//CONSTRUCTOR
	public Consumidor(int id, PilaNumeros numeros, int veces) {
		this.id = id;
		this.numeros = numeros;
		this.veces = veces;
	}

	@Override
	public void run() {
		int cont = 0;
		while (cont < veces){					//Mientras el contador sea menor que las veces que consuma, quita un numero de la pila y suma un punto al contador.
			try {
				if(numeros.removeNumber()) {
					cont++;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		numeros.showListNumbers();				//Cuando termina de consumir imprime los numeros que quedan en la pila.
	}
	

}


//System.out.println(Thread.currentThread().getState());		
//System.out.println(Thread.currentThread().getName());	