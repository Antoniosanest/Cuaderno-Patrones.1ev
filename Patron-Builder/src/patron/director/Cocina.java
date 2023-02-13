
package patron.director;

import patron.abstract_builder.Pizza;
import patron.abstract_builder.PizzaBuilder;


public class Cocina {
    private static Cocina cocina;
    
    private Cocina(){
    
    }
    public static Cocina getInstance(){
        if (cocina==null){
            cocina = new Cocina();
        }
        return cocina;
    }
    
    
    private PizzaBuilder pizzaBuilder;
    
    public void setPizzaBuilder(PizzaBuilder pizzaBuilder){
        this.pizzaBuilder = pizzaBuilder;
    }
    
    public void construirPizza(){
        this.pizzaBuilder.crearNuevaPizza();
        this.pizzaBuilder.buildMasa();
        this.pizzaBuilder.buildSalsa();
        this.pizzaBuilder.buildRelleno();
    }
    
    public Pizza getPizza(){
        return this.pizzaBuilder.getPizza();
    }
}
