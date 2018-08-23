package notizverwaltung.dao.interfaces;

import model.classes.Notizblock;

public interface NotizblockDAO {
    public Notizblock getNotizblock();
    public void addNotizblock (Notizblock notizblock);
    public void removeNotizblock(int notizblockID);
}
