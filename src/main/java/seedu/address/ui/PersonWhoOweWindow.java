package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.model.expense.Expense;
import seedu.address.model.person.Person;

import java.util.logging.Logger;

public class PersonWhoOweWindow extends UiPart<Stage>{
    public static final String USERGUIDE_URL =
            "https://ay2122s2-cs2103t-w09-3.github.io/tp/";
    public static final String HELP_MESSAGE = "Refer to the user guide: " + USERGUIDE_URL;

    private static final Logger logger = LogsCenter.getLogger(PersonWhoOweWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    //public final Person person;

    @javafx.fxml.FXML
    private Button copyButton;
    @FXML
    private HBox cardPane;
    @FXML
    private Label personName;
    @FXML
    private Label id;
    @FXML
    private Label personAmount;
    @FXML
    private Label amount;
    @FXML
    private Label helpMessage;



//    public PersonWhoOweWindow(Person person, int displayedIndex) {
//        super(FXML);
//        this.person = person;
//        id.setText(displayedIndex + ". ");
//        personName.setText(person.getPersonName().personName);
//        personAmount.setText(person.getPersonAmount().personAmount);
//
//    }

    /**
     * Creates a new HelpWindow.
     */
    public PersonWhoOweWindow() {
        this(new Stage());
    }

    public PersonWhoOweWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HelpCommand.helpCommandString());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
