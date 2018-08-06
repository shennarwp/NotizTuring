package main.notizverwaltung.model.interfaces;

public interface BearbeitungszustandInterface {
    public String[] getBearbeitungszustand();
    public void addBearbeitungszustand(String neuerBearbeitungszustand);
    public void modifiyBearbeitungszustand (String alterBearbeitungszustand, String neuerBearbeitungszustand);
    public void removeBearbeitungszustand (String zuloeschenderBearbeitungszustand);



}
