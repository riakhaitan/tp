package seedu.address.model.expense;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class ExpenseDate {

    final static String DATE_FORMAT = "yyyy-MM-dd";

    public static final String VALIDATION_REGEX = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
    public static final String MESSAGE_CONSTRAINTS =
            "Date should be in a valid format " + DATE_FORMAT + ", and it should not be blank";

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public final LocalDate expenseDate;

    /**
     * Constructs a {@code ExpenseCategory}
     *
     * @param expenseDate to indicate the category of the expense.
     */
    public ExpenseDate(String expenseDate) {
        requireNonNull(expenseDate);
        checkArgument(isValidExpenseDate(expenseDate), MESSAGE_CONSTRAINTS);
        this.expenseDate = LocalDate.parse(expenseDate, dtf);
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidExpenseDate(String test) {
        boolean regexTest = test.matches(VALIDATION_REGEX);
        if (regexTest) {
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                df.setLenient(false);
                df.parse(test);
            } catch (ParseException e) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return expenseDate.format(dtf);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseDate // instanceof handles nulls
                && expenseDate.equals(((ExpenseDate) other).expenseDate)); // state check
    }

    @Override
    public int hashCode() {
        return expenseDate.hashCode();
    }
}
