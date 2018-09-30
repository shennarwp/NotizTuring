package notizverwaltung.util;


import notizverwaltung.validators.ObjectValidator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static notizverwaltung.validators.ObjectValidator.checkObObjectNullIst;

/**
 * Stellt statische Methoden zum Konvertieren von "Date"-Objekten bzw. "LocalDate"-Objekten zur Verfuegung
 *
 * @author Michelle Blau
 * @version 30.09.2018
 */
public class DateUtil {

    /**
     * Konvertiert localDate-Objekt zu einem Date-Objekt
     *
     * @param localDate wird umkonvertiert
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
     * @param date wird umkonvertiert
     * @return LocalDate-Objekt
     */
    public static LocalDate convertDateInLocalDate(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return localDate;
    }
}
