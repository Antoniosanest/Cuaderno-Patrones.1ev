
package patron_adapter;

/**
 *
 * @author A10-PC115
 */
public class PATRON_ADAPTER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conectable lampara = new Lampara();
        Conectable ordenador = new Ordenador();
        
        lampara.encender();
        System.out.println("Esta encendiada: "+ lampara.isEncendida());
        ordenador.encender();
        System.out.println("Esta encendido: "+ ordenador.isEncendida());
        
    }
    private static void encenderAparato(Conectable ll){
        ll.encender();
        System.out.println(ll.isEncendida());
    }
    
}
