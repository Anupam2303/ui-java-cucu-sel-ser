Feature: Midtrans Pillow Checkout Feature

  @Positive @ProductPage @Smoke
  Scenario: Midtrans Pillow Product Page feature
    Given gets midtrans demo url
    When user opens with midtrans demo shop on provided browser
    Then user verifies midtrans demo shop page
    And user checks for product name
    And user checks for product tag
    And user checks for product desc
    And user checks for product price
    When user click on carousel next to view product pics
    Then verify image changes once user clicks on it

  @Positive @Checkout @ValidCreditCard
  Scenario: Midtrans Pillow checkout with valid credit card
    Given gets midtrans demo url
    When user opens with midtrans demo shop on provided browser
    Then user verifies midtrans demo shop page
    When user clicks on buynow to purchase product
    Then verify price in checkout page
    And verify name, address, contact number is available
    When user clicks on checkout button
    Then verify product name and price
    And verify customer name and email id
    When user clicks continue checkout
    And user select creditcard as payment option
    Then user verifies order amount
    When user enter card number '4811111111111114'
    And enters expirydate and cvv '02/20' '123'
    And clicks on paynow
    And enters OTP '112233'
    Then verify transaction is successfull
    And verify success msg on homepage

  @Positive @Checkout @InvalidcreditCrad
  Scenario: Midtrans Pillow checkout with invalid credit card
    Given gets midtrans demo url
    When user opens with midtrans demo shop on provided browser
    Then user verifies midtrans demo shop page
    When user clicks on buynow to purchase product
    Then verify price in checkout page
    And verify name, address, contact number is available
    When user clicks on checkout button
    Then verify product name and price
    And verify customer name and email id
    When user clicks continue checkout
    And user select creditcard as payment option
    Then user verifies order amount
    When user enter card number '4811111111111113'
    And enters expirydate and cvv '02/20' '123'
    And clicks on paynow
    Then verify error message 'Invalid card number'
