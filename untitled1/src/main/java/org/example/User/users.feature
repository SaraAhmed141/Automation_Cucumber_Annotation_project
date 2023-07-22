@smoke
Feature: Users | Add Users
  As an admin
  I want to add users with role of user
  So that they can access the system

  Scenario Outline: Add users
    Given I am on the login page
    When I login with email <email> and password <password>
    And I navigate to the users page
    And I add users with role of user
    And add segmentation and label
    Then add label and task
    Examples:
      | email             | password |
      | "Admin@wakeb.com" | "123456" |
