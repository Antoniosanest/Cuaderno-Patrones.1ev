/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron_adapter;

/**
 *
 * @author A10-PC115
 */
public class Lampara implements Conectable {
    private boolean encendida;
    @Override
    public boolean isEncendida(){
        return this.encendida;
    }
    @Override
    public void encender(){
        this.encendida= true;
    }
    @Override
    public void apagar(){
        this.encendida= false;
    }

    
}
