Narrative:
In order to have a complete report of the test case
As a test engineer
I want to visualize the results as a table, with the columns: "Conjunto de Teste", "Caso de Teste", "Total de Dados de Teste", "Operador de Mutação", "Mutante", "Vivo?"

Scenario: View a single registered result
Given results page loaded
When I click a single result to view
Then the system redirects me to a page that shows me the informations of the chosen result

Scenario: Try to view a single invalid result
Given homepage loaded
When I load a non-existent result url
Then the system redirects me to an error page

Scenario: Try to view a protected result
Given homepage loaded
When I load a protected result url
Then the system redirects me to an error page