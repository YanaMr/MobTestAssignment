Feature: Email Validation

  Scenario: Validate emails format from comments
    Given I sent a request to get user by username
    And I get response body
    And I check that only one user is found
    And I save users ID
    And I sent a request to get posts by user ID
    And I get response body for all Posts
    And I create a list of posts
    When I create a list of all comments
    And I received list of emails
    Then I validate email format