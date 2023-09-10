package Praktikum;

import Praktikum.Page.DataEntryPageScooter;
import Praktikum.Page.HomePageScooter;
import Praktikum.Page.RentalPageScooter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.containsString;


/******************************************** ТЕСТ ЗАКАЗА *****************************************************/

@RunWith(Parameterized.class)
public class TestOrder {
    String expectedTextSuccess;
    String actualTextSuccess;
    // Имя
    private final String nameField;
    // Фамилия
    private final String surnameField;
    // Адрес
    private final String addressField;
    // Метро
    private final String metroField;
    // Телефон
    private final String phoneField;
    private final String delivDate;
    private final String rentalTime;
    private final String colorID;
    private final String comment;


    // Конструктор для ввода данных пользователя
    public TestOrder(String firstNameField, String secondNameField, String addressField, String metroField, String phoneField, String delivDate, String rentalTime, String colorID, String comment) {
        this.nameField = firstNameField;
        this.surnameField = secondNameField;
        this.addressField = addressField;
        this.metroField = metroField;
        this.phoneField = phoneField;
        this.delivDate = delivDate;
        this.rentalTime = rentalTime;
        this.colorID = colorID;
        this.comment = comment;
    }

    // Создание объекта класса для получения драйвера
    @Rule
    public DriverRule driverRule = new DriverRule();

    // Тестовые данные для оформления заказа
    @Parameterized.Parameters
    public static Object[][] getDataEntry() {
        return new Object[][] {
                {"ИмяПервое", "ФамилияПервая", "Адрес1", "Строгино", "79990001122", "20.12.2023", "двое суток", "black", "Комментарий"},
                {"ИмяВторое", "ФамилияВторая", "Адрес2", "Курская", "79990003344", "20.12.2024", "трое суток", "grey", "Еще комментарий"},
        };
    }

    // Тест
    @Test
    public void testOrderWithTopButton() {
        // Создание объекта класса главной страницы
        HomePageScooter objHomePage = new HomePageScooter(driverRule.getDriver());
        // Открытие сайта
        objHomePage.openDriver();
        // Нажатие кнопки заказа
        objHomePage.topButtonOrderClick();
        // Создание объекта страницы ввода данных пользователя
        DataEntryPageScooter objEntryPage = new DataEntryPageScooter(driverRule.getDriver());
        // Заполнение данных пользователя
        objEntryPage.fillFieldsCustomer(nameField, surnameField, addressField, metroField, phoneField);
        // Создание объекта страницы аренды самоката
        RentalPageScooter objRentPage = new RentalPageScooter(driverRule.getDriver());
        // Заполенение данных аренды
        objRentPage.fillFieldRental(delivDate, rentalTime, colorID, comment);
        // Нажатие кнопки подтверждения заказа
        objRentPage.confirmOrderClick();
        // Получение актуального
        actualTextSuccess = objRentPage.getExpectedTextOrder();
        expectedTextSuccess = objRentPage.actualTextOrder();
        MatcherAssert.assertThat("Заказ не оформлен", expectedTextSuccess, containsString(actualTextSuccess));
    }

    @Test
    public void testOrderWithDownButton() {
        // Создание объекта класса главной страницы
        HomePageScooter objHomePage = new HomePageScooter(driverRule.getDriver());
        // Открытие сайта
        objHomePage.openDriver();
        // Нажатие кнопки заказа
        objHomePage.downButtonOrderClick();
        // Создание объекта страницы ввода данных пользователя
        DataEntryPageScooter objEntryPage = new DataEntryPageScooter(driverRule.getDriver());
        // Заполнение данных пользователя
        objEntryPage.fillFieldsCustomer(nameField, surnameField, addressField, metroField, phoneField);
        // Создание объекта страницы аренды самоката
        RentalPageScooter objRentPage = new RentalPageScooter(driverRule.getDriver());
        // Заполенение данных аренды
        objRentPage.fillFieldRental(delivDate, rentalTime, colorID, comment);
        // Нажатие кнопки подтверждения заказа
        objRentPage.confirmOrderClick();
        actualTextSuccess = objRentPage.actualTextOrder();
        expectedTextSuccess = objRentPage.getExpectedTextOrder();
        MatcherAssert.assertThat("Заказ не оформлен", actualTextSuccess, containsString(expectedTextSuccess));
    }
}
