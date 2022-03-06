package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalExpenses.getTypicalExpenditureExpert;

import org.junit.jupiter.api.Test;

import seedu.address.model.*;

public class ClearCommandTest {

    @Test
    public void execute_emptyExpenditureExpert_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyExpenditureExpert_success() {
        Model model = new ModelManager(getTypicalExpenditureExpert(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalExpenditureExpert(), new UserPrefs());
        expectedModel.setExpenditureExpert(new ExpenditureExpert());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
