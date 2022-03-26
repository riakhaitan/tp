package seedu.address.logic.parser;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.PersonOwesCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.ExpenseDate;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonAmount;
import seedu.address.model.person.PersonName;

import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPENSE_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPENSE_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERSON_NAME;

public class PersonOwesCommandParser implements Parser<PersonOwesCommand> {

    public PersonOwesCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_PERSON_NAME, PREFIX_AMOUNT);

        if (!arePrefixesPresent(argMultimap, PREFIX_PERSON_NAME, PREFIX_AMOUNT)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, PersonOwesCommand.MESSAGE_USAGE));
        }

        PersonName personName = ParserUtil.parsePersonName(argMultimap.getValue(PREFIX_PERSON_NAME).get());
        PersonAmount personAmount = ParserUtil.parsePersonAmount(argMultimap.getValue(PREFIX_AMOUNT).get());


        Person person = new Person(personName, personAmount);

        return new PersonOwesCommand(person);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}

