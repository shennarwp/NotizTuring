package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.Notizblock;

import javax.persistence.*;

/**
 * @author Agra Bimantara
 * @author Shenna RWP
 */
@Entity
@Table(name = "Notizblock")
public class NotizblockImpl implements Notizblock
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotizblockID", nullable = false, unique = true)
    private int notizblockID;

    @Override
    public int getNotizblockID() {
        return notizblockID;
    }

    @Override
    public void setNotizblockID(int notizblockID) {
        this.notizblockID = notizblockID;
    }

    /**
     * ToString Methode. Liefert die NotizblockID als String
     * @return String
     */
    @Override
    public String toString(){
        return new Integer(getNotizblockID()).toString();

    }

}
