package notizverwaltung.model.classes;

import javafx.beans.property.*;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import java.util.Date;

/**
 *  Klasse fuer NotizFX. Die Klasse implementiert das NotizFX Interface.
 *
 * @author Tobias Gottschalk
 * @author Michelle Blau
 *
 * @version 1.0
 */

public class NotizFXImpl implements NotizFX {

    private IntegerProperty notizID;
    private StringProperty title;
    private IntegerProperty kategorieID;
    private StringProperty kategorieName;
    private IntegerProperty bearbeitungszustandID;
    private StringProperty beschreibung;
    private BooleanProperty prioritaet;
    private ObjectProperty<Date> faelligkeit;
    private BooleanProperty istErinnerungGesetzt;
    private ObjectProperty<Date> erinnerung;
    private ObjectProperty<Date> erstellung;
    private IntegerProperty notizblockID;

    public NotizFXImpl(){
        notizID = new SimpleIntegerProperty();
        title = new SimpleStringProperty();
        kategorieID = new SimpleIntegerProperty();
        kategorieName = new SimpleStringProperty();
        bearbeitungszustandID = new SimpleIntegerProperty();
        beschreibung = new SimpleStringProperty();;
        prioritaet = new SimpleBooleanProperty();
        faelligkeit = new SimpleObjectProperty<Date>();
        istErinnerungGesetzt = new SimpleBooleanProperty();
        erinnerung = new SimpleObjectProperty<Date>();;
        erstellung = new SimpleObjectProperty<Date>();
        notizblockID = new SimpleIntegerProperty();;

    }


    /**
     *
     * @return Gibt die NotizID als IntegerProperty zueureck
     */
    @Override
    public IntegerProperty getNotizID() {
        return notizID;
    }

    /**
     * Setzt die NotizID
     * @param notizID NotizID
     */
    @Override
    public void setNotizID(int notizID) {
        IntValidator.checkObIntNullOderNegativIst(notizID);
        this.notizID.set(notizID);

    }

    /**
     * Die Methode liefert ein den Title als StringProperty
     * @return Liefert den Title der Notiz als Stringproperty zurueck
     */
    @Override
    public StringProperty getTitle() {
        return title;
    }

    /**
     * Die Methode setzt den Title
     * @param title Title als String. Der String darf nicht leer sein.
     */
    @Override
    public void setTitle(String title) {
        StringValidator.checkObStringLeerOderNullIst(title);
        //TODO Wo ist der Unterschied zwischen set und setValue? Olbertz benutzt set
        this.title.set(title);
        //this.title.setValue(title);
    }

    /**
     * Die Methode liefert ein KategorieID als Integer
     * @return Liefert die KategorieID als IntegerProperty zurueck
     */
    @Override
    public IntegerProperty getKategorieID() {
        return kategorieID;
    }

    /**
     * Die Methode setzt die KategorieID
     * @param kategorieID KategorieID als Integer. Der Integer darf nicht kleiner als 1 sein
     */
    @Override
    public void setKategorieID(int kategorieID) {
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        this.kategorieID.set(kategorieID);

    }

    /**
     * Die Methode liefert den Bearbeitungszustand einer Notiz als IntegerProperty
     * @return Liefert die ID des Bearbeitungszustand als IntegerProperty zurueck
     */
    @Override
    public IntegerProperty getBearbeitungszustandID() {
        return bearbeitungszustandID;
    }

