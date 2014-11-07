Meta:

Narrative:
As a user
I want to perform a see a uploaded xml file information
So that I can check the score

Lifecycle:
Before:
Given there is the test 1 in the system
And there is the test 2 in the system

Scenario: see a score of test result
Given the test list page loaded
When I choose a test
Then the system redirects to result show page
And show the calculated score for test result
And show the calulated scores for test sets

Scenario: check the score of test result 1
Given the test list page loaded
When I choose the test 1
Then the system redirects to result show page
And the calculated score for test result is 100%
And the calulated scores for test sets is:
|TEST SET | SCORE (%) |
|1        | 50        |
|2        | 100       |

Scenario: check the score of test result 2
Given the test list page loaded
When I choose the test 2
Then the system redirects to result show page
And the calculated score for test result is 75%
And the calulated scores for test sets is:
|TEST SET | SCORE (%) |
|1        | 100       |
|2        | 50        |
|3        | 75        |

