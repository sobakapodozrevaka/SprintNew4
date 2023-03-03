package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {

    private final WebDriver driver;

    //кнопка "Заказать"
    private final By orderButton = By.xpath(".//button[text()='Заказать']");
    //Список вопросов
    private final By mainQuestions = By.xpath(".//div[@class='accordion__item']");
    //Список ответов
    private final By answer = By.xpath(".//div[@class='accordion__item']//p");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOrderButton(int index) {
        WebElement element = driver.findElements(orderButton).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElements(orderButton).get(index).click();
    }
    public void clickMainQuestions (int index) {
        WebElement element = driver.findElements(mainQuestions).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElements(mainQuestions).get(index).click();
    }

    public String getAnswer(int index) {
        return driver.findElements(answer).get(index).getText();
    }


}
