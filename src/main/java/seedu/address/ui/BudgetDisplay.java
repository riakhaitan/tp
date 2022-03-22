package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import seedu.address.model.budget.Budget;

/**
 * A ui for the budget dashboard bar that is displayed at the header of the application.
 */
public class BudgetDisplay extends UiPart<Region> {

    private static final String FXML = "BudgetDisplay.fxml";
    private static final String MONTHLY_BUDGET = "Budget for this month is $";

    @FXML
    private TextArea budgetDisplay;

    public BudgetDisplay() {
        super(FXML);
    }

    /**
     * Initializes BudgetDisplay with a given String
     */
    public BudgetDisplay(String string) {
        super(FXML);
        budgetDisplay.setText(string);
    }

    /**
     * Reflects the budget set in the application, if it has been set
     */
    public void showMonthlyBudget(Budget budget) {
        if (budget != null) {
            String budgetString = budget.toString();
            requireNonNull(budgetString);
            budgetDisplay.setText(MONTHLY_BUDGET + budgetString);
        } else {
            budgetDisplay.setText("Budget for this month has not been set yet!");
        }
    }

}
