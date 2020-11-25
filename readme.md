Project requirements:
Java Development Kit 8 and higher;
Maven

Run project:
Clone as a Maven project

Run tests:
Run "mvn clean test" in console

Generating Allure report:
Report can be generated only after test run
Run "mvn allure:serve" command from command line to generate and open Allure report


Project is integrated with Circle CI, Allure report can be viewed on the "Artifact" tab - target/site/allure-maven-plugin/index.html
Dashboard can be found https://app.circleci.com/pipelines/github/YanaMr/MobTestAssignment

Test "EmailValidationTest" coveres:
1. Search for the user with username “Delphine”
2. Use the details fetched to make a search for the posts written by the
   user
3. For each post, fetch the comments and validate if the emails in the
   comment section are in the proper format --- Regular expression used for email validation
4. Think of various scenarios for the test workflow, all the things that
   can go wrong. Add them to test coverage --- JSON Schema Validator added
   
I didn't remove unused methods from Pojo as I'm building a framework and these methods can be used in the future  