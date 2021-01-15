Feature: ToDo List manipulation

  Scenario: user add new item to the list
    Given Empty ToDo list
    When I write "buy some milk" to text box and click to add button


  Scenario: user add new item to the list
    Given Empty ToDo list
    When I write "buy some milk" to text box and click to enter
    Then I should see "buy some milk" item in ToDo list

  Scenario: user add second iteö
    Given ToDo list with "buy some milk" item
    When I write "enjoy the assignment" to text box and click to enter
    Then I should see "enjoy the assignment" inserted to ToDo list

    #This acceptance criteria is not correct because it is not allowed to click on text
    #thats why I write a new Acceptance Criteria. If this A.C is correct than there is a bug.
  Scenario: user click on item
    Given ToDo list with "buy some milk" item
    When I click on "buy some milk" text
    Then I should see "buy some milk" item marked as

  Scenario: user click on item
    Given ToDo list with "buy some milk" item
    When I click on "buy some milk" checkbox
    Then I should see "buy some milk" item marked as

  Scenario: user click on item again
    Given ToDo list with marked item
    When I click on "buy some milk" checkbox
    Then I should see mark of item should be cleared as "buy some milk"

  Scenario: user delete an item
    Given ToDo list with "rest for a while" item
    When I click on delete button next to "rest for a while"
    Then List should be empty


  Scenario: user delete one of the item
    Given ToDo list with "rest for a while" and "drink water" items
    When I click on delete button next to "rest for a while"
    Then I should see "drink water" item in ToDo list


