Feature: Test2

  Scenario:
    Given I am on action page: "<https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html>"
    When I clicked on button: "<Add person>"
    And I enter info: "<Nat>"
    And I enter job: "<Teacher>"
    And I click submit: "<Add>"
    Then I see added name and job

    Scenario: edit person
      Given I am on action page
      When I click editor on
      And I clicked on field Name
      And I enter value: "<Ann>"
      And I click on button Edit
      Then I see the name is changed: "<Ann>"

      Scenario: remove the person
        Given I am on action page
        When I click on remover button on: "<Jill>"
        Then I see name disapeared


        Scenario: reset list
          Given I am on action page
          When I click on button: "<Reset List>"
          Then I see the added names and jobs are not displayed

          Scenario: clear button test
          Given I am on page:  "<https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html>"
            When I enter infoname: "<Bruno>"
            And I enter jobname: "<Cowboy>"
            And I click button: "<Clear all fields>"
            Then I see all fields are empty






