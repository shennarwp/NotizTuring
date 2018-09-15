package notizverwaltung.util;

import javafx.scene.control.Alert;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.validators.StringValidator;

/**
 * Stellt Warning- bzw. Errordialoge zur Verfügung
 *
 * @author Michelle Blau
 * @version 08.09.2018
 *
 */

public class FXUtil {


    /**
     * Zeigt einen Fehlerdialog an.
     * @param titel Der Titel des Dialogs. Der Name der Anwendung wird durch Doppelpunkt
     * getrennt vor dem Titel angezeigt.
     * @param header Die Überschrift, die über der Nachricht angezeigt wird.
     * @param message Die Nachricht, die in dem Dialog angezeigt wird.
     */
    public static void showErrorDialog(String titel, String header,
                                       String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titel);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Zeigt Warnung, falls die Anzahl an möglichen Kategorien/Notizen/Bearbeitungszuständen erreicht ist
     * @param titel Dialog-Titel
     * @param header Dialog-Überschrift
     */
    public static void showZuVieleElementeWarningDialog(String titel, String header){
        Alert dialog = new Alert(Alert.AlertType.WARNING);
        //TODO: i18n
        dialog.setTitle(titel);
        dialog.setHeaderText(header);
        dialog.showAndWait();
    }


    /**
     * Validiert die eingegebenen Daten.
     *
     * @return true wenn die Nutzer-Eingabe gueltig ist, sonst false.
     */
    public static boolean isInputValid(String errorMessage) {

        if (StringValidator.isStringLeerOderNull(errorMessage)) {
            return true;
        } else {
            showErrorDialog(I18nMessagesUtil.
                            getErrorUngueltigeFelderString(),
                    I18nMessagesUtil.getMessageKorrigiereUngueltigeFelderString(),
                    errorMessage);

            return false;
        }
    }

}
