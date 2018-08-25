package main.java.notizverwaltung.dao.interfaces;

import main.java.notizverwaltung.model.interfaces.Notizblock;

public interface NotizblockDAO {
    public Notizblock getNotizblock();
    public void addNotizblock (Notizblock notizblock);
    public void removeNotizblock(int notizblockID);
}
