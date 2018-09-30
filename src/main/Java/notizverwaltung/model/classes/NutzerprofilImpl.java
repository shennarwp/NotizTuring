package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.Nutzerprofil;

import javax.persistence.*;

/**
 * @author Agra Bimantara
 * @author Shenna RWP
 */
@Entity
@Table(name = "Nutzerprofil")
public class NutzerprofilImpl implements Nutzerprofil
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NutzerprofilID", nullable = false, unique = true)
    private int nutzerprofilID;

    @Override
    public int getNutzerprofilID() {
        return nutzerprofilID;
    }

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
