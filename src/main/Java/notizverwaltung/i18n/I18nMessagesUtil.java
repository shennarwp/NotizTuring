package notizverwaltung.i18n;

import java.util.ResourceBundle;

public abstract class I18nMessagesUtil {
	private static final String BUTTON_CANCEL = "button-cancel";
	private static final String ERROR_NOTIZNAME_UNGUELTIG = "message-error-empty-notename";
	private static final String ERROR_NOTIZBESCHREIBUNG_UNGUELTIG ="message-error-empty-notedescription";
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
}
