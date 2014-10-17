Narrative:
In order to visualize the results without having to upload the file everytime
As a test engineer
I want to load in my account any result that was saved beforehand

Scenario: Success case: clicking on an item
Given that the user has access to the system
And he has a list of sent files beforehand
When the user requests the list of files
And clicks on an item in the list
Then the user will be redirected to the test case page

Scenario: Error case: no files available
Given that the user has access to the system
And he doesn't have any files uploaded beforehand
When the user requests the list of files uploaded
Then an error message will be displayed informing the user
that he doesn't have any files available

Scenario: Error case: user not logged in
Given that the user doesn't have access to the system
When the user requests the list of files uploaded
Then an error message will be displayed informing
the user that he doesn't have access to the system

Scenario: Success case: Consult sent files
Given that the user has access to the system
And there is a list of files sent beforehand
When the user requests the list of sent files
Then a list of sent files, which belongs to the
user or are accessible by him, will be displayed,
ordered by the last updated date