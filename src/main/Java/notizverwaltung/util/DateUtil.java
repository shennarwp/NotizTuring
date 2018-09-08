package notizverwaltung.util;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static notizverwaltung.validators.ObjectValidator.checkObObjectNullIst;

/**
 * Stellt statische Methoden zum bearbeiten von "Date"-Objekten bzw. "LocalDate"-Objekten zur Verfügung
 *
 */
public class DateUtil {

    /**
     * Konvertiert localDate-Objekt zu einem Date-Objekt
     *
     * @param localDate
     * @author "JB Nizet", Michelle Blau
     * @return
     */
    public static Date convertLocalDate(LocalDate localDate){
        if (localDate == null){
            return null; //TODO geht vielleicht anders
        }
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }
}
