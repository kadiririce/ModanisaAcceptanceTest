package com.ToDo.step_definitions;

import com.ToDo.utilities.ConfigurationReader;
import com.ToDo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;

public class toDoListStepDefs {

    @Given("Empty ToDo list")
    public void empty_ToDo_list() {
        Driver.get().get(ConfigurationReader.get("url"));


    }

    @When("I write {string} to text box and click to enter")
    public void i_write_to_text_box_and_click_to_enter(String text) {
        Driver.get().findElement(By.xpath("//input[@autofocus='autofocus']")).sendKeys(text,Keys.ENTER);
    }

    @Then("I should see {string} item in ToDo list")
    public void i_should_see_item_in_ToDo_list(String expected) {
        String actual = Driver.get().findElement(By.xpath("//div[@class='view']")).getText();

        assertEquals(expected,actual);
    }

    @Given("ToDo list with {string} item")
    public void todoListWith(String txt) {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().findElement(By.xpath("//input[@autofocus='autofocus']")).sendKeys(txt,Keys.ENTER);
    }

    @Then("I should see {string} inserted to ToDo list")
    public void iShouldSeeInsertedToToDoList(String expected) {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[@class='view']"));
        boolean flag = false;
        for (WebElement element : elements) {
            if (element.getText().equals(expected)){
                flag = true;
            }
        }
        assertTrue(flag);

    }


    @When("I click on {string} text")
    public void iClickOnText(String text) {

        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[@class='view']"));
        for (WebElement element : elements) {
            if (element.getText().equals(text)){
                element.click();
            }
        }


    }

    @Then("I should see {string} item marked as")
    public void iShouldSeeItemMarkedAs(String text) {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[@class='view']"));
        int dummy=0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)){
                dummy = i ;
            }
        }
        List<WebElement> checkboxes = Driver.get().findElements(By.xpath("//input[@type='checkbox']"));
        WebElement element = checkboxes.get(dummy + 1);
        System.out.println("This acceptance criteria is no correct because it is not allowed to click on text \n" +
                "    #thats why I write a new Acceptance Criteria. If this A.C is correct than there is a bug.");
        Assert.assertTrue(element.isSelected());

    }

    @When("I click on {string} checkbox")
    public void iClickOnCheckbox(String text) {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[@class='view']"));
        int dummy=0;
        for (int i = 0; i < elements.size(); i++) {
             if (elements.get(i).getText().equals(text)){
                 dummy = i ;
             }
        }
        List<WebElement> checkboxes = Driver.get().findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(dummy+1).click();


    }

    @Given("ToDo list with marked item")
    public void todoListWithMarkedItem() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().findElement(By.xpath("//input[@autofocus='autofocus']")).sendKeys("buy some milk",Keys.ENTER);
        List<WebElement> checkboxes = Driver.get().findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(1).click();
    }

    @Then("I should see mark of item should be cleared as {string}")
    public void iShouldSeeMarkOfItemShouldBeClearedAs(String text) {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[@class='view']"));
        int dummy=0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)){
                dummy = i ;
            }
        }
        List<WebElement> checkboxes = Driver.get().findElements(By.xpath("//input[@type='checkbox']"));
        assertFalse(checkboxes.get(dummy+1).isSelected());

    }

    @When("I click on delete button next to {string}")
    public void iClickOnDeleteButtonNextTo(String text) {
        Actions actions = new Actions(Driver.get());

        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[@class='view']"));
        int dummy=0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)){
                dummy = i ;
            }
        }
        WebElement webElement = elements.get(dummy);
        actions.moveToElement(webElement).build().perform();
        List<WebElement> deleteButtons = Driver.get().findElements(By.xpath("//button[@class='destroy']"));
        deleteButtons.get(dummy).click();


    }

    @Then("List should be empty")
    public void listShouldBeEmpty() {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[@class='view']"));
        assertEquals(0, elements.size());
    }

    @Given("ToDo list with {string} and {string} items")
    public void todoListWithAndItems(String arg0, String arg1) {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().findElement(By.xpath("//input[@autofocus='autofocus']")).sendKeys(arg0,Keys.ENTER);
        Driver.get().findElement(By.xpath("//input[@autofocus='autofocus']")).sendKeys(arg1,Keys.ENTER);
    }

    @When("I write {string} to text box and click to add button")
    public void iWriteToTextBoxAndClickToAddButton(String text) {
        System.out.println("There is no add button on the page.Thats why I write a new test case for this A.C");
        assertTrue(false);
    }
}
