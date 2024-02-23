Project Name: Just Eat Takeaway Career Section Automation

## Overview:

This project is aimed at automating test cases for the career section of the Just Eat Takeaway platform. The automated tests will verify the functionality and behavior of the career search feature, ensuring that it returns accurate results based on different search criteria such as job title and location.

## Project Setup Instructions:

### Prerequisites

1. Install IntelliJ IDEA IDE.
2. Install Java Development Kit (JDK). 
3. Install Test Automation plugin in IntelliJ IDEA.

### Clone the Project Repository

1. Clone the project repository from GitHub or download it as a zip file and extract it to your preferred directory.
2. Import the Project into IntelliJ IDEA
   Open IntelliJ IDEA.
3. Select File -> Open and navigate to the directory where you cloned the project.
4. Select the project directory and click Open to import the project.

### Install Maven Dependencies

IntelliJ IDEA should automatically detect the pom.xml file and prompt you to import dependencies.
If not, right-click on the pom.xml file and select Maven -> Reimport to fetch dependencies.
  
### Running Tests from IntelliJ IDEA

1. Navigate to the test class containing the automated test cases (e.g., [JetTest.java](src%2Ftest%2Fjava%2Fcom%2Firinarykunova%2Fjettests%2FJetTest.java)).
2. Right-click on the class name or test method.
3. Select Run or Debug to execute the test(s).
   
 ### Running Tests via Maven

1. Open the Terminal in IntelliJ IDEA.
2. Navigate to the project directory.
3. Run the following Maven command to execute tests: `mvn clean test`   