package seedu.address.model.person;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.expense.DescriptionContainsKeywordsPredicate;
import seedu.address.model.expense.Expense;

import java.util.List;
import java.util.function.Predicate;

public class PersonNameContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public PersonNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getPersonName().personName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((PersonNameContainsKeywordsPredicate) other).keywords)); // state check
    }

}