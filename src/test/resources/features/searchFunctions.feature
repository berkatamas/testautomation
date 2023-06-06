@important
Feature: The user use the search function on the website

  Background:
    Given open main page
    And accept cookies
    And change the language to Magyar

  Rule: Allow to use the search function

    @TC_Search
    Scenario Outline: Search on website

      When give the word "<search_word>"
      Then get the right result with the word "<search_word>"
      Examples:
      | search_word   |
      | alma          |
      | alma narancs  |
      | almafa        |