Feature: Pricing Calculator

Scenario: Calculate Virtual Machine cost per month
    Given Open the Calculator page
    When Specify Number of Instances as "4"
        And Specify Operation System as "Paid: Red Hat Enterprise Linux"
        And Specify Hours as "8"
        And Click Add To Estimate
    Then Estimate equals "Total Estimated Cost: USD 65.43 per 1 month"
