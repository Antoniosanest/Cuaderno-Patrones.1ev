public class Main {
    public static void main(String[] args) {

        Participante Equipo1 = new Participante("persona 1");
        Participante Equipo2 = new Participante("persona 2");

        // LOS METEMOS EN SUS CORRESPONDIENTES EQUIPOS
        Participante[] participantes = new Participante[2];
        participantes[0] = Equipo1;
        participantes[1] = Equipo2;

        // los dos participantes de cada equipo corren hasta que uno llegue a la meta

        Pista pista = new Pista(100);
        pista.setParticipantees(participantes[0], participantes[1]);
        pista.empezarCarrera();
    }
}
