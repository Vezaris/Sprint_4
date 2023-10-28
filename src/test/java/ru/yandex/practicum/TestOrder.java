package ru.yandex.practicum;

import ru.yandex.practicum.Page.DataEntryPageScooter;
import ru.yandex.practicum.Page.HomePageScooter;
import ru.yandex.practicum.Page.RentalPageScooter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/******************************************** ТЕСТ ЗАКАЗА *****************************************************/

@RunWith(Parameterized.class)
public class TestOrder {
    // Имя
    private final String FIRST_NAME;
    // Фамилия
    private final String SECOND_NAME;
    // Адрес
    private final String ADDRESS;
    // Метро
    private final String METRO;
    // Телефон
    private final String PHONE;
    private final String DELIV_DATE;
    private final String RENTAL_TIME;
    private final String COLOR_ID;
    private final String COMMENT;
    // Создание объекта класса для получения драйвера
    @Rule
    public DriverRule driverRule = new DriverRule();
    String expectedTextSuccess;
    String actualTextSuccess;

    // Конструктор для ввода данных пользователя
    public TestOrder(String firstName, String secondName, String address, String metro, String phone, String delivDate, String rentalTime, String colorID, String comment) {
        this.FIRST_NAME = firstName;
        this.SECOND_NAME = secondName;
        this.ADDRESS = address;
        this.METRO = metro;
        this.PHONE = phone;
        this.DELIV_DATE = delivDate;
        this.RENTAL_TIME = rentalTime;
        this.COLOR_ID = colorID;
        this.COMMENT = comment;
    }

    // Тестовые данные для оформления заказа
    @Parameterized.Parameters
    public static Object[][] getDataEntry() {
        return new Object[][]{
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
        objEntryPage.fillFieldsCustomer(FIRST_NAME, SECOND_NAME, ADDRESS, METRO, PHONE);
        // Создание объекта страницы аренды самоката
        RentalPageScooter objRentPage = new RentalPageScooter(driverRule.getDriver());
        // Заполенение данных аренды
        objRentPage.fillFieldRental(DELIV_DATE, RENTAL_TIME, COLOR_ID, COMMENT);
        // Нажатие кнопки подтверждения заказа
        objRentPage.confirmOrderClick();
        actualTextSuccess = objRentPage.actualTextOrder();
        expectedTextSuccess = objRentPage.getExpectedTextOrder();
        assertThat("Заказ не оформлен", actualTextSuccess, containsString(expectedTextSuccess));
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
        objEntryPage.fillFieldsCustomer(FIRST_NAME, SECOND_NAME, ADDRESS, METRO, PHONE);
        // Создание объекта страницы аренды самоката
        RentalPageScooter objRentPage = new RentalPageScooter(driverRule.getDriver());
        // Заполенение данных аренды
        objRentPage.fillFieldRental(DELIV_DATE, RENTAL_TIME, COLOR_ID, COMMENT);
        // Нажатие кнопки подтверждения заказа
        objRentPage.confirmOrderClick();
        actualTextSuccess = objRentPage.actualTextOrder();
        expectedTextSuccess = objRentPage.getExpectedTextOrder();
        assertThat("Заказ не оформлен", actualTextSuccess, containsString(expectedTextSuccess));
    }
}
