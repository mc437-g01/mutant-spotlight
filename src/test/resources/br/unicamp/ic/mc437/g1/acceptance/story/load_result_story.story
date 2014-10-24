Narrative:
In order to visualize the results later without uploading the file again
As a test Engineer 
I want to save the results of the xml file uploaded

Scenario: Success case: the results are saved
Given that the user uploaded an xml file
Then the results of that xml file will be saved on the system

Scenario: Error case: the results are not saved
Given that the user uploaded an xml file
Then the system shows an error message