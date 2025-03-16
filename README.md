# What Should Be Done

## 1. WebDriver + Java + TestNG

- Select a system under test (preferably a web application being tested during your project activities).
- Agree with your mentor and document 3 scenarios to automate. The scenarios should be linear (no need to implement complex logic for now) and contain 8-10 simple steps.
- Use WebDriver API as much as possible (browser navigation, clicks, switchTo, etc.).
- Use several locator strategies, i.e., different types of locators (and select the most suitable in your case).
- Experiment with waits (implicit and explicit).
- Extend your scenario with the usage of Page Object / Page Factory patterns.

## 2. Alternative Option #1

If option #1 can't be implemented due to any technical/project security reasons (project NDA), use tasks from the eLearning module assigned to the learning path.

## 3. Alternative Option #2

If option #1 and option #2 can't be implemented due to any technical/project security reasons (project NDA), use a public mail service (Mail.ru, Yandex.ru, Gmail.com, etc.) according to the test flow below:

### Precondition

Create an account for any mail services mentioned above.

### Test Scenario/Flow

1. Login to the mailbox.
2. Assert that the login is successful.
3. Create a new mail (fill in addressee, subject, and body fields).
4. Save the mail as a draft.
5. Verify that the mail is present in the 'Drafts' folder.
6. Verify the draft content (addressee, subject, and body should be the same as in step 3).
7. Send the mail.
8. Verify that the mail disappeared from the 'Drafts' folder.
9. Verify that the mail is in the 'Sent' folder.
10. Log off.

Another option is to use any EPAM service (Heroes, Grow, Time, etc.). In this case, make an agreement about the scenario with your mentor.

## Acceptance Criteria

1. The scenarios are linear (no need to implement complex logic for now). 3 scenarios in total.
2. Different locator strategies are used for a task.
3. Usage of auto-generated locators is avoided.
4. WebDriver API is widely used.
5. Different methods of waits are used.
6. Test scenarios are clear, stable, and well-structured.
7. Each method in the test scenario has assertions.
8. Page Objects have a consistent structure (decomposition of PO is correct).
9. Test scenarios are clear, stable, and well-structured.
10. There is at least one level of inheritance between pages (Abstract Page exists).
11. There is no code duplication at all.
12. Inner implementation of PO is hidden from tests.
13. Naming and code conventions should be followed.