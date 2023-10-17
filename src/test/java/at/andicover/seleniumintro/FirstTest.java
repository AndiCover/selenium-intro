package at.andicover.seleniumintro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstTest extends BaseTest {

    @Test
    void test() {
        driver.get("https://www.coversoftwaresolutions.com");
        assertNotNull(getSloganElement());

        setFirstName("Andi");
        setLastName("Cover");
        setMail("name@example.com");
        setPhoneNumber("+123456789");
        setMessage("I running a test with Selenium!");
        clickSendMessage();

        assertEquals("Please tick this box if you want to proceed.", getCheckBoxValidationMessage());
    }

    private WebElement getSloganElement() {
        return driver.findElement(By.xpath("//h1[.='We got you covered']"));
    }

    private void setFirstName(String name) {
        setFormText("firstname", name);
    }

    private void setLastName(String name) {
        setFormText("lastname", name);
    }

    private void setMail(String mailAddress) {
        setFormText("email", mailAddress);
    }

    private void setPhoneNumber(String phoneNumber) {
        setFormText("phone", phoneNumber);
    }

    private void setMessage(String message) {
        setFormText("message", message);
    }

    private void setFormText(String formId, String text) {
        driver.findElement(By.id(formId)).sendKeys(text);
    }

    private void clickSendMessage() {
        driver.findElement(By.xpath("//button[.='Send message']")).click();
    }

    private String getCheckBoxValidationMessage() {
        return driver.findElement(By.id("terms-checkbox")).getAttribute("validationMessage");
    }
}
