package ModeloProductorConsumidor;

import java.util.ArrayList;
import java.util.Random;

public class Productor implements Runnable{
	
	private int id;
	private ArrayList<Integer> numerosProducidos = null;
	private Random ale = new Random();
	
//CONSTRUCTOR
	public Productor(int id) {
		super();
		this.id = id;
	}

//METODOS
	@Override
	public void run() {
		try {
			int num = ale.nextInt();
			
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	

	
}
