package Praktikum.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/********************************* СТРАНИЦА ВВОДА ДАННЫХ ПОЛЬЗОВАТЕЛЯ ***********************************************/

public class DataEntryPageScooter {
    final WebDriver driver;

    //Конструктор
    public DataEntryPageScooter(WebDriver driver) {
        this.driver = driver;

    }



    /*---------------------------------- ЛОКАТОРЫ ------------------------*/

    // Имя
    private By firstNameField = By.xpath("//input[@placeholder='* Имя']");

    // Фамилия
    private By secondNameField = By.xpath("//input[@placeholder='* Фамилия']");

    // Адрес
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // Метро
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    // Телефон
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private By nextButtonClick = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");




    /*---------------------------------- МЕТОДЫ -----------------------------------*/

    // Ввод имени
    public void inputFieldName(String value) {
        driver.findElement(firstNameField).sendKeys(value);
    }

    // Ввод фамилии
    public void inputFieldSurname(String value) {
        driver.findElement(secondNameField).sendKeys(value);
    }

    // Ввод адреса
    public void inputFieldAddress(String value) {
        driver.findElement(addressField).sendKeys(value);
    }

    // Выбор станции метро
    public void chooseMetroStation(String station) {
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);
    }

    // Ввод номера
    public void inputFieldPhone(String value) {
        driver.findElement(phoneField).sendKeys(value);
    }

    // Нажатие кнопки "Далее"
    public void buttonNextClick() {
        driver.findElement(nextButtonClick).click();
    }

    // Заполениние всех полей с данными пользователя
    public void fillFieldsCustomer(String firstName, String secondName, String address, String station, String phone) {
        inputFieldName(firstName);
        inputFieldSurname(secondName);
        inputFieldAddress(address);
        chooseMetroStation(station);
        inputFieldPhone(phone);
        buttonNextClick();
    }
}
