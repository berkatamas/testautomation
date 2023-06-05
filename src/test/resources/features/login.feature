@important
Feature: The user open the website accept the cookies and change the language to hun

  Rule: Allow to change the language

    Background:
      Given open main page
      And accept cookies

      @TC_ChangeLang
      Scenario Outline: Change language
        Given language is set to "<language>"
        When change the language to "<new_language>"
        Then it shows elements in "<new_language>"

      Examples:
        | language | new_language |
        | magyar   | english      |
        | english  | magyar       |