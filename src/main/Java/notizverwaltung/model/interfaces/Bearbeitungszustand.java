package notizverwaltung.model.interfaces;

import notizverwaltung.exceptions.StringIsEmptyException;



public interface Bearbeitungszustand
{

    //____________________ID____________________
    public int getBearbeitungsZustandID();
    public void setBearbeitungszustandID(int bearbeitungszustandID);

    //____________________Name____________________
    public String getName();
    public void setName(String nameDerSpalte) throws StringIsEmptyException;

    //____________________Position____________________
	public int getPosition();
    public void setPosition(int position);

}
