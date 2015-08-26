Scenario: A trader is alerted of status

Given a stock and a threshold of 15.0
When the stock is traded at price 5.0
Then the alert status is OFF