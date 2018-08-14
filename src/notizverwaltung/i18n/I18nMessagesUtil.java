package notizverwaltung.i18n;

import java.util.ResourceBundle;

public abstract class I18nMessagesUtil {
	private static final String BUTTON_CANCEL = "button-cancel";
	private static final String BUTTON_CLOSE = "button-close";
	private static final String BUTTON_DELETE_ARTICLE = "button-delete-article";
	private static final String BUTTON_NEW_ARTICLE = "button-new-article";
	private static final String BUTTON_SAVE = "button-save";
	private static final String BUTTON_UPDATE_ARTICLE = "button-update-article";
	private static final String COLUMN_ARTICLE_NR = "column-article-nr";
	private static final String COLUMN_ARTICLE_NAME = "column-article-name";
	private static final String COLUMN_PRICE = "column-price";
	private static final String FRAME_NEW_ARTICLE = "frame-new-article";
	private static final String LABEL_ARTICLE_ADMINISTRATION = "label-article-administration";
	private static final String LABEL_ARTICLE_NAME = "label-article-name";
	private static final String LABEL_ARTICLE_ID = "label-article-id";
	private static final String LABEL_PRICE = "label-price";
	private static final String MESSAGE_CHOOSE_ARTICLE = "message-choose-article";
	private static final String MESSAGE_PLEASE_CHOOSE_ARTICLE = "message-please-choose-article";
	
	private static ResourceBundle resourceBundle;
	
	static {
		resourceBundle = I18nUtil.getMessagesResourceBundle();
	}

	public static String getButtonCancelString() {
		return resourceBundle.getString(BUTTON_CANCEL);
	}
	
	public static String getButtonCloseString() {
		return resourceBundle.getString(BUTTON_CLOSE);
	}
	
	public static String getButtonDeleteArticleString() {
		return resourceBundle.getString(BUTTON_DELETE_ARTICLE);
	}
	
	public static String getButtonNewArticleString() {
		return resourceBundle.getString(BUTTON_NEW_ARTICLE);
	}
	
	public static String getButtonSaveString() {
		return resourceBundle.getString(BUTTON_SAVE);
	}
	
	public static String getButtonUpdateArticleString() {
		return resourceBundle.getString(BUTTON_UPDATE_ARTICLE);
	}
	
	public static String getColumnArticleNrString() {
		return resourceBundle.getString(COLUMN_ARTICLE_NR);
	}
	
	public static String getColumnArticleNameString() {
		return resourceBundle.getString(COLUMN_ARTICLE_NAME);
	}
	
	public static String getColumnPriceString() {
		return resourceBundle.getString(COLUMN_PRICE);
	}
	
	public static String getFrameNewArticleString() {
		return resourceBundle.getString(FRAME_NEW_ARTICLE);
	}
	
	public static String getLabelArticleAdministrationString() {
		return resourceBundle.getString(LABEL_ARTICLE_ADMINISTRATION);
	}
	
	public static String getLabelArticleIdString() {
		return resourceBundle.getString(LABEL_ARTICLE_ID);
	}
	
	public static String getLabelArticleNameString() {
		return resourceBundle.getString(LABEL_ARTICLE_NAME);
	}
	
	public static String getLabelPriceString() {
		return resourceBundle.getString(LABEL_PRICE);
	}
	
	public static String getMessagePleaseChooseArticleString() {
		return resourceBundle.getString(MESSAGE_PLEASE_CHOOSE_ARTICLE);
	}
	
	public static String getMessageChooseArticleString() {
		return resourceBundle.getString(MESSAGE_CHOOSE_ARTICLE);
	}
}
