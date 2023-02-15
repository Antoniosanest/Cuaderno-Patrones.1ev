public class Main {
    public static void main(String[] args) {

        Comprador grupo1 = new Comprador("100 primeras");
        Comprador grupo2 = new Comprador("200 siguientes");
        Comprador grupo3 = new Comprador("300 ultimas");

        // ponemos las existencias que hay en la tienda
        Tienda tienda = new Tienda();

        System.out.println("Se dividen los 3 grupos y empiezan a comprar");

        tienda.setParticipantees(grupo1, grupo2, grupo3);
        tienda.empezarCompra();
    }
}