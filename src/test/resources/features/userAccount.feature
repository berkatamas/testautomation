@important
Feature: The user login to site and edit user data

  Background:
    Given open main page
    And accept cookies

  Rule: Allow to change the language

    @TC_ChangeLang
    Scenario: Change language

      When the language is English
      Then change the language to Magyar

  Rule: Allow to login to site

    @TC_Login
    Scenario: Login

      Given change the language to Magyar
      When user fill login data
      Then login to store

  Rule: Allow to edit user data

    @TC_EditUserData
    Scenario: Edit user account data

      Given login to store
      And change the language to Magyar
      When open user account page
      Then edit user mobile number