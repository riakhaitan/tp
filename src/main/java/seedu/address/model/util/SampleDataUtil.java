package seedu.address.model.util;

import seedu.address.model.ExpenseExpert;
import seedu.address.model.ReadOnlyExpenseExpert;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Date;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonAmount;
import seedu.address.model.person.PersonName;


/**
 * Contains utility methods for populating {@code ExpenseExpert} with sample data.
 */
public class SampleDataUtil {
    public static Expense[] getSampleExpenses() {
        return new Expense[] {
            new Expense(new Description("Lunch"),
                    new ExpenseCategory("General"), new Amount("89"), new Date("2002-02-02")),
            new Expense(new Description("Bought clothes"),
                    new ExpenseCategory("General"), new Amount("25"), new Date("2002-02-02")),
        };
    }

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new PersonName("Alex"), new PersonAmount("20"))};
    }

    public static ExpenseCategory[] getSampleCategories() {
        return new ExpenseCategory[] {
            new ExpenseCategory("General"),
        };
    }

    public static ReadOnlyExpenseExpert getSampleExpenseExpert() {
        ExpenseExpert sampleEe = new ExpenseExpert();
        for (ExpenseCategory sampleCategories : getSampleCategories()) {
            sampleEe.addExpenseCategory(sampleCategories);
        }

        for (Expense sampleExpense : getSampleExpenses()) {
            sampleEe.addExpense(sampleExpense);
        }
        for (Person samplePerson : getSamplePersons()) {
            sampleEe.addPerson(samplePerson);
        }
        return sampleEe;
    }
}
