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

    @Override
    public int getNutzerprofilID() {
        return nutzerprofilID;
    }

    @Override
    public void setNutzerprofilID(int nutzerprofilID) {
        this.nutzerprofilID = nutzerprofilID;
    }

    @Override
    public String toString(){
        return getNutzerprofilID();
    }

}
