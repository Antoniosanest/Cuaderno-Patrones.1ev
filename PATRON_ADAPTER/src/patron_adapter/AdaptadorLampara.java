
package patron_adapter;


public class AdaptadorLampara implements Conectable {
    private LamparaInglesa lInglesa= new LamparaInglesa();
    @Override
    public void encender() {
         this.lInglesa.on();
    }

    @Override
    public void apagar() {
        this.lInglesa.off();
    }

    @Override
    public boolean isEncendida() {
       return this.lInglesa.isOn();
    }
    
}
