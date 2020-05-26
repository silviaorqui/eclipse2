package primerapracticaHilos;

public class ClasePrincipal {

	public static void main(String [] args)
	{
		Proceso1 hilo1 = new Proceso1(); //creamos objeto porque hemos utilizado extends Thread
		Proceso1 hilo3 = new Proceso1();
		Thread hilo2 = new Thread(new Proceso2()); 
		//creamos objeto Thread porque hemos implementado Runnable
		//y como argumento le indicamos que debe ser de la clase proceso2
		
		hilo1.start();
		hilo2.start();	
		hilo3.start();
	}
}
