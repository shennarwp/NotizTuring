package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NotizblockImpl;

public interface NotizblockDAO {
    public NotizblockImpl getNotizblock();
    public void addNotizblock (NotizblockImpl notizblockImpl);
    public void removeNotizblock(int notizblockID);
}
