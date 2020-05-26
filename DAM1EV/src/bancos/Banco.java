package bancos;

import java.util.concurrent.locks.*;

public class Banco {

private final double [] cuentas;
	
	public Banco()
	{
		cuentas=new double[100]; //las cuentas irán del 0 al 99
		
		for (int i=0;i<cuentas.length;i++)
		{
			cuentas[i]=2000;
		}
		
		//saldoSuficiente=cierreBanco.newCondition();
	}

	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException
	{
		//cierreBanco.lock();
		
		//try {
					
			while(cuentas[cuentaOrigen]<cantidad) //evalúa que el saldo no es inferior a la transferencia
				{
					//saldoSuficiente.await();
					wait();
				}
				
			System.out.println(Thread.currentThread()); //para ver qué hilo hace la transferencia
		
			cuentas[cuentaOrigen]-=cantidad;  //dinero que sale de la cuenta origen
		
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
		
			//ahora la cuenta destino debe incrementar su saldo.
			cuentas[cuentaDestino]+=cantidad;
		
			System.out.printf(" Saldo total: %10.2f\n", getSaldoTotal());
			
			//saldoSuficiente.signalAll();
			notifyAll();
		
		//}finally
			//{
				//cierreBanco.unlock();
			//}
	}
	
	public double getSaldoTotal()
	{
		double suma_cuentas=0;
		
		for (double a:cuentas)
		{
			suma_cuentas+=a;
		}
		return suma_cuentas;
	}
	
	//private Lock cierreBanco = new ReentrantLock();
	
	//private Condition saldoSuficiente;
	
}
