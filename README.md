# Amazon Selenium TestNG Automation

This is a sample Maven Java project for automating Amazon web searches using Selenium and TestNG.

## How to Run

1. Make sure you have Java, Maven, and ChromeDriver installed and available in your PATH.
2. Navigate to the project directory:
   ```
   cd amazon-selenium-testng
   ```
3. Run the tests with Maven:
   ```
   mvn test
   ```

## Framework Structure
- **base**: WebDriver setup/teardown (`BaseTest.java`)
- **pages**: Page Object Model classes (e.g., `AmazonHomePage.java`)
- **tests**: TestNG test classes (e.g., `AmazonSearchTest.java`)
- **utils**: Utilities (e.g., `WaitUtils.java`)
- **resources**: Config files (`config.properties`, `testng.xml`)

## Example Usage
- Add more page classes in `pages` for each Amazon page.
- Add more test classes in `tests` for different scenarios.
- Add utility methods in `utils` as needed.
- Update `config.properties` for environment/config changes.
- Control test flow with `testng.xml`.

## Notes
- Update the path to `chromedriver` in `BaseTest.java` if needed.
- You can add more tests in the `tests` package.
