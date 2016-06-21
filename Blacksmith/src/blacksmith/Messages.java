package blacksmith;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Messages {
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("blacksmith.messages");

	private Messages() {
	}

	public static final String getString(String key) {
		try {
			return BUNDLE.getString(key);
		} catch (MissingResourceException ex) {
			return String.format("Key %1$ not found.", key);
		}
	}
}
