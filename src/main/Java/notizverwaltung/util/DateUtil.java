package notizverwaltung.util;


import notizverwaltung.validators.ObjectValidator;

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
     * @param localDate soll zu einem Date-Objekt konvertiert werden
     * @author Michelle Blau
     * @return Date-Objekt
     */
    public static Date convertLocalDateInDate(LocalDate localDate){
        ObjectValidator.checkObObjectNullIst(localDate);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }


    /**
     * Konvertiert localDate-Objekt zu einem Date-Objekt
     *
     * @param date soll zu einem LocalDate-Objekt konvertiert werden
     * @author Michelle Blau
     * @return LocalDate-Objekt
     */
    public static LocalDate convertDateInLocalDate(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return localDate;
    }
}
