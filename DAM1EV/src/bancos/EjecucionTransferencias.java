package bancos;

public class EjecucionTransferencias implements Runnable {

	private Banco banco;
	private int cuentaOrigen;
	private double cantidadMax; //2000 euros
	
	public EjecucionTransferencias(Banco b, int cuentaOrigen, double cantidadMax)
	{
		this.banco=b;
		this.cuentaOrigen=cuentaOrigen;
		this.cantidadMax = cantidadMax;
		System.out.println("Hola Mundo");
	}
	    
	@Override
	public void run(){
		try {
			while(true)
			{
				//Nuestras cuentas estan numeradas del 0 al 99
				int cuentaDestino=(int)(Math.random()*100);
				double cantidad = cantidadMax*Math.random(); //para que no pase de 2000
			
				banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);
			
				//para que lo haga de forma lenta y podamos verlo 
				//tenemos que dormir los hilos
				
				Thread.sleep(1000);
			} 
				
				
			}catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		
	}
	
}
