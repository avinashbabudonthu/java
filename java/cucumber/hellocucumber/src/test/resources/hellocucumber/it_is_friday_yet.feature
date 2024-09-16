Feature: Is it friday yet?
    Everybody wants to know when it is Friday

    Scenario: Sunday is not Friday
        Given today is Sunday
        When I ask whether it is Friday yet
        Then I was told No