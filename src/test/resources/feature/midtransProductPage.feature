Feature: Midtrans Pillow Checkout Feature

  Scenario: Midtrans Pillow checkout feature with success payment feature
    Given gets midtrans demo url
    When user opens with midtrans demo shop on provided browser
    Then user verifies midtrans demo shop page
    And user checks for product name
    And user checks for product tag
    And user checks for product desc
    And user checks for product price
    When user click on carousel next to view product pics
    Then verify image changes once user clicks on it
