@important
Feature: The user open the website accept the cookies and change the language to hun

  Rule: Allow to change the language

    Background:
      Given open main page
      And accept cookies

      @TC_ChangeLang
      Scenario: Change language
        When the language is English
        Then change the language to Magyar
