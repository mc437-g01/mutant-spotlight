Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: click on upload button with all info
Given upload page loaded
When I fill the email input
And I fill the name input
And I select a file to upload
And I click on upload button
Then the system redirects to upload page

Scenario: click on upload button without selecting file
Given upload page loaded
When I fill the email input
And I fill the name input
And I click on upload button
Then the system shows an empty file error

Scenario: click on upload button without filling email
Given upload page loaded
When I select a file to upload
And I fill the name input
And I click on upload button
Then the system shows an empty email error

Scenario: click on upload button without filling name
Given upload page loaded
When I select a file to upload
And I fill the email input
And I click on upload button
Then the system shows an empty name error

Scenario: click on upload button with a file that is not on xml format
Given upload page loaded
When I fill the email input
And I fill the name input
And I select a invalid file to upload
And I click on upload button
Then the system shows an invalid file error