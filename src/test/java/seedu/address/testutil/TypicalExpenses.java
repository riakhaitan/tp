package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.ExpenditureExpert;
import seedu.address.model.expense.Expense;

import static seedu.address.logic.commands.CommandTestUtil.*;

/**
 * A utility class containing a list of {@code Expense} objects to be used in tests.
 */
public class TypicalExpenses {

    public static final Expense ANNUAL_NETFLIX_FEES = new ExpenseBuilder().withDescription("Annual Netflix Fees")
            .withExpenseCategory("Entertainment").withAmount("200").build();
    public static final Expense BASEBALL_LESSON_FEES = new ExpenseBuilder().withDescription("Baseball Lesson Fees")
            .withExpenseCategory("Entertainment").withAmount("100").build();
    public static final Expense CAR_WASH = new ExpenseBuilder().withDescription("Car Wash")
            .withExpenseCategory("Miscellaneous").withAmount("20").build();
    public static final Expense DENTAL = new ExpenseBuilder().withDescription("Dental")
            .withExpenseCategory("Medical").withAmount("200").build();
    public static final Expense ELECTRONIC_CAR_WASH = new ExpenseBuilder().withDescription("Electronic Car Wash")
            .withExpenseCategory("Miscellaneous").withAmount("50").build();
    public static final Expense FISHING_APPARATUS = new ExpenseBuilder().withDescription("Fishing Apparatus")
            .withExpenseCategory("Entertainment").withAmount("159.5").build();
    public static final Expense GROCERIES = new ExpenseBuilder().withDescription("Groceries")
            .withExpenseCategory("Groceries").withAmount("69.85").build();
    public static final Expense HOUSING_RENT = new ExpenseBuilder().withDescription("Housing Rent")
            .withExpenseCategory("Housing").withAmount("500").build();
    public static final Expense INTERNET_BILLS = new ExpenseBuilder().withDescription("Internet Bills")
            .withExpenseCategory("Bills").withAmount("69").build();

    public static final Expense ANNUAL_SPOTIFY = new ExpenseBuilder().withDescription(VALID_DESCRIPTION_ANNUAL_SPOTIFY)
            .withExpenseCategory(VALID_EXPENSE_CATEGORY_ENTERTAINMENT)
            .withAmount(VALID_AMOUNT_ANNUAL_SPOTIFY).build();
    public static final Expense BUILD_A_BEAR = new ExpenseBuilder().withDescription(VALID_DESCRIPTION_BUILD_A_BEAR)
            .withExpenseCategory(VALID_EXPENSE_CATEGORY_ENTERTAINMENT)
            .withAmount(VALID_AMOUNT_BUILD_A_BEAR).build();


    public static final String KEYWORD_MATCHING_RENT = "Rent"; // A keyword that matches Rent

    private TypicalExpenses() {} // prevents instantiation

    /**
     * Returns an {@code Expenditure Expert} with all the typical expenses.
     */
    public static ExpenditureExpert getTypicalExpenditureExpert() {
        ExpenditureExpert ee = new ExpenditureExpert();
        for (Expense expense : getTypicalExpenses()) {
            ee.addExpense(expense);
        }
        return ee;
    }

    public static List<Expense> getTypicalExpenses() {
        return new ArrayList<>(Arrays.asList(ANNUAL_NETFLIX_FEES, BASEBALL_LESSON_FEES, CAR_WASH, DENTAL,
                ELECTRONIC_CAR_WASH, FISHING_APPARATUS, GROCERIES));
    }
}
