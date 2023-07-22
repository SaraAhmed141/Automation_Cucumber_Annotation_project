@smoke
Feature: annotation_create | annotation to the tasks
  Scenario Outline: Create a annotation to the task
    Given I am on task creation page <ema> and password <passwo>
    When When click on open Task
    And make a annotation to more than one image
    Then make a annotation to the second image

    Examples:
      | ema               | passwo   |
      | "Admin@wakeb.com" | "123456" |