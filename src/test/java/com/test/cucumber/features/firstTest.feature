Feature: Tests for task one

  Scenario: I want to add product into basket
    Given I choose task "1"
    When I select product "Kubek" using "numbers" with amount of "2"
    And I click on add product for "Kubek"
    Then I see in basket "Kubek (5.12)"

  Scenario: I want to add product into basket with arrows
    Given I choose task "1"
    When I select product "Kabel" using "arrows" with amount of "2"
    And I click on add product for "Kabel"
    Then I see in basket "Kabel (4.22)"

  Scenario: I want to see all of products in list
    When I choose task "1"
    Then I see all the products

    Scenario: I want to delete product from basket
      Given I choose task "1"
      When I select product "Kubek" using "numbers" with amount of "2"
      And I click on add product for "Kubek"
      And I delete product from basket
      Then I want to check that basket is empty