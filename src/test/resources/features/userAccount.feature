@important
Feature: The user login to site and edit user data

  Rule: Allow to change the language

    @TC_ChangeLang
    Scenario: Change language
      Given open main page
      And accept cookies
      When the language is English
      Then change the language to Magyar

  Rule: Allow to login to site

    @TC_Login
      Scenario: Login
        When user fill login data
        Then login to store