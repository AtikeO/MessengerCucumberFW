@web
Feature: Messenger Page Feature

  Background:
    Given I am on messenger page

  @messenger
  Scenario: Verify invalid login from messenger page
    When I enter  ilhanturkmen@siliconalabs.com into username field on the messenger page
    And I enter  test1234 into password field on the messenger page
    And I click on login button on messenger page
    Then I verify invalid login message on sign in page