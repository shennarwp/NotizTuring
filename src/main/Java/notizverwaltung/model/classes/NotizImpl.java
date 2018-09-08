package notizverwaltung.model.classes;

import javafx.scene.paint.Color;
import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;

/**
 * Die Klasse ist eine Modelklasse fuer Notizen
 *
 * @author Tobias Gottschalk
 * @author Shenna RWP
 * @author Agra Bimantara
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


    public NotizImpl(String title, String kategorie, String bearbeitungszustand, String beschreibung, boolean prioritaet,
                     Date faelligkeit, Date erinnerung) throws StringIsEmptyException, ObjectIstNullException, IntIstNegativException {
        setTitle(title);
        setKategorie(kategorie);
        setBearbeitungszustand(bearbeitungszustand);
        setBeschreibung(beschreibung);
        setPrioritaet(prioritaet);
        setFaelligkeit(faelligkeit);
        setErinnerung(erinnerung);
    }

    /**
     * //TODO Konstruktor ohne Erinnerungsdatum, mit Kategorie-Objekt statt String
     *
     *
     * @param title
     * @param kategorie
     * @param bearbeitungszustand
     * @param beschreibung
     * @param prioritaet
     * @param faelligkeit
     * @throws StringIsEmptyException
     * @throws ObjectIstNullException
     * @throws IntIstNegativException
     */
    public NotizImpl(String title, String kategorie, String bearbeitungszustand, String beschreibung, boolean prioritaet,
                     Date faelligkeit) throws StringIsEmptyException, ObjectIstNullException, IntIstNegativException {
        setTitle(title);
        setKategorie(kategorie);
        setBearbeitungszustand(bearbeitungszustand);
        setBeschreibung(beschreibung);
        setPrioritaet(prioritaet);
        setFaelligkeit(faelligkeit);

    }


    /**Konstruktor mit den minimalen Parameter zum Erstellen einer NotizImpl
     * @param title
     * @param beschreibung
     * @throws IOException
     */

    //TODO muss jeder Notiz beim Erstellen ein Bearbeitunszustand/Spalte zugewiesen werden?
    public NotizImpl(String title, String beschreibung) throws StringIsEmptyException, ObjectIstNullException, IntIstNegativException {
        setTitle(title);
        //setKategorie("others");
        //setBearbeitungszustand("todo");
        setBeschreibung(beschreibung);
        setPrioritaet(prioritaet);
        setFaelligkeit(new Date());
        setErinnerung(new Date());
    }


    public NotizImpl() {}

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
    @Override
    public String getTitle() {
        return title;
    }

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

    @Override
    public String getKategorie() {
        return ServiceObjectBuilder.getKategorieService().getKategorie(kategorieID).getKategorieName();
    }

    @Override
    public void setKategorie(String kategorieName) throws IntIstNegativException {
        Kategorie kategorie = ModelObjectBuilder.getKategorieObjekt(kategorieName);
        this.kategorieID = ServiceObjectBuilder.getKategorieService().addKategorie(kategorie);
    }

    //TODO Kategorie soll als Klasse verwendet werden und nicht nur als String
    @Override
    public void setKategorie(Kategorie kategorie) {

    }

    //____________________BEARBEITUNGSZUSTAND____________________
    @Override
    public int getBearbeitungszustandID() {
        return bearbeitungszustandID;
    }

    @Override
    public String getBearbeitungszustand() {
        return ServiceObjectBuilder.getBearbeitungszustandService().getBearbeitungszustand(bearbeitungszustandID).getName();
    }

    @Override
    public void setBearbeitungszustand(String nameDerSpalte) throws StringIsEmptyException {
        Bearbeitungszustand bearbeitungszustand = ModelObjectBuilder.getBearbeitungszustandObjekt(nameDerSpalte);
        this.bearbeitungszustandID = ServiceObjectBuilder.getBearbeitungszustandService().addBearbeitungszustand(bearbeitungszustand);
    }

    //TODO
    @Override
    public void setBearbeitungszustand(Bearbeitungszustand bearbeitungszustand) {

    }

    //____________________BESCHREIBUNG____________________
    @Override
    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(beschreibung);
        this.beschreibung = beschreibung;
    }

    //____________________PRIORITÄT____________________
    @Override
    public boolean getPrioritaet() {
        return prioritaet;
    }

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

    //____________________ERRINERUNG____________________
    @Override
    public boolean istErinnerungGesetzt() {
        return istErinnerungGesetzt;
    }

    @Override
    public Date getErinnerung() {
        return erinnerung;
    }

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


    @Override
    public String toString(){
        return getTitle();
    }

}

