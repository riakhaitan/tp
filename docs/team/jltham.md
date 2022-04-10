---
layout: page
title: Jin Lin's Project Portfolio Page
---

### Project: Expense Expert

Expense Expert is a desktop expense trackign application used for tracking one's personal expenses. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about ~10 kLoC.

Given below are my contributions to the project.

- **New Feature**: Adding and displaying a budget set for the current month ([#69](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/69), [#84](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/84))

  - What it does:
    - Allows users a monthly budget that will be saved locally to be loaded. upon relaunch
    - Allows users to view the budget set for the month.
  - Justification:
    - Users may want to set a budget for themselves and be constantly reminded of their budget so they do not overspend.
  - Highlights:
    - This feature was initially tricky to implement as, unlike the Expense model, the Budget model was not easily adaptable from AB3. It requires thorough and tedious understanding of the code to be able to implement a new Budget model that can be accurately displayed, stored and handled in Expense Expert.

- **New Feature**: Preventing any commands to be executed before budget is set. ([#154](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/154))

  - What it does:
    - Allows users to use Expense Expert only after they have set a budget.
  - Justification:
    - This feature follows the logical presumption that users only can spend money after they have money to be spent. Consequently, users will only be able to add and manage expenses after they set their budget.
  - Highlights:
    - This feature was a result of PE-D and meaningful in a sense that it is a product of a balance between what we have to offer and what our potential users want from us.

- **New Feature**: Allowing users to access navigate through the history of commands ([#118](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/118))

  - What it does:
    - Allows users to navigate through the history of commands through up and down arrow keys on their keyboard.
  - Justification:
    - Users may want to execute a similar command as what they have just did, and with this feature, they can do it with just the up arrow key and no need to type the entire command out again.

- **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=jltham&breakdown=true)

- **Enhancements to existing features**:

  - Generalised the ExpenseDate class to Date class to be used as a general Date attribute for both Expense and Budget. ([#91](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/91))
  - Refactored Amount class for it to be used for both Expense model and Budget model. ([#91](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/91). [#110](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/110), [#142](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/142))
    - Storage of Amount changed from String to Double.
    - String representative of Amount changed to be specific to 2 decimal places.
  - Enhanced the User Interface to be more user-friendly on conventional computer screens. ([#109](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/109))
    - Changed the layout of the application to be landscape instead of portrait.
    - Resized the application so that it will not be too big for users with small screens.
    - Replaced the application icon to be more fitting of Expense Expert.

- **Documentation**:

  - User Guide: ([#20](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/20), [#142](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/142))
    - Refactored User Guide from AB3 to fit Expense Expert.
    - Included a Table of Contents with hyperlinks.
    - Corrected careless mistakes in:
      - Editing an expense
      - Filtering an expense
      - Finding an expense
      - Setting a monthly budget
      - Listing all expense categories
      - Adding a person who owes you money
      - Removing a person who has paid the owed money
      - Clearing the program data
      - Command Summary
  - Developer Guide:
    - _(to be added soon)_

- **Community**:

  - PRs reviewed (with non-trivial review comments): ([#53](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/53), [#70](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/70), [#153](https://github.com/AY2122S2-CS2103T-W09-3/tp/pull/153))
  - Reported a total of 11 bugs and suggestions for other teams ([here](https://github.com/jltham/ped/issues))
