package primerapracticaHilos;

public class Proceso1 extends Thread{

	//cuando heredamos de clase Thread nos vemos obligados a utilizar el metodo run
	
	@Override 
	public void run() {
		
		for (int i = 0; i<=5; i++)
		{
			System.out.println("Proceso 1");
		}
		
	}

}
