package notizverwaltung.model.classes;

public class Notizblock {

    // TODO Variable für NotizblockID. Die Variable wird hochgezählt, wenn eine NotizblockID erzeugt wurde. Eventuell in der Serviceklasse relaisieren
    private static int notizblockZählfuerNotizblockID = 1;

    private int notizblockID;


    public Notizblock (){
        this.notizblockID = notizblockZählfuerNotizblockID;
        notizblockZählfuerNotizblockID++;
    }

}
