package main.notizverwaltung.model.classes;

public class Bearbeitungszustand {

    final private int maximaleAnzahlAnBearbeitungszustaende = 10;

    private String[] bearbeitungszustaende;

    public Bearbeitungszustand(){

        bearbeitungszustaende = new String[maximaleAnzahlAnBearbeitungszustaende];
    }


}
