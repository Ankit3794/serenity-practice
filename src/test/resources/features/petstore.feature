@pet_api
Feature: Verify add and delete methods for petstore

  Scenario: Add Pet
    Given user adds new pet
    Then validate status code 200

  Scenario: Delete Pet
    Given user deletes pet with id 1
    Then validate status code 200