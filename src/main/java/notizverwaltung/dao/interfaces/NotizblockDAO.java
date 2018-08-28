package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NotizblockImpl;

/**
 * @author Agra Bimantara
 */

public interface NotizblockDAO {
    public NotizblockImpl getNotizblock();
    public void addNotizblock (NotizblockImpl notizblockImpl);
    public void removeNotizblock(int notizblockID);
}
