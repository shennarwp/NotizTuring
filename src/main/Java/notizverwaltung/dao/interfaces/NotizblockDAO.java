package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NotizblockImpl;

/**
 * @author Agra Bimantara
 */

public interface NotizblockDAO extends ObjectDAO {

    public int addNotizblock (NotizblockImpl notizblockImpl);
    public NotizblockImpl getNotizblock();
    public void deleteNotizblock(int notizblockID);
}
