package main.java.notizverwaltung.service.interfaces;

import main.java.notizverwaltung.model.interfaces.Bearbeitungszustand;

public interface BearbeitungszustaendeService {

    public void addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);
    public Bearbeitungszustand getBearbeitungszustand (int bearbeitungszustandID);
    public void deleteBearbeitungszustand (int bearbeitungszustandID);
    //TODO Unterschied zwischen save und update?
    public void updateBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);

}
