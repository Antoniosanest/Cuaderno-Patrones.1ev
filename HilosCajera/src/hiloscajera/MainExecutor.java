/*

 */
package hiloscajera;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ArturoExamen
 */
public class MainExecutor {
    ExecutorService executor = Executors.newFixedThreadPool(numCajeras);
    private static final int numCajeras = 1;

    public static void main(String[] args) {

        ArrayList<Cliente>clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2 })); 
        clientes.add(new Cliente("Cliente 2", new int[] { 1, 1, 5, 1, 1 })); 
        clientes.add(new Cliente("Cliente 3", new int[] { 5, 3, 1, 5, 2 })); 
        clientes.add(new Cliente("Cliente 4", new int[] { 2, 4, 3, 2, 5 })); 
        clientes.add(new Cliente("Cliente 5", new int[] { 1, 3, 2, 2, 3 })); 
        clientes.add(new Cliente("Cliente 6", new int[] { 4, 2, 1, 3, 1 })); 
   
   
        
        long init = System.currentTimeMillis(); 
        
        ExecutorService executor = Executors.newFixedThreadPool(numCajeras);
        for (Cliente cliente: clientes) {
            Runnable cajera = new Cajera(cliente, init, "Numero 1");
            executor.execute(cajera);
        }
        
        executor.shutdown();
        while (!executor.isTerminated()) {
        
        }
        
        
        long fin = System.currentTimeMillis();	
        System.out.println("Tiempo total al procesar : "+(fin-init)/1000+" Segundos");
    }
}