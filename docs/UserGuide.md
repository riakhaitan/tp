---
layout: page
title: User Guide
---

Expense Expert is a **desktop app for keeping track of your expenses, and managing your budget, optimized for use via a Command Line Interface** (CLI) enhanced with a light-weight Graphical User Interface (GUI). If you can type fast, Expense Expert can get your expense management done faster than traditional GUI apps.

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Quick start](#quick-start)
- [Breakdown of the UI](#breakdown-of-the-ui)
- [Features](#features)
- [Commands](#commands)
  - [Viewing help : `help`](#viewing-help--help)
  - [Adding an expense : `add`](#adding-an-expense--add)
  - [Deleting an expense : `delete`](#deleting-an-expense--delete)
  - [Editing an expense : `edit`](#editing-an-expense--edit)
  - [Listing all expenses : `list`](#listing-all-expenses--list)
  - [Filtering expense(s): `filter`](#filtering-expenses-filter)
  - [Finding expense(s): `find`](#finding-expenses-find)
  - [Setting a monthly Budget: `budget`](#setting-a-monthly-budget-budget)
  - [Adding an Expense Category: `addCat`](#adding-an-expense-category-addcat)
  - [Listing all Expense Categories: `listCat`](#listing-all-expense-categories-listcat)
  - [Adding a person who owes you money: `person`](#adding-a-person-who-owes-you-money-person)
  - [Removing a person who has paid the owed money: `paid`](#removing-a-person-who-has-paid-the-owed-money-paid)
  - [Updating the amount a person owes you: `update`](#updating-the-amount-a-person-owes-you-update)
  - [Clearing the program data : `clear`](#clearing-the-program-data--clear)
  - [Exiting the program : `exit`](#exiting-the-program--exit)
- [Storage](#storage)
  - [Saving the data](#saving-the-data)
  - [Editing the data file](#editing-the-data-file)
- [FAQ](#faq)
- [Command summary](#command-summary)

---

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `expenseexpert.jar` from [here](https://github.com/AY2122S2-CS2103T-W09-3/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your Expense Expert.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. 
5. The data is just for demonstration purposes. When you launch ExpenseExpert for the first time, it is not preloaded with any data.<br>
   ![Ui](images/Ui.png)

6. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   - **`list`** : Lists all the expenses you have recorded.

   - **`add`** `d/Lunch at VivoCity a/12.95 c/Food t/2022-03-12` : Adds a new expense of a/12.95 for Lunch at Vivocity to your list of expenses

   - **`delete`** `3` : Deletes the 3rd expense shown in the current list.

   - **`exit`** : Exits the app for you.

7. Refer to the [Features](#features) below for details of each command.

---

## Breakdown of the UI

![Ui](images/Ui_Breakdown.png)

1. **Menu Bar** : Facilitate quick access to the help window. Quiting of the application can also be done through the file drop-down option.
2. **Command Box**: Allows the user to input commands.
3. **Budget Display Box**: Displays the remaining budget.
4. **Result Box**: Displays the results of the command that the user parsed.
5. **Expense List**: List of expenses (can be all the expenses or filtered list if command had been passed).
6. **Person List**: List of people who owe the user the said sum of money.

---

## Features

<div markdown="block" class="alert alert-info">

**information_source: Notes about the command format:**<br>

- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `d/DESCRIPTION`, `DESCRIPTION` is a parameter which can be used as `d/Dinner at ECP`.

- Items in square brackets are optional.<br>
  e.g `d/DESCRIPTION [c/CATEGORY]` can be used as `d/Dinner at ECP c/Food` or as `d/Dinner at ECP`.

- Items in brackets means at least one of the components must be present. <br>
- e.g. `(ft/DATE) (c/CATEGORY)` can be used as `ft/2022-03`, `ft/2022-03 c/Transport` or `c/Transport`.

- Parameters can be in any order.<br>
  e.g. if the command specifies `d/DESCRIPTION a/AMOUNT`, `a/AMOUNT d/DESCRIPTION` is also acceptable.

- If a parameter is expected only once in the command but is instead specified multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `a/12.99 a/13.50`, only `a/13.50` will be taken.

- Extraneous parameters for commands that do not take in parameters (such as `help`, `list` and `exit`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

## Commands
### Viewing help : `help`

Shows a help window explaining how to use each command, with an added link to the user guide. 
It can also show the usage of a particular command.

![Help](images/Help_Ui.png)

Format: `help [COMMAND_NAME]`

### Adding an expense : `add`

Adds an expense to the list. Description and expense category provided must be in alphanumerical format, amount can only be positive number up to 2 decimal places
and expense date must be in yyyy-MM-dd format. Description must be unique and different from all other expenses in Expense Expert. Expense category must be from a list of user-defined categories. If Expense category is undefined, it will default to the `General` Expense Category.

Format: `add d/DESCRIPTION a/AMOUNT [c/EXPENSE_CATEGORY] t/EXPENSE_DATE`

**Examples:**

- `add d/Dinner at Astons a/35 c/Food t/2022-03-22`
- `add d/Groceries t/2022-03-23 a/50`

_This is the result of executing the command(s) above:_

![Add](images/AddCommandExample2.png)

![Add](images/AddCommandExample1.png)

### Deleting an expense : `delete`

Deletes the expense specified by the index from the list. Run `list` before executing the command to identify the index of the expense.

Format: `delete INDEX`

Examples:

- `delete 1`

_This is the result of executing the command(s) above:_

![Delete](images/DeleteCommandExample.png)

### Editing an expense : `edit`

Edits an existing expense in the list. You need to specify the index of the expense from the list and only the syntax of the fields you want to change together
with the value you want to change to. You can specify one or more fields. Run `list` before executing the command to identify the index of the expense.

Format: `edit INDEX (d/DESCRIPTION) (a/AMOUNT) (c/EXPENSE_CATEGORY) (t/EXPENSE_DATE)`

Examples:

- `edit 1 a/40`
- `edit 2 d/Groceries from Fairprice a/80`

_This is the result of executing the command(s) above:_

![Edit](images/EditCommandExample.png)

### Listing all expenses : `list`

Shows a list of all expenses recorded in Expense Expert.

Format: `list`

_This is the result of executing the command(s) above:_

![List](images/ListCommandExample.png)

### Filtering expense(s): `filter`

Filters the expenses with the date or category provided. At least one of the fields in brackets need to be present.
Date format must be provided in yyyy-MM-dd format or in yyyy-MM format. If date provided is in yyyy-MM format,
the displayed will include all the results of that month.

Format: `filter (ft/DATE) (c/CATEGORY)`

Examples:

- `filter ft/2022-03-12`
- `filter ft/2022-03`
- `filter c/Transport`
- `filter ft/2022-03 c/Transport`

The expense list before executing the `filter` command looked as follows:
![Filter](images/Sample_Data_For_Filter.png)

_Result of executing`filter ft/2022-03` is shown below:_

![Filter](images/FilterCommandExample.png)

**Disclaimer** : result may vary depending upon the existing data in ExpenseExpert.

### Finding expense(s): `find`

Finds expense(s) with the stated keyword(s) in descriptors. If more than one keyword is provided, returns list of expenses with expense description that matches any of the keywords provided.

Format: `find KEYWORD [MORE_KEYWORDS]`

Examples:

- `find Cafe`
- `find Cafe Grab`

The expense list before executing the `find` command looked as follows:
![Filter](images/Sample_Data_For_Find.png)


_Result of executing `find Cafe` is shown below:_

![Find](images/FindCommandExample.png)

**Disclaimer** : result may vary depending upon the existing data in ExpenseExpert.

### Setting a monthly Budget: `budget`

Sets a budget for the month.

_The `add`, `delete` and `edit` command affect the monthly budget to reflect the user's remaining budget.
However, due to an incomplete implementation of the budget, transaction for every month are reflected in the current month's budget.
This is going to be rectified in the future iterations._

Format: `budget a/AMOUNT`

Examples:

- `budget a/500`

_This is the result of executing the command(s) above:_

![Budget](images/BudgetCommandExample.png)

### Adding an Expense Category: `addCat`

Adds a user-defined expense category which can be used to categorise expenses.

Format: `addCat c/EXPENSE_CATEGORY`

Examples:

- `addCat c/transport`

_This is the result of executing the command(s) above:_

![AddCategory](images/AddCategoryCommandExample.png)

### Listing all Expense Categories: `listCat`

Shows a list of all expense categories recorded in Expense Expert.

Format: `listCat`

_This is the result of executing the command(s) above:_

![ListCategory](images/ListCategoryCommandExample.png)

---

**The Following three commands facilitate the feature of managing the list of persons who owe you money.**

_This sections of commands does not make a difference to the budget set by the user, since the budget is only
meant to keep track of the expenses, and the amount of money lent out does not have any role to play in it._

### Adding a person who owes you money: `person`

Adds a person with the name who owes you the specific amount.

Format: `person n/PERSON_NAME a/PERSON_AMOUNT`

Examples:

- `person n/Alex a/100`

_This is the result of executing the command(s) above:_

![Person](images/PersonCommandExample.png)

### Removing a person who has paid the owed money: `paid`

Removes a person at the index who has paid all the money they have owed.

Format: `paid INDEX`

Examples:

- `paid 1`

_This is the result of executing the command(s) above:_

![Paid](images/PaidCommandExample.png)

### Updating the amount a person owes you: `update`

Updates the amount owed by a person at the index in the list to the amount parsed.

Format: `update INDEX a/AMOUNT`

Examples:

- `update 4 a/1000`

_This is the result of executing the command(s) above:_

![Update](images/UpdateCommandExample.png)

---

### Clearing the program data : `clear`

Deletes all data from Expense Expert.

Format: `clear`

_This is the result of executing the command(s) above:_

![Clear](images/ClearCommandExample.png)

### Exiting the program : `exit`

Exits the program.

Format: `exit`

## Storage
### Saving the data

Expense Expert data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

Expense Expert data are saved as a JSON file `[JAR file location]/data/expenseexpert.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, Expense Expert will discard all data and start with an empty data file at the next run.
</div>

---

## FAQ

**Q**: How can I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Expense Expert home folder.

**Q**: Can I archive the data files?
**A**: At the moment, the application doesn't support archiving. It will be available in v2.0.

---

## Command summary

| Action                                        | Format, Examples                                                                                                                          |
|-----------------------------------------------| ----------------------------------------------------------------------------------------------------------------------------------------- |
| **Getting help**                              | `help`                                                                                                                                    |
| **Adding an expense**                         | `add d/DESCRIPTION a/AMOUNT [c/EXPENSE_CATEGORY] t/EXPENSE_DATE ` <br> Example: `add d/Lunch at VivoCity a/12.95 c/Food t/2022-03-20`     |
| **Deleting an expense**                       | `delete INDEX`<br> Example: `delete 3`                                                                                                    |
| **Editing an expense**                        | `edit INDEX (d/DESCRIPTION) (a/AMOUNT) (c/EXPENSE_CATEGORY) (t/EXPENSE_DATE)`<br> Example: `edit 2 d/Lunch at Harbourfront Centre a/6.50` |
| **Listing all expenses**                      | `list`                                                                                                                                    |
| **Filtering expense(s)**                      | `filter (ft/FILTER_DATE) (c/CATEGORY)` <br> Example: `filter ft/2022-03 c/Transport`                                                      |
| **Finding expense(s)**                        | `find KEYWORD [MORE_KEYWORDS]` <br> Example: `find Cafe Grab Basketball`                                                                  |
| **Setting a monthly budget**                  | `budget a/AMOUNT` <br> Example: `budget a/1000`                                                                                           |
| **Adding an expense category**                | `addCat c/EXPENSE_CATEGORY` <br> Example: `addCat c/transport`                                                                            |
| **Listing all expense category**              | `listCat`                                                                                                                                 |
| **Adding a person who owes you money**        | `person n/PERSON_NAME a/PERSON_AMOUNT` <br> Example: `person n/Alex a/50`                                                                 |
| **Removing a person who paid the owed money** | `paid INDEX` <br> Example: `paid 1`<br/>                                                                                                  |
| **Updating the amount a person owes you**     | `update INDEX a/AMOUNT`<br/> Example: `update 4 a/200`                                                                                    |
| **Clearing the program data**                 | `clear`<br/>                                                                                                                              |
| **Exiting the program**                       | `exit`                                                                                                                                    |
