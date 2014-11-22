Meta:

Narrative:
In order to have a more summarized results
As a computer scientist
I want to visualize graphs related to the report

Scenario: Visualization of the graph on the report
Given that the user has access to the system
And a test set has been upload
When the user visualizes the results report
Then a graph of the test set score shoud be shown


Scenario: check the score of test result
Given the uploaded file is test_result_1.xml
And that the user has access to the system
When the user visualizes the report of the uploaded file
Then the graph of the Test Case will be 100% green
And the percentage of the graph in green for each test case will be:
|TEST CASE | GREEN% |
|TC_1      | 100%   |
|TC_2      | 100%   |