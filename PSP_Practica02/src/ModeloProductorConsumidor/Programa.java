package ModeloProductorConsumidor;

public class Programa {

	public static void main(String[] args) {
		PilaNumeros pila = new PilaNumeros(3);
		Productor productor = new Productor(1, pila, 3);
		Consumidor consumidor = new Consumidor(1, pila, 3);
		
		Thread thread_Productor = new Thread(productor);
		Thread thread_Consumidor = new Thread(consumidor);
		
		thread_Productor.start();
		thread_Consumidor.start();
		
		while(thread_Productor.isAlive() || thread_Consumidor.isAlive()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}

}
