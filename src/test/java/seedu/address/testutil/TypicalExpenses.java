package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.ExpenseExpert;
import seedu.address.model.expense.Expense;

import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_ANNUAL_SPOTIFY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_ANNUAL_SPOTIFY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_CATEGORY_ENTERTAINMENT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_DATE_ANNUAL_SPOTIFY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_DATE_BUILD_A_BEAR;

/**
 * A utility class containing a list of {@code Expense} objects to be used in tests.
 */
public class TypicalExpenses {

    public static final Expense ANNUAL_NETFLIX_FEES = new ExpenseBuilder().withDescription("Annual Netflix Fees")
            .withExpenseCategory("Entertainment").withAmount("200").withExpenseDate("2002-02-02").build();
    public static final Expense BASEBALL_LESSON_FEES = new ExpenseBuilder().withDescription("Baseball Lesson Fees")
            .withExpenseCategory("Entertainment").withAmount("100").withExpenseDate("2002-02-02").build();
    public static final Expense CAR_WASH = new ExpenseBuilder().withDescription("Car Wash")
            .withExpenseCategory("Miscellaneous").withAmount("20").withExpenseDate("2002-02-02").build();
    public static final Expense DENTAL = new ExpenseBuilder().withDescription("Dental")
            .withExpenseCategory("Medical").withAmount("200").withExpenseDate("2002-02-02").build();
    public static final Expense ELECTRICAL_APPLIANCES = new ExpenseBuilder().withDescription("Electrical Appliances")
            .withExpenseCategory("Miscellaneous").withAmount("50").withExpenseDate("2002-02-02").build();
    public static final Expense FISHING_APPARATUS = new ExpenseBuilder().withDescription("Fishing Apparatus")
            .withExpenseCategory("Entertainment").withAmount("159.5").withExpenseDate("2002-02-02").build();
    public static final Expense GROCERIES = new ExpenseBuilder().withDescription("Groceries")
            .withExpenseCategory("Groceries").withAmount("69.85").withExpenseDate("2002-02-02").build();
    public static final Expense HOUSING_RENT = new ExpenseBuilder().withDescription("Housing Rent")
            .withExpenseCategory("Housing").withAmount("500").withExpenseDate("2002-02-02").build();
    public static final Expense INTERNET_BILLS = new ExpenseBuilder().withDescription("Internet Bills")
            .withExpenseCategory("Bills").withAmount("69").withExpenseDate("2002-02-02").build();

    public static final Expense ANNUAL_SPOTIFY = new ExpenseBuilder().withDescription(VALID_DESCRIPTION_ANNUAL_SPOTIFY)
            .withExpenseCategory(VALID_EXPENSE_CATEGORY_ENTERTAINMENT)
            .withAmount(VALID_AMOUNT_ANNUAL_SPOTIFY).
            withExpenseDate(VALID_EXPENSE_DATE_ANNUAL_SPOTIFY).build();
    public static final Expense BUILD_A_BEAR = new ExpenseBuilder().withDescription(VALID_DESCRIPTION_BUILD_A_BEAR)
            .withExpenseCategory(VALID_EXPENSE_CATEGORY_ENTERTAINMENT)
            .withAmount(VALID_AMOUNT_BUILD_A_BEAR)
            .withExpenseDate(VALID_EXPENSE_DATE_BUILD_A_BEAR).build();


    public static final String KEYWORD_MATCHING_RENT = "Rent"; // A keyword that matches Rent

    private TypicalExpenses() {} // prevents instantiation

    /**
     * Returns an {@code Expense Expert} with all the typical expenses.
     */
    public static ExpenseExpert getTypicalExpenseExpert() {
        ExpenseExpert ee = new ExpenseExpert();
        for (Expense expense : getTypicalExpenses()) {
            ee.addExpense(expense);
        }
        return ee;
    }

    public static List<Expense> getTypicalExpenses() {
        return new ArrayList<>(Arrays.asList(ANNUAL_NETFLIX_FEES, BASEBALL_LESSON_FEES, CAR_WASH, DENTAL,
                ELECTRICAL_APPLIANCES, FISHING_APPARATUS, GROCERIES));
    }
}
