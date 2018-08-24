package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.Notizblock;

public interface NotizblockDAO {
    public Notizblock getNotizblock();
    public void addNotizblock (Notizblock notizblock);
    public void removeNotizblock(int notizblockID);
}
