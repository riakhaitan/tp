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
            new Expense(new Description("Allstar Baseball Shoes"),
                    new ExpenseCategory("Apparels"), new Amount("89"), new Date("2002-02-02")),
            new Expense(new Description("Basketball"),
                    new ExpenseCategory("Sports Equipment"), new Amount("25"), new Date("2002-02-02")),
            new Expense(new Description("Cake for Andrew Birthday"),
                    new ExpenseCategory("Gift"), new Amount("60"), new Date("2002-02-02")),
            new Expense(new Description("Driving Classes"), new
                    ExpenseCategory("Miscellaneous"), new Amount("80"), new Date("2002-02-02")),
            new Expense(new Description("Ice cream"), new
                    ExpenseCategory("Groceries"), new Amount("20"), new Date("2002-02-02")),
            new Expense(new Description("Ribbons for Crafting"), new
                    ExpenseCategory("Miscellaneous"), new Amount("5"), new Date("2002-02-02"))
        };
    }

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new PersonName("Alex"), new PersonAmount("20")),
            new Person(new PersonName("Bob"), new PersonAmount("100"))};
    }

    public static ExpenseCategory[] getSampleCategories() {
        return new ExpenseCategory[] {
            new ExpenseCategory("Apparels"), new ExpenseCategory("Gift"),
            new ExpenseCategory("Miscellaneous"), new ExpenseCategory("Groceries")
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
