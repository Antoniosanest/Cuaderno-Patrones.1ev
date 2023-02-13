/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron;

import patron.abstract_builder.PizzaBuilder;
import patron.concrete_builder.HawaiiPizzaBuilder;
import patron.concrete_builder.PicantePizzaBuilder;

/**
 *
 * @author A10-PC115
 */
public class PIZZA_FACTORY {
    public final static  int HAWAII_PIZZA=1;
    public final static  int PICANTE_PIZZA=2;
    
    public static PizzaBuilder getInstance (int pizzaSelected){
        PizzaBuilder pizza= null;
        switch(pizzaSelected){
            case HAWAII_PIZZA:
                pizza= new HawaiiPizzaBuilder();
                break;
            case PICANTE_PIZZA:
                pizza = new PicantePizzaBuilder();
                break;
        }
        return pizza;
    }
}
