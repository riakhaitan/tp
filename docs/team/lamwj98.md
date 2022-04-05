git p---
layout: page
title: Andy's Project Portfolio Page

---

### Project: Expense Expert

Expense Expert is a desktop expense tracking application used for tracking one's personal expenses. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about ~10 kLoC.

Given below are my contributions to the project.

- **New Feature**:
- **Filtering expense(s) by date or month and/or category**:

  - What it does: Allows users to filter expense(s) based on date (can be specific date or by month), category, or a combination of both.
  - Justification: Users may want to know where they had spent money on specific date, specific month or even specific category.
  - Highlights: The issue faced with implementing this issue is that when using predicate for filtered list, only one predicate can be taken, however, with the option of allowing user to use 2 predicate, date/month and category, there is a need to filter by 2 predicate. A way to overcome this issue is to create a new predicate that combines both the date/month predicate and the category predicate, and pass the new predicate as a single predicate to filtered list.

- **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=lamwj98&breakdown=true)

- **Project management**: _(to be added soon)_

- **Enhancements to existing features**:

  - Change ExpenseDate class from keeping data as String to LocalDate (for future usage of dates for comparison)
  - Added unit test code for ExpenseDate and its relevant classes.

- **Documentation**:

  - User Guide:
    - Editing an expense
    - Deleting an expense
    - Filtering expense(s)
  - Developer Guide:
    - Use cases:
      - UC01 Add an expense
      - UC02 Delete an expense
      - UC03 Edit an expense
      - UC04 Find expense(s)
      - UC08 Filter expense(s)
    - User stories

- **Community**:
  - Refactor code base to fit project features.
  - Adapted unit testing and sample data to fit the project requirements.
  - PRs reviewed (with non-trivial review comments): #68, #69, #84

- **Tools**:

  - Integrated a third party library _(to be added soon)_
  - Integrated a new Github plugin _(to be added soon)_
