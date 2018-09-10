package notizverwaltung.i18n;

import java.util.ResourceBundle;
//TODO Kommentare
public class I18nComponentsUtil {

    private static final String MENU_FILE = "menu-file";
    private static final String MENU_NEW = "menu-new";
    private static final String MENU_EDIT = "menu-edit";
    private static final String MENU_OPTIONS = "menu-options";
    private static final String MENU_HELP = "menu-help";
    private static final String MENU_SEARCH = "menu-search";
    private static final String MENU_FILTER = "menu-filter";
    private static final String MENU_SORT = "menu-sort";

    private static final String STANDARD_NOTEPAD_NAME = "standard-notepad-name";


    private static ResourceBundle resourceBundle;

    static {
        resourceBundle = I18nUtil.getComponentsResourceBundle();
    }

    public static String getMenuFile() {
        return resourceBundle.getString(MENU_FILE);
    }

    public static String getMenuNew() {
        return resourceBundle.getString(MENU_NEW);
    }

    public static String getMenuEdit() {
        return resourceBundle.getString(MENU_EDIT);
    }

    public static String getMenuOptions() {
        return resourceBundle.getString(MENU_OPTIONS);
    }

    public static String getMenuHelp() {
        return resourceBundle.getString(MENU_HELP);
    }

    public static String getMenuSearch() {
        return resourceBundle.getString(MENU_SEARCH);
    }

    public static String getMenuFilter() {
        return resourceBundle.getString(MENU_FILTER);
    }

    public static String getMenuSort() {
        return resourceBundle.getString(MENU_SORT);
    }

    public static String getStandardNotepadName() {
        return resourceBundle.getString(STANDARD_NOTEPAD_NAME);
    }

}
