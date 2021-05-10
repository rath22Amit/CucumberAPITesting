Feature: Work with GitHubAPI


@gitHub
Scenario Outline: User is able to validate the gitHub API response

		Given User sets the base API 
		And User authenticates the API req with "<token>"
		When User send the API request to get all the repositories with "<endpoint>"
		Then User Validates resposeCode as <code>
		Examples:
		|token                                      |endpoint            |code   |
		|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   | /user/repos        | 200   |