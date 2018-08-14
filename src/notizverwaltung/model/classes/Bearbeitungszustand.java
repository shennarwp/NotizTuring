package notizverwaltung.model.classes;

import notizverwaltung.util.PropertiesLoader;

import java.io.IOException;

public class Bearbeitungszustand  {



    private String[] bearbeitungszustaende;

    public Bearbeitungszustand() throws IOException {
        final int maximaleAnzahlAnBearbeitungszustaende = Integer.parseInt(PropertiesLoader.loadPropertie("AnzahlDerBearbeitungsZustaende"));	;
        bearbeitungszustaende = new String[maximaleAnzahlAnBearbeitungszustaende];
    }


}
