package notizverwaltung.model.interfaces;

import java.util.Date;

public interface Erinnerung {

    public Date getErinnterungsDatum();
    public void setErinnterungsDatum(Date datum);
    public boolean setIstErinnerungsdatumGesetzt();
    public boolean getIstErinnerungsdatumGesetzt();

}
