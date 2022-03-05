package seedu.address.testutil;

import seedu.address.logic.commands.EditCommand.EditExpenseDescriptor;
import seedu.address.model.expense.ExpenseCategory;

import seedu.address.model.expense.Expense;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.Amount;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditExpenseDescriptorBuilder {

    private EditExpenseDescriptor descriptor;

    public EditExpenseDescriptorBuilder() {
        descriptor = new EditExpenseDescriptor();
    }

    public EditExpenseDescriptorBuilder(EditExpenseDescriptor descriptor) {
        this.descriptor = new EditExpenseDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditExpenseDescriptorBuilder(Expense expense) {
        descriptor = new EditExpenseDescriptor();
        descriptor.setDescription(expense.getDescription());
        descriptor.setExpenseCategory(expense.getExpenseCategory());
        descriptor.setAmount(expense.getAmount());
    }

    /**
     * Sets the {@code Description} of the {@code EditExpenseDescriptor} that we are building.
     */
    public EditExpenseDescriptorBuilder withDescription(String description) {
        descriptor.setDescription(new Description(description));
        return this;
    }

    /**
     * Sets the {@code ExpenseCategory} of the {@code EditExpenseDescriptor} that we are building.
     */
    public EditExpenseDescriptorBuilder withExpenseCategory(String expenseCategory) {
        descriptor.setExpenseCategory(new ExpenseCategory(expenseCategory));
        return this;
    }

    /**
     * Sets the {@code Amount} of the {@code EditExpenseDescriptor} that we are building.
     */
    public EditExpenseDescriptorBuilder withAmount(String amount) {
        descriptor.setAmount(new Amount(amount));
        return this;
    }

    public EditExpenseDescriptor build() {
        return descriptor;
    }
}
