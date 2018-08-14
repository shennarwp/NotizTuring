package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.Notizblock;

public interface NotizblockDAO {
    public Notizblock getNotizblock();
    public void removeNotizblock(int notizblockID);
}
