package main.notizverwaltung.model.interfaces;

public interface NutzerprofilInterface {
    public String getBenutzer();


    //Security; Eventuell als Hash oder in eigenes Package
    //Nicht in Klartext
    public String getPassword();

    //Ich glaube hier ist es besser ein String als Hash und liefert ein boolean
    //zurueck ob es stimmt
    public boolean checkPasswort(String zuUeberpruefendesPasswort);

    //Nur wenn der Nutzer sein alltes Passwort eingibt, wird geaendert
    public void setPassword(String altesPassword);
}
