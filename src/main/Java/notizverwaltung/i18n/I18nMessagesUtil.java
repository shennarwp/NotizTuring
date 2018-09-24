package notizverwaltung.i18n;

import java.util.ResourceBundle;
//TODO Kommentare

public abstract class I18nMessagesUtil {
	private static final String BUTTON_CANCEL = "button-cancel";
	private static final String ERROR_NOTIZNAME_UNGUELTIG = "message-error-empty-notename";
	private static final String ERROR_NOTIZBESCHREIBUNG_UNGUELTIG ="message-error-empty-notedescription";
	private static final String ERROR_NOTIZFAELLIGKEIT_UNGUELTIG ="message-error-empty-notedate";

	private static final String ERROR_KATEGORIENAME_UNGUELTIG = "message-error-empty-categoryname";
	private static final String ERROR_BEARBEITUNGSZUSTANDNAME_UNGUELTIG = "message-error-empty-statename";

	private static final String ERROR_BESTEHENDE_NOTIZ_UNGUELTIG = "message-error-existing-note-invalid";
	private static final String ERROR_BESTEHENDE_KATEGORIE_UNGUELTIG = "message-error-existing-category-invalid";
	private static final String ERROR_BESTEHENDER_BEARBEITUNGSZUSTAND_UNGUELTIG = "message-error-existing-state-invalid";

	private static final String ERROR_KATEGORIE_WIRD_NOCH_VERWENDET = "message-error-category-still-used";
	private static final String ERROR_BEARBEITUNGSZUSTAND_WIRD_NOCH_VERWENDET = "message-error-state-still-used";

	private static final String ERROR_BEARBEITUNGSZUSTAND_EXISTIERT_BEREITS = "message-error-state-already-exists";
	private static final String ERROR_KATEGORIE_EXISTIERT_BEREITS = "message-error-category-already-exists";

	private static final String ERROR_UNGUELTIGE_FELDER ="error-invalid-fields";
	private static final String ERROR_KORRIGIERE_UNGUELTIGE_FELDER ="message-correct-invalid-fields";
	private static final String ERROR_SONDERZEICHEN_VORHANDEN="message-error-special-characters";

	private static final String WARNING ="message-warning";
	private static final String WARNING_ZU_VIELE_KATEGORIEN ="message-warning-too-many-categories";
	private static final String WARNING_ZU_VIELE_ZUSTAENDE ="message-warning-too-many-states";
	private static final String WARNING_ZU_VIELE_NOTIZEN ="message-warning-too-many-notes";


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

    public static String getErrorBestehendeNotizUngueltig() {
		return resourceBundle.getString(ERROR_BESTEHENDE_NOTIZ_UNGUELTIG);
    }

    public static String getErrorEsGibtNochNotizenMitDieserKategorie() {
		return resourceBundle.getString(ERROR_KATEGORIE_WIRD_NOCH_VERWENDET);
    }

	public static String getErrorEsGibtNochNotizenMitDiesemBearbeitungszustand() {
		return resourceBundle.getString(ERROR_BEARBEITUNGSZUSTAND_WIRD_NOCH_VERWENDET);
	}

	public static String getWarningTitel(){
		return resourceBundle.getString(WARNING);
	}

	public static String getWarningZuVieleKategorien(){
		return resourceBundle.getString(WARNING_ZU_VIELE_KATEGORIEN);
	}

	public static String getWarningZuVieleZustaende(){
		return resourceBundle.getString(WARNING_ZU_VIELE_ZUSTAENDE);
	}

	public static String getWarningZuVieleNotizen(){
		return resourceBundle.getString(WARNING_ZU_VIELE_NOTIZEN);
	}

	public static String getErrorBearbeitungszustandnameVorhanden() {
		return resourceBundle.getString(ERROR_BEARBEITUNGSZUSTAND_EXISTIERT_BEREITS);
	}

	public static String getErrorKategorienameVorhanden(){
		return resourceBundle.getString(ERROR_KATEGORIE_EXISTIERT_BEREITS);
	}

	public static String getErrorSonderzeichenVorhanden() {
		return resourceBundle.getString(ERROR_SONDERZEICHEN_VORHANDEN);
	}
}
