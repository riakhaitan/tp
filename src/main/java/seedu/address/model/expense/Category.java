package seedu.address.model.expense;

import seedu.address.model.person.Name;

public class Category {
    public final String category;

    public Category(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.category.equals(((Category)other).category));
    }

    @Override
    public String toString() {
        return this.category;
    }
}
