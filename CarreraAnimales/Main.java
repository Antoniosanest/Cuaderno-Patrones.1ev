public class Main {
    public static void main(String[] args) {
        
        Corredor corredor1 = new Corredor("Liebre");
        Corredor corredor2 = new Corredor("Tortuga");
        Corredor corredor3 = new Corredor("Alberto");
        Corredor corredor4 = new Corredor("Cucaracha");
        Corredor corredor5 = new Corredor("Caracol");
        Pista pista = new Pista(100);
        pista.setCorredores(corredor1, corredor2, corredor3, corredor4, corredor5);
        pista.empezarCarrera();
    }
}