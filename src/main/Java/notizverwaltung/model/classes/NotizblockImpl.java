package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.Notizblock;

import javax.persistence.*;

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

    @Override
    public String toString(){
        return getNotizblockID();

    }

}
