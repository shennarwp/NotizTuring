package notizverwaltung.model.interfaces;

import notizverwaltung.exceptions.StringIsEmptyException;



public interface Bearbeitungszustand
{

    public int getBearbeitungsZustandID();
    public void setBearbeitungszustandID(int bearbeitungszustandID);

    public String getName();
    public void setName(String nameDerSpalte) throws StringIsEmptyException;

	public int getPosition();
    public void setPosition(int position);

}
