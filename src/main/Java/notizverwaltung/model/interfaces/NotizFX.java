package notizverwaltung.model.interfaces;

import notizverwaltung.exceptions.StringIsEmptyException;

import java.util.Date;

public interface NotizFX {

    public int getNotizID();
    public void setNotizID(int notizID);

    public String getTitle();
    public void setTitle(String title);

    public int getKategorieID();
    public void setKategorieID(int kategorieID);

    public int getBearbeitungszustandID();
    public void setBearbeitungszustandID(int bearbeitungszustandID);

    public String getBeschreibung();
    public void setBeschreibung(String beschreibung);

    public boolean getPrioritaet();
    public void setPrioritaet(boolean prioritaet);

    public Date getFaelligkeit();
    public void setFaelligkeit(Date faelligkeit);

    public boolean istErinnerungGesetzt();
    public Date getErinnerung();
    public void setErinnerung(Date erinnerung);


    public Date getErstellung();
    public void setErstellung(Date erstellung);



}
