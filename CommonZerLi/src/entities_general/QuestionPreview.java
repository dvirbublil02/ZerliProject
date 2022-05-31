package entities_general;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * Class Description: this class represented the preview question this object
 * will display on the screen
 * 
 * @author Mor Ben Haim
 *
 */
public class QuestionPreview extends Question {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboBox<Integer> anwerRate;
	private ObservableList<Integer> rate;

	public QuestionPreview( String topic, int questionNumber,String question) {
		super( topic,questionNumber, question);
		anwerRate = new ComboBox<>();
		rate = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		anwerRate.setItems(rate);

	}

	public ComboBox<Integer> getAnwerRate() {
		return anwerRate;
	}

	public void setAnwerRate(ComboBox<Integer> anwerRate) {
		this.anwerRate = anwerRate;
	}

	public ObservableList<Integer> getRate() {
		return rate;
	}

	public void setRate(ObservableList<Integer> rate) {
		this.rate = rate;
	}

}
