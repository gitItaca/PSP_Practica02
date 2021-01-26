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
		while (cont < veces){
			if(numeros.removeNumber()) {
				cont++;
				System.out.println("Consumiendo");
			}else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.print("Pila vacía, espere por favor.");
					e.printStackTrace();
				}
			}
		}
		//System.out.println("El consumidor ha consumido: ");
		numeros.showListNumbers();
		System.out.println("Números que quedan después de haber consumido.");
	}
	

}
