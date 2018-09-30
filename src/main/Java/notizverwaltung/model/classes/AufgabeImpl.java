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


    /**
     *getter-Mehtode ID der Aufgabe
     * @return ID der Aufgabe
     */
    @Override
    public int getAufgabeID(){
        return this.aufgabeID;
    }

    /**
     * setter-Methode von ID der Aufgabe
     * @param aufgabeID
     */
    @Override
    public void setAufgabeID(int aufgabeID){
        this.aufgabeID = aufgabeID;
    }

    /**
     * getter-Mehtode Beschreibung von Aufgabe
     * @return Beschreibung von Aufgabe
     */

    @Override
    public String getBeschreibung(){
        return this.beschreibung;
    }

    /**
     * Setter-Methode von Bescheibung der Aufgabe
     * @param beschreibung
     * @throws StringIsEmptyException
     */
    @Override
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(beschreibung);
        this.beschreibung=beschreibung;
    }

    /**
     * getter-Mehtode von Bearbeitet-Status der Aufgabe
     * @return Bearbeitet-Status der Aufgabe
     */
    @Override
    public boolean getBearbeitet(){
        return this.bearbeitet;
    }

    /**
     * setter-Methode von Bearbeitet-Status der Aufgabe
     * @param bearbeitet
     */
    @Override
    public void setBearbeitet(boolean bearbeitet){
        this.bearbeitet = bearbeitet;
    }

    /**
     * toString-Mehtode
     * @return alle inhalte Attribute von Aufgabe als String
     */

    @Override
    public String toString() {
        return "AufgabeImpl{" +
                "aufgabeID=" + aufgabeID +
                ", beschreibung='" + beschreibung + '\'' +
                ", bearbeitet=" + bearbeitet +
                '}';
    }
}


