Narrative:
In order to have a complete report of the test case
As a test engineer
I want to visualize the results as a table, with the columns: "Conjunto de Teste", "Caso de Teste", "Total de Dados de Teste", "Operador de Mutação", "Mutante", "Vivo?"

Scenario: View a single registered result
Given there are results in the system
And results page loaded
When I click a single result to view
Then the system redirects me to a page that shows me the informations of the chosen result

Scenario: Try to view a single invalid result
Given homepage loaded
When I load a non-existent result url
Then the system redirects me to an error page

Scenario: Filter results by name
Given there are results in the system
And results page loaded
When I type test result 1 on filter input
And I select the name filter
And I click the search button
Then the system lists only results named test result 1

Scenario: Filter results by email
Given there are results in the system
And results page loaded
When I type test@email.com on filter input
And I select the email filter
And I click the search button
Then the system lists only results uploaded by test@email.com

Scenario: Filter results by date
Given there are results in the system
And results page loaded
When I type 07/11/2014 on filter input
And I select the date filter
And I click the search button
Then the system lists only results uploaded on 07/11/2014