package estadosHilos;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		//ESTADO NUEVO
		Hilo_Proceso hilo1 = new Hilo_Proceso();
		Hilo_Proceso hilo2 = new Hilo_Proceso();
		
		//ESTADO RUNNABLE
		hilo1.start();
		
		//ESTADO BLOQUEADO
		try {
		hilo1.sleep(1000); //OJO, está en milisegundos
		}catch(InterruptedException e) {
			System.out.println("Error en el hilo1 " + e);
		}
		hilo2.start();
		
		//ESTADO MUERTO
		//hilo2.stop();
		try {
			hilo2.sleep(1000); //OJO, está en milisegundos
			}catch(InterruptedException e) {
				System.out.println("Error en el hilo1 " + e);
			}
	}
}
