package seedu.address.model.person.exceptions;

/**
 * Signals that the operation will result in duplicate Expense (Expense are considered duplicates if they have the same
 * description).
 */
public class DuplicateExpenseException extends RuntimeException {
    public DuplicateExpenseException() {
        super("Operation would result in duplicate expense");
    }
}
