package notizverwaltung.model.classes;

import javafx.beans.property.*;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import java.util.Date;

public class NotizFXImpl implements NotizFX {

    private IntegerProperty notizID;
    private StringProperty title;
    private IntegerProperty kategorieID;
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
        bearbeitungszustandID = new SimpleIntegerProperty();
        beschreibung = new SimpleStringProperty();;
        prioritaet = new SimpleBooleanProperty();
        faelligkeit = new SimpleObjectProperty<Date>();
        istErinnerungGesetzt = new SimpleBooleanProperty();
        erinnerung = new SimpleObjectProperty<Date>();;
        erstellung = new SimpleObjectProperty<Date>();
        notizblockID = new SimpleIntegerProperty();;

    }


    @Override
    public int getNotizID() {
        return notizID.get();
    }

    @Override
    public void setNotizID(int notizID) {
        IntValidator.checkObIntNullOderNegativIst(notizID);
        this.notizID.set(notizID);

    }

    @Override
    public String getTitle() {
        return title.get();
    }

    @Override
    public void setTitle(String title) {
        StringValidator.checkObStringLeerOderNullIst(title);
        //TODO Wo ist der Unterschied zwischen set und setValue? Olbertz benutzt set
        this.title.set(title);
        //this.title.setValue(title);
    }

    @Override
    public int getKategorieID() {
        return kategorieID.get();
    }

    @Override
    public void setKategorieID(int kategorieID) {
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        this.kategorieID.set(kategorieID);

    }

    @Override
    public int getBearbeitungszustandID() {
        return bearbeitungszustandID.get();
    }

    @Override
    public void setBearbeitungszustandID(int bearbeitungszustandID) {
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustandID);
        this.bearbeitungszustandID.set(bearbeitungszustandID);


    }

    @Override
    public String getBeschreibung() {
        return beschreibung.get();
    }

    @Override
    public void setBeschreibung(String beschreibung) {
        StringValidator.checkObStringLeerOderNullIst(beschreibung);
        this.beschreibung.set(beschreibung);

    }

    @Override
    public boolean getPrioritaet() {
        return prioritaet.get();
    }

    @Override
    public void setPrioritaet(boolean prioritaet) {
        this.prioritaet.set(prioritaet);

    }

    @Override
    public Date getFaelligkeit() {
        return faelligkeit.get();
    }

    @Override
    public void setFaelligkeit(Date faelligkeit) {
        ObjectValidator.checkObObjectNullIst(faelligkeit);
        this.faelligkeit.set(faelligkeit);


    }

    //TODO muss ich noch schauen wie das besten gemacht wird
    @Override
    public boolean istErinnerungGesetzt() {
        return istErinnerungGesetzt.get();
    }

    @Override
    public Date getErinnerung() {
        return erinnerung.get();
    }

    @Override
    public void setErinnerung(Date erinnerung) {
        ObjectValidator.checkObObjectNullIst(erinnerung);
        this.erinnerung.set(erinnerung);
    }

    @Override
    public Date getErstellung() {
        return erstellung.get();
    }

    @Override
    public void setErstellung(Date erstellung) {
        ObjectValidator.checkObObjectNullIst(erstellung);
        this.erinnerung.set(erstellung);

    }
}
