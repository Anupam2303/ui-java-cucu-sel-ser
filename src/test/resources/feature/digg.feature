Feature: To do acceptance for digg.com

  @Search @Positive @Test
  Scenario: Validate search box is function
    Given user navigate to digg.com main website
    When user click on search icon
    Then user should redirect to search page
    When user enter 'COVID' text to search
    And user press enter button
    Then user should get covid related results


  @Search @Negative
  Scenario: Validate search box is function
    Given user navigate to digg.com main website
    When user click on search icon
    Then user should redirect to search page
    When user press enter button
    Then user should get message ' You probably know how to use a search engine, but in case you don't, just typesome keywords in the little box above.'

  @Subheading @Positive
  Scenario: Validate search box is function
    Given user navigate to digg.com main website
    When user clicks on tech
    Then user should redirect to picks page
    When user clicks on picks
    Then user should redirect to picks page
    When user clicks on video
    Then user should redirect to video page
    When user clicks on longreads
    Then user should redirect to longreads page
    When user clicks on news
    Then user should redirect to news page
    When user clicks on science
    Then user should redirect to science page