    /**
     * Die Methode setzt den Bearbeitungszustand
     * @param bearbeitungszustandID BearbeitungszustandID als Integer. Der Integer darf nicht kleiner als 1 sein
     */
    @Override
    public void setBearbeitungszustandID(int bearbeitungszustandID) {
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustandID);
        this.bearbeitungszustandID.set(bearbeitungszustandID);


    }

    /**
     * Die Methode gibt die Beschreibung als StringProperty zurueck
     * @return Liefert die Beschreibung der Notiz als StringProperty zurueck
     */
    @Override
    public StringProperty getBeschreibung() {
        return beschreibung;
    }

    /**
     * Die Methode setzt die Beschreibung
     * @param beschreibung Beschreibung als String. Der String darf nicht leer oder null sein.
     */
    @Override
    public void setBeschreibung(String beschreibung) {
        StringValidator.checkObStringLeerOderNullIst(beschreibung);
        this.beschreibung.set(beschreibung);

    }

    /**
     * Die Methode liefert ein BooleanProperty Objekt zurueck
     * @return Prioritaet als BooleanProperty
     */
    @Override
    public BooleanProperty getPrioritaet() {
        return prioritaet;
    }

    /**
     * Die Methode setzt die Prioritaet als boolean
     * @param prioritaet als boolean
     */
    @Override
    public void setPrioritaet(boolean prioritaet) {
        this.prioritaet.set(prioritaet);

    }

    /**
     * Die Methode gibt das Faelligkeitsdatum als ein ObjectProperty mit Typ Date zurueck
     * @return ObjectProperty mit Type Date
     */
    @Override
    public ObjectProperty<Date> getFaelligkeit() {
        return faelligkeit;
    }

    /**
     * Die Methode setzt das Faelligkeitsdatum
     * @param faelligkeit Date Objekt
     */
    @Override
    public void setFaelligkeit(Date faelligkeit) {
        ObjectValidator.checkObObjectNullIst(faelligkeit);
        this.faelligkeit.set(faelligkeit);


    }
    
    /**
     * Die Methode liefert ein BooleanProperty zurueck
     * @return BooleanProperty. Value ist true, wenn das Erinnerungsdatum gesetzt ist. Anderenfalls ist das Value false
     */
    @Override
    public BooleanProperty istErinnerungGesetzt() {
        return istErinnerungGesetzt;
    }

    /**
     * Die Methode liefert ein ObjectProperty mit dem Typ Date zurueck. Das Date Objekt, ist das
     * Erinnerungsdatum der Notiz
     * @return ObjectProperty
     */
    @Override
    public ObjectProperty<Date> getErinnerung() {
        return erinnerung;
    }

    /**
     * Die Methode setzt ein Erinnerungsdatum
     * @param erinnerung Erinnerung als Date Objekt
     */
    @Override
    public void setErinnerung(Date erinnerung) {
        this.erinnerung.set(erinnerung);
    }

    /**
     * Die Methode liefert ein das Erstellungsdatum als ObjectProperty zurueck
     * @return ObjectProperty mit Type Date
     */
    @Override
    public ObjectProperty<Date> getErstellung() {
        return erstellung;
    }

    /**
     * Die Methode setzt das Erstellungsdatum
     * @param erstellung Erstelldatum als Date
     */
    @Override
    public void setErstellung(Date erstellung) {
       this.erinnerung.set(erstellung);

    }


    /**
     * NotizFX sind gleich, wenn sie die gleiche ID haben
     * @param object zu vergleichende NotizFX
     * @return true, wenn ID gleich, sonst false
     * @author Michelle Blau
     */
    @Override
    public boolean equals(Object object){
        if (object instanceof NotizFX){
            NotizFX vergleichsNotizFX = (NotizFXImpl) object;
            int vergleichdsID = vergleichsNotizFX.getNotizID().getValue();
            int eigeneID = this.notizID.getValue();

            if (eigeneID == vergleichdsID){
                return true;
            }
        }
        return false;
    }


    /**
     * Vergleicht Notizen in Abhängigkeit von ihrem Fälligkeitsdatum
     * @param vergleichsNotiz
     * @return -1, 0 , oder 1, wenn "faelligkeitDieserNotiz" kleiner, gleich, größer ist
     *
     * @author Michelle Blau
     */
    @Override
    public int compareTo(NotizFX vergleichsNotiz){
        Date faelligkeitDieserNotiz = this.getFaelligkeit().getValue();
        Date vergleichsFaelligkeit = vergleichsNotiz.getFaelligkeit().getValue();

        return faelligkeitDieserNotiz.compareTo(vergleichsFaelligkeit);
    }

    /**
     * toString Methode
     * @return Title einer Notiz als String
     */
    @Override
    public String toString(){
        return title.getValue();
    }


}
