import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class FillOrderTest {
    private WebDriver driver;
    private final int buttonIndex;
    private final String name;
    private final String surname;
    private final String address;
    private final int metroIndex;
    private final String phone;
    private final String date;
    private final int timeRentIndex;
    private final String colour;
    private final String comment;


    public FillOrderTest(int buttonIndex, String name, String surname, String address, int metroIndex, String phone, String date, int timeRentIndex, String colour, String comment) {
        this.buttonIndex = buttonIndex;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroIndex = metroIndex;
        this.phone = phone;
        this.date =date;
        this.timeRentIndex= timeRentIndex;
        this.colour =colour;
        this.comment =comment;
    }

    @Parameterized.Parameters
    public static Object[][] getText() {
        return new Object[][] {
                {0, "Вильгельмина", "Христорождественнская", "Центральный проезд Хорошевского Серебряного Бора", 10, "89999999999", "12.03.2023", 2, "grey", "срочно"},
                {1, "Ая", "Тё", "ул. Лазо", 57, "89811039965", "25.07.2023", 0, "black", "..."}

        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

        @Test
        public void fillOrder() {
            HomePage crossToOrder = new HomePage(driver);
            crossToOrder.clickOrderButton(buttonIndex);
            OrderPage fillOrder = new OrderPage(driver);
            fillOrder.fillNameCustomer(name);
            fillOrder.fillSurnameCustomer(surname);
            fillOrder.fillAddressDelivery(address);
            fillOrder.fillMetroStation(metroIndex);
            fillOrder.fillPhoneCustomer(phone);
            fillOrder.clickNextButton();
            fillOrder.chooseDate(date);
            fillOrder.chooseTimeRent(timeRentIndex);
            fillOrder.chooseColour(colour);
            fillOrder.fillCommentDelivery(comment);
            fillOrder.clickFinalOrderButton();
            fillOrder.clickYes();
            fillOrder.clickStatusInfo();

        }

        @After
        public void teardown() {
            driver.quit();
        }

    }
