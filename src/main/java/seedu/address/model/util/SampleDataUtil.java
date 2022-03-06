package seedu.address.model.util;

import seedu.address.model.ExpenditureExpert;
import seedu.address.model.ReadOnlyExpenditureExpert;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.Amount;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Expense[] getSampleExpenses() {
        return new Expense[] {
            new Expense(new Description("All-star Baseball Shoes"), new ExpenseCategory("Apparels"), new Amount("89")),
            new Expense(new Description("Basketball"), new ExpenseCategory("Sports Equipment"), new Amount("25")),
            new Expense(new Description("Cake for Andrew's Birthday"), new ExpenseCategory("Gift"), new Amount("60")),
            new Expense(new Description("Driving Classes"), new ExpenseCategory("Miscellaneous"), new Amount("80")),
            new Expense(new Description("Ice cream"), new ExpenseCategory("Groceries"), new Amount("20")),
            new Expense(new Description("Ribbons for Crafting"), new ExpenseCategory("Miscellaneous"), new Amount("5"))
        };
    }

    public static ReadOnlyExpenditureExpert getSampleExpenditureExpert() {
        ExpenditureExpert sampleEe = new ExpenditureExpert();
        for (Expense sampleExpense : getSampleExpenses()) {
            sampleEe.addExpense(sampleExpense);
        }
        return sampleEe;
    }

}
