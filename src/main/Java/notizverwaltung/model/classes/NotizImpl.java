package notizverwaltung.model.classes;

import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import javax.persistence.*;
import java.util.Date;

/**
 * Die Klasse ist eine Modelklasse fuer Notizen
 *
 * @author Tobias Gottschalk
 * @author Shenna RWP
 * @author Agra Bimantara
 * @author Michelle Blau
 *
 * @version 1.0
 */

@Entity
@Table(name = "Notiz")
public class NotizImpl implements Notiz
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotizID", nullable = false, unique = true)
    private int notizID;

    @Column(name = "Title")
    private String title;

    @Column(name = "KategorieID")
    private int kategorieID;

    @Column(name = "BearbeitungszustandID")
    private int bearbeitungszustandID;

    @Column(name = "Beschreibung")
    private String beschreibung;

    @Column(name = "Prioritaet")
    private boolean prioritaet;

    @Temporal(TemporalType.DATE)
    @Column(name = "Faelligkeit")
    private Date faelligkeit;

    private boolean istErinnerungGesetzt;

    @Temporal(TemporalType.DATE)
    @Column(name = "Erinnerung")
    private Date erinnerung;

    @Temporal(TemporalType.DATE)
    @Column(name = "Erstellung")
    private Date erstellung;

    @Column(name = "NotizblockID")
    private int notizblockID;


    /**
     * Standard Konstruktor
     */
    public NotizImpl(){
        this.notizblockID = DAOKonstanten.STANDARD_NOTIZBLOCK_ID;
        this.erstellung = new Date();
    }

    //____________________ID____________________
    @Override
    public int getNotizID() {
        return notizID;
    }

    @Override
    public void setID(int notizID) {
        this.notizID = notizID;
    }

    //____________________TITLE____________________

    /**
     * Liefert den Title einer Notiz zurueck
     * @return Title als String
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Die Methode setzt den Title
     * @param title Title als String
     * @throws StringIsEmptyException wirft eine Exception, wenn der String leer oder null ist
     */
    @Override
    public void setTitle(String title) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(title);
        this.title = title;
    }

    //____________________KATEGORIE____________________
    @Override
    public int getKategorieID() {
        return kategorieID;
    }


    /**
     * Die Methode setzt eine neue Kategorie
     * @param kategorieID KategorieID als int
     * @exception IntIstNegativException wirft eine Exception, wenn der Wert kleiner als 1 ist
     */
    @Override
    public void setKategorieID(int kategorieID) throws IntIstNegativException {
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        this.kategorieID = kategorieID;
    }

    //____________________BEARBEITUNGSZUSTAND____________________

    /**
     * Die Methode liefert die ID des Bearbeitungszustand zurueck
     * @return int
     */
    @Override
    public int getBearbeitungszustandID() {
        return bearbeitungszustandID;
    }


    /**
     * Die Methode setzt ein neue BearbeitungszustandsID
     * @param bearbeitungszustandID Die ID des Bearbeitungszustand
     * @throws IntIstNegativException wird geworfen, wenn die BearbeitungszustandID kleiner als 1 ist
     */
    @Override
    public void setBearbeitungszustandID(int bearbeitungszustandID) throws IntIstNegativException{
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustandID);
        this.bearbeitungszustandID = bearbeitungszustandID;

    }

//____________________BESCHREIBUNG____________________
    /**
     * Die Methode liefert die Beschreibung einer Notiz
     * @return Beschreibung als String
     */

    @Override
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Die Methode setzt die Beschreibung einer Notiz
     * @param beschreibung String
     * @throws StringIsEmptyException wirft geworfen, wenn der String leer oder null ist
     */
    @Override
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(beschreibung);
        this.beschreibung = beschreibung;
    }

    //____________________PRIORITÄT____________________

    /**
     * Die Methode gibt die Prioritaet einer Notiz zurueck
     * @return Prioritaet als boolean
     */
    @Override
    public boolean getPrioritaet() {
        return prioritaet;
    }

    /**
     * Die Methode setzt die Prioritaet
     * @param prioritaet als boolean
     */
    @Override
    public void setPrioritaet(boolean prioritaet) {
        this.prioritaet = prioritaet;
    }

    //____________________FÄLLIGKEIT____________________

    //@Temporal(faelligkeit)



    //private Date faelligkeit;

    @Override
    public Date getFaelligkeit() {
        return faelligkeit;
    }

    @Override
    public void setFaelligkeit(Date faelligkeit) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(faelligkeit);
        this.faelligkeit = faelligkeit;
    }

    /**
     * Ueberprueft ob eine Erinnerung gesetzt wurde oder nicht
     * @return Liefert true zurueck, wenn ein Erinnerungsdatum gesetzt wurde. Anderenfalls wird false zurueck geliefert
     */
    //____________________ERRINERUNG____________________
    @Override
    public boolean istErinnerungGesetzt() {
        return istErinnerungGesetzt;
    }

    /**
     * Die Methode liefert die Erinnerung als Date Objekt zurueck
     * @return Date Objekt
     */
    @Override
    public Date getErinnerung() {
        return erinnerung;
    }

    /**
     * Die Methode setzt die Erinnerung
     * @param erinnerung Erinnerung als Date Objekt
     * @throws ObjectIstNullException wirft eine Exception, wenn das Date Objekt null ist
     */
    @Override
    public void setErinnerung(Date erinnerung) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(erinnerung);
        this.erinnerung = erinnerung;
        this.istErinnerungGesetzt = true;
    }

    //____________________ERSTELLUNG____________________
    @Override
    public Date getErstellung() {
        return erstellung;
    }


    /**
     * Notizen sind gleich, wenn sie die gleiche ID haben
     * Vergleicht 2 Notizen
     * @param object zu vergleichende Notiz
     * @return true, wenn Notizen gleich, sonst false
     * @author Michelle Blau
     */
    @Override
    public boolean equals(Object object){
        if (object instanceof NotizImpl){
            NotizImpl vergleichsNotiz = (NotizImpl) object;

            if (this.notizID == vergleichsNotiz.getNotizID()){
                return true;
            }
        }
        return false;
    }

    /**
     * Die Methode liefert den Title zurueck
     * @return String
     */
    @Override
    public String toString(){
        return getTitle();
    }

}

