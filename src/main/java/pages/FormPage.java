package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FormPage {
    Random random = new Random();

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;

    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> sexList;

    @FindBy(css = "#inputAge3")
    private WebElement ageInput;

    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> experienceList;

    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement automationTester;

    @FindBy(css = "#selectContinents")
    private WebElement continents;

    @FindBy(css = "#selectContinents>option")
    private List<WebElement> listOfOptions;

    @FindBy(css = "option[value='switch-commands']")
    private WebElement switchCommands;

    @FindBy(css = "option[value='wait-commands']")
    private WebElement waitCommands;

    @FindBy(css = "#chooseFile")
    private WebElement chooseFile;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement signInButton;

    @FindBy(css = "#validator-message")
    private WebElement validatorMessage;


    public FormPage setFirstNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public FormPage setLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage setEmailInput(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public FormPage selectRandomSex() {
        getRandomElement(sexList).click();
        return this;
    }

    public FormPage setAgeInput(int age) {
        ageInput.sendKeys(String.valueOf(age));
        return this;
    }

    public FormPage selectRandomExperience() {
        getRandomElement(experienceList).click();
        return this;
    }

    public FormPage selectAutomationTester() {
        automationTester.click();
        return this;
    }

    public FormPage selectRandomContinent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfOptions));
        new Select(continents).selectByIndex(random.nextInt(listOfOptions.size()));
        return this;
    }

    public FormPage selectCommands(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(switchCommands).click(waitCommands).build().perform();
        return this;
    }

    public FormPage uploadFile(File file) {
        chooseFile.sendKeys(file.getAbsolutePath());
        return this;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getValidatorMessage() {
        return validatorMessage.getText();
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(random.nextInt(elements.size()));
    }

}
