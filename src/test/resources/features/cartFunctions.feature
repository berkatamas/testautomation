@important
Feature: The user add, modify and remove products in the cart

  Background:
    Given open main page
    And accept cookies
    And change the language to Magyar
    And user fill login data
    And login to store

  Rule: Allow to add products to cart

    @TC_AddtoCart
    Scenario: Add products to cart

      When user click Hozzáad
      Then product added to cart

  Rule: Allow to modify the cart

    @TC_ModifyCart
    Scenario: Modify quantity in cart

      When user change the quantity of a product
      Then product quantity is change

  Rule: Allow to empty the cart

    @TC_ModifyCart
    Scenario: Empty the cart

      When user delete all product in cart
      Then cart will be empty
