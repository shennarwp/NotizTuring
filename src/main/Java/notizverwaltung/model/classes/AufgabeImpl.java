package notizverwaltung.model.classes;

import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Aufgabe;
import notizverwaltung.validators.StringValidator;

import javax.persistence.*;

/**
 * @author Shenna RWP
 */
@Entity
@Table(name = "Aufgabe")
public class AufgabeImpl implements Aufgabe
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AufgabeID", nullable = false, unique = true)
    private int aufgabeID;

    @Column(name = "Beschreibung")
    private String beschreibung;
    private boolean bearbeitet;

    public AufgabeImpl(String beschreibung, boolean bearbeitet) throws StringIsEmptyException {
        setBeschreibung(beschreibung);
        setBearbeitet(bearbeitet);
    }

    public AufgabeImpl() {}

    @Override
    public int getAufgabeID(){
        return this.aufgabeID;
    }

    @Override
    public void setAufgabeID(int aufgabeID){
        this.aufgabeID = aufgabeID;
    }

    @Override
    public String getBeschreibung(){
        return this.beschreibung;
    }

    @Override
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(beschreibung);
        this.beschreibung=beschreibung;
    }

    @Override
    public boolean getBearbeitet(){
        return this.bearbeitet;
    }

    @Override
    public void setBearbeitet(boolean bearbeitet){
        this.bearbeitet = bearbeitet;
    }

    @Override
    public String toString() {
        return "AufgabeImpl{" +
                "aufgabeID=" + aufgabeID +
                ", beschreibung='" + beschreibung + '\'' +
                ", bearbeitet=" + bearbeitet +
                '}';
    }
}


