package seedu.address.testutil;

import seedu.address.model.ExpenditureExpert;
import seedu.address.model.expense.Expense;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class ExpenditureExpertBuilder {

    private ExpenditureExpert expenditureExpert;

    public ExpenditureExpertBuilder() {
        expenditureExpert = new ExpenditureExpert();
    }

    public ExpenditureExpertBuilder(ExpenditureExpert expenditureExpert) {
        this.expenditureExpert = expenditureExpert;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public ExpenditureExpertBuilder withExpense(Expense expense) {
        expenditureExpert.addExpense(expense);
        return this;
    }

    public ExpenditureExpert build() {
        return expenditureExpert;
    }
}
