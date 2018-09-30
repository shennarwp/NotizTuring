package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.Nutzerprofil;

import javax.persistence.*;

@Entity
@Table(name = "Nutzerprofil")
public class NutzerprofilImpl implements Nutzerprofil
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NutzerprofilID", nullable = false, unique = true)
    private int nutzerprofilID;

    /**
     * getter-Methode von ID der Nutzerprofil
     * @return ID der Nutzerprofil
     */
    @Override
    public int getNutzerprofilID() {
        return nutzerprofilID;
    }


    /**
     * setter-Methode von ID der Nutzerprofil
     * @param nutzerprofilID
     */
    @Override
    public void setNutzerprofilID(int nutzerprofilID) {
        this.nutzerprofilID = nutzerprofilID;
    }

    /**
     * ToString Methode
     * @return Liefert die NutzerprofilID als String zurueck
     */
    @Override
    public String toString(){
        return new Integer(getNutzerprofilID()).toString();

    }

}
