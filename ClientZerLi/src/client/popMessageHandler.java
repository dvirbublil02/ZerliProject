
package client;

import javafx.scene.control.Label;

public class popMessageHandler {
	static String message;
	static String title;
	
	
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		popMessageHandler.title = title;
	}
	public static String getMessage() {
		return message;
	}
	public static void setMessage(String message) {
		popMessageHandler.message = message;
	}
	
	public static void getLabelText(Label labelOfPopUp) {
		labelOfPopUp.setText(message);
	}
}

