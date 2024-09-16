@calculator002
Feature: 002 Calculator
  Addition of numbers passed as argument. return -1 if no arguments passed

  Scenario: 002 sum with variables
    Given 002 two numbers <num1> and <num2>
    When 002 two numbers are passed as arguments
    Then result is <result>

  Examples:
    | num1 | num2 | result |
    | 10 | 20 | 30 |
    | 20 | 30 | 50 |
    | 30 | 40 | 70 |