package hiloscajera;


import hiloscajera.Cliente;
/**
 *
 * @author ArturoExamen
 */

public class Cajera implements Runnable {

	private Cliente cliente;
	private long initialTime;
        private String nombre;

	public Cajera(Cliente cliente, long initialTime, String nombre) {
		this.cliente = cliente;
		this.initialTime = initialTime;
                this.nombre = nombre;
	}

	@Override
	public void run() {
            //TIENE QUE SALIR POR PANTALLA La cajera (ombre) COMIENZA A PROCESAR LA COMPRA DEL CLIENTE (nombre cliente) EN EL TIEMPO: (tiempo)
            //Procesado el producto (1) del cliente (nombre cliente)->Tiempo: (tiempo)
		System.out.println("La cajera " + this.nombre 
				+ " procesando compra del cliente " + this.cliente.getNombre() 
				+ " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

		for (int i = 0; i < this.cliente.getCarroCompra().length; i++) { 			
                   
                    this.esperarXsegundos(cliente.getCarroCompra()[i]);
               	    System.out.println("Procesado el producto " + (i + 1) + " del " + this.cliente.getNombre()+ 
                    "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		}

		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " 
				+ this.cliente.getNombre() + " EN EL TIEMPO: "
				+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
                    //EL TIEMPO DE LOS PROCESOS SE VA ACUMULANDO 

	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
        }
