import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.FormPage;

import java.io.File;

@Slf4j
public class FormTest extends BaseTest {

    FormPage formPage;

    @BeforeEach
    public void testSetup() {
        formPage = new FormPage(driver);
    }

    @ParameterizedTest(name = "Form checked")
    @CsvFileSource(resources = "/testData.csv")
    @DisplayName("Form")
    @Tag("Basic")
    public void shouldFillFormWithData(String url) {
        driver.get(url);
        log.info("The page has been opened");

        formPage.setFirstNameInput("Agata")
                .setLastNameInput("De")
                .setEmailInput("agatha.de@gmail.com")
                .selectRandomSex()
                .setAgeInput(34)
                .selectRandomExperience()
                .selectAutomationTester()
                .selectRandomContinent(driver)
                .selectCommands(driver)
                .uploadFile(new File("src/main/resources/file.txt"))
                .clickSignInButton();

        Assertions.assertThat(formPage.getValidatorMessage()).isEqualTo("Form send with success");
        log.info("Form send with success");
    }
}
