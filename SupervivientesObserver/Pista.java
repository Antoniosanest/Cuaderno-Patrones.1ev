class Pista {

    private Participante c1;
    private Participante c2;
    private int meta;
    public boolean hayGanador = false;

    public Pista(int meta) {
        this.meta = meta;
    }

    public int getMeta() {
        return meta;
    }

    public void setParticipantees(Participante c1, Participante c2) {
        c1.setPista(this);
        c2.setPista(this);
        this.c1 = c1;
        this.c2 = c2;
    }


    public void empezarCarrera() {
        
            c1.start();
            c2.start();
 


    }

//ANUNCIAMOS EL GANADOR Y FINALIZAMOS CARRERA

    public synchronized void cruzarMeta(Participante Participante) {
        if(!hayGanador) {
            hayGanador = true;
           
            System.out.println("Carrera finalizada");
            System.out.println("El equipo de la " + Participante.getNombre()+ " ha ganado !");

        }
    }

}
