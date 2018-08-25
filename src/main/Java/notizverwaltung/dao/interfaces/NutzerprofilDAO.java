package main.java.notizverwaltung.dao.interfaces;

import main.java.notizverwaltung.model.interfaces.Nutzerprofil;

public interface NutzerprofilDAO {
    public void addNutzerprofil(Nutzerprofil nutzerprofil);
    public void deleteNutzerprofil(Nutzerprofil nutzerprofil);
    public void updateNutzerprofil(Nutzerprofil nutzerprofil);

    public Nutzerprofil getNutzerprofil(int NutzerprofilID);
}
