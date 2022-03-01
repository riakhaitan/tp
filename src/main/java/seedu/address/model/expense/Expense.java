package seedu.address.model.expense;

public class Expense {
    private final Description description;
    private final Category category;
    private final Amount amount;

    public Expense(Description description, Category category, Amount amount) {
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

    public Description getDescription() {
        return description;
    }

    public Category getCategory() {
        return this.category;
    }

    public Amount getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDescription())
                .append("; Category: ")
                .append(getCategory())
                .append("; Amount: ")
                .append(getAmount())

        return builder.toString();
    }

}
