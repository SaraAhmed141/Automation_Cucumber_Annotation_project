@smoke
Feature: Task | create tasks
  Scenario Outline: Create a task with a random name and select multiple users
    Given I am on the task creation page <emai> and password <passwor>
    When I enter a random task name


    Examples:
      | emai              | passwor  |
      | "Admin@wakeb.com" | "123456" |