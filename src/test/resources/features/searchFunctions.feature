@important
Feature: The user use the search function on the website

  Background:
    Given open main page
    And accept cookies
    And change the language to Magyar

  Rule: Allow to use the search function

    @TC_Search
    Scenario Outline: Search on website with result

      When search with the word "<search_word>"
      Then get title with the word "<search_word>"
      And product names in the result list contains the word "<search_word>"
      Examples:
      | search_word   |
      | alma          |
      | kifli         |
      | monster       |
