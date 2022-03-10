Feature: Application URL redirection

Background:
Given User Navigated to URL

@tag1
Scenario: Application URL redirection
When launching http://automationpractice.com
Then Validate its  redirected to "http://automationpractice.com/index.php"

@tag1
Scenario: Application logo visibility
When The application logo is displayed
Then The application logo width is 350 & height is 99

@tag1
Scenario Outline: – Application product main category list validation
When Validate main product categories count should be 3
Then  "<Product>" the displayed three categories is as shown below
Examples: 
| Product |
| WOMEN |
| DRESSES |
| T-SHIRTS | 

@tag5
Scenario: Application Search functionality
When Validate while entering the text "T-shirt" in search box
Then The search result contains "T-shirt" as text

@tag1
Scenario: Application social media handles validation
When user clicks on the twitter link form footer section form landing page of the application
Then Validate the url opened on a new tab contains "seleniumfrmwrk"
And the twiiter accont name is "Selenium Framework"


