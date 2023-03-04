package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class OrderPage {
    private final WebDriver driver;

    // Поле Имя
    private final By nameCustomer = By.xpath(".//input[@placeholder = '* Имя']");

    //Поле Фамилия
    private final By surnameCustomer = By.xpath(".//input[@placeholder = '* Фамилия']");

    //Поле Адрес
    private final By addressDelivery = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле Станция Метро (поле для ввода, выпадающий список, конкретное метро)
    private final By inputMetro = By.className("select-search__input");
    private  final By listOfMetro = By.xpath(".//div[@class = 'select-search__select']");

    private final By metroDelivery = By.xpath(".//div[@class = 'select-search__select']//li");

    //Поле Телефон
    private final By phoneCustomer = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    private final By nextButton = By.xpath(".//div[@class = 'Order_NextButton__1_rCA']/button");

    //Поле Дата доставки

    private final By dateDelivery = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //Поле Срок аренды
    private final By timeRent = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By listOfTime = By.xpath(".//div[@class = 'Dropdown-menu']//div");

    //Чекбокс Цвет
    private final By blackColour = By.className("Checkbox_Label__3wxSf");
    private final By greyColour = By.className("Checkbox_Label__3wxSf");
    //Комментарий курьеру

    private final By commentDelivery = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    //финальная кнопка Заказать
    private final By finalOrderButton = By.xpath(".//div[@class='Order_Content__bmtHS']//button[contains(text(), 'Заказать')]");

    //кнопка Подтверждения
    private final By confirmYesButton = By.xpath(".//button[contains(text(),'Да')]");

    //кнопка Посмотреть статус

    private final By statusInfoButton = By.xpath(".//button[contains(text(),'Посмотреть статус')]");
    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public String fillNameCustomer(String name) {
        driver.findElement(nameCustomer).sendKeys(name);
        return name;
    }

    public String fillSurnameCustomer(String surname) {
        driver.findElement(surnameCustomer).sendKeys(surname);
        return surname;
    }

    public String fillAddressDelivery(String address) {
        driver.findElement(addressDelivery).sendKeys(address);
        return address;
    }

    public void fillMetroStation(int index) {
        driver.findElement(inputMetro).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(listOfMetro));
        WebElement element = driver.findElements(metroDelivery).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElements(metroDelivery).get(index).click();
    }

    public String fillPhoneCustomer(String phone) {
        driver.findElement(phoneCustomer).sendKeys(phone);
        return phone;
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public String chooseDate(String date) {
        driver.findElement(dateDelivery).sendKeys(date);
        driver.findElement(By.className("App_App__15LM-")).click();
        return date;
    }

    public void chooseTimeRent(int index) {
        driver.findElement(timeRent).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(listOfTime));
        driver.findElements(listOfTime).get(index).click();
    }
    public void chooseColour(String colour) {
        if (colour == "black") {
            driver.findElement(blackColour).click();}
      else {
            driver.findElement(greyColour).click();}
        }
   public String fillCommentDelivery(String comment) {
        driver.findElement(commentDelivery).sendKeys(comment);
        return comment;
   }

   public void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
   }

   public void clickYes() {
       new WebDriverWait(driver, Duration.ofSeconds(3))
               .until(ExpectedConditions.visibilityOfElementLocated(confirmYesButton));
        driver.findElement(confirmYesButton).click();
   }

   public void clickStatusInfo() {
        driver.findElement(statusInfoButton).click();
   }
}
