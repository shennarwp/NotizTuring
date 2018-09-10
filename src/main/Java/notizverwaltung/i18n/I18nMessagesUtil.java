package notizverwaltung.i18n;

import java.util.ResourceBundle;
//TODO Kommentare

public abstract class I18nMessagesUtil {
	private static final String BUTTON_CANCEL = "button-cancel";
	private static final String ERROR_NOTIZNAME_UNGUELTIG = "message-error-empty-notename";
	private static final String ERROR_NOTIZBESCHREIBUNG_UNGUELTIG ="message-error-empty-notedescription";
	private static final String ERROR_NOTIZFAELLIGKEIT_UNGUELTIG ="message-error-empty-notedate";
	private static final String ERROR_KATEGORIENAME_UNGUELTIG = "message-error-empty-categoryname";
	private static final String ERROR_BESTEHENDE_KATEGORIE_UNGUELTIG = "message-error-existing-category-invalid";
	private static final String ERROR_BEARBEITUNGSZUSTANDNAME_UNGUELTIG = "message-error-empty-statename";
	private static final String ERROR_BESTEHENDER_BEARBEITUNGSZUSTAND_UNGUELTIG = "message-error-existing-state-invalid";
	private static final String ERROR_UNGUELTIGE_FELDER ="error-invalid-fields";
	private static final String ERROR_KORRIGIERE_UNGUELTIGE_FELDER ="message-correct-invalid-fields";


	private static ResourceBundle resourceBundle;

	static {
		resourceBundle = I18nUtil.getMessagesResourceBundle();
	}

	public static String getButtonCancelString() {
		return resourceBundle.getString(BUTTON_CANCEL);

	}

	public static String getErrorNotiznameUngueltig() {
		return resourceBundle.getString(ERROR_NOTIZNAME_UNGUELTIG);
	}

	public static String getErrorNotizbeschreibungUngueltig() {
		return resourceBundle.getString(ERROR_NOTIZBESCHREIBUNG_UNGUELTIG);
	}


	public static String getErrorUngueltigeFelderString() {
		return resourceBundle.getString(ERROR_UNGUELTIGE_FELDER);
	}

	public static String getMessageKorrigiereUngueltigeFelderString() {
		return resourceBundle.getString(ERROR_KORRIGIERE_UNGUELTIGE_FELDER);
	}

    public static String getErrorNotizFaelligkeitUngueltig() {
		return resourceBundle.getString(ERROR_NOTIZFAELLIGKEIT_UNGUELTIG);
    }

    public static String getErrorKategorienameUngueltig() {
		return resourceBundle.getString(ERROR_KATEGORIENAME_UNGUELTIG);
    }

	public static String getErrorBearbeitungszustandnameUngueltig() {
		return resourceBundle.getString(ERROR_BEARBEITUNGSZUSTANDNAME_UNGUELTIG);
	}

    public static String getErrorBestehendeKategorieUngueltig() {
		return resourceBundle.getString(ERROR_BESTEHENDE_KATEGORIE_UNGUELTIG);
    }

	public static String getErrorBestehenderBearbeitungszustandUngueltig() {
		return resourceBundle.getString(ERROR_BESTEHENDER_BEARBEITUNGSZUSTAND_UNGUELTIG);
	}
}
