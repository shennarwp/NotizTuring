package main.notizverwaltung.dao.interfaces;

import main.notizverwaltung.model.classes.Notizblock;

public interface NotizblockDAO {
    public Notizblock getNotizblock();
    public void removeNotizblock(int notizblockID);
}
