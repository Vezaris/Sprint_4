package ru.yandex.practicum.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/***************************************** СТРАНИЦА АРЕНДЫ САМОКАТА **********************************************/

public class RentalPageScooter {
    final WebDriver DRIVER;
    String expectedTextOrder = "Заказ оформлен";

    /*----------------------------------------- ЛОКАТОРЫ ---------------------------------------------*/

    // Поле даты доставки
    private By deliveryDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Поле аренды
    private By rentField = By.xpath("//div[text()='* Срок аренды']");
    // Комментарий
    private By commentForCourier = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // Кнопка заказа
    private By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Подтверждение заказа
    private By confirmOrder = By.xpath("//button[text()='Да']");
    // Оформленный заказ
    private By successOrder = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    //Конструктор
    public RentalPageScooter(WebDriver driver) {
        this.DRIVER = driver;
    }

    /*------------------------------------ МЕТОДЫ --------------------------------------*/

    // Выбор даты доставки
    public void chooseDeliveryDate(String delivDate) {
        DRIVER.findElement(deliveryDate).click();
        DRIVER.findElement(deliveryDate).sendKeys(delivDate);
        // Запись цифр до первой точки в переменную
        String date = delivDate.substring(0, delivDate.indexOf("."));
        // Поиск элемента по тексту из переменной date и клик на этот элемент
        DRIVER.findElement(By.xpath("//div[text()='" + date + "']")).click();
    }

    // Выбор длительности аренды
    public void rentDuration(String rentalTime) {
        DRIVER.findElement(rentField).click();
        DRIVER.findElement(By.xpath("//div[text()='" + rentalTime + "']")).click();
    }

    // Выбор цвета самоката
    public void colorScooter(String colorID) {
        DRIVER.findElement(By.xpath("//input[@id='" + colorID + "']")).click();
    }

    // Комментарий
    public void commentForCourier(String comment) {
        DRIVER.findElement(commentForCourier).sendKeys(comment);
    }

    // Кнопка заказа
    public void buttonOrderClick() {
        DRIVER.findElement(buttonOrder).click();
    }

    // Подтверждение заказа
    public void confirmOrderClick() {
        DRIVER.findElement(confirmOrder).click();
    }

    // Получить текст оформленного заказа
    public String actualTextOrder() {
        String textSuccessOrder = DRIVER.findElement(successOrder).getAttribute("textContent");
        return textSuccessOrder;
    }

    // Получение текста заказа
    public String getExpectedTextOrder() {
        return expectedTextOrder;
    }

    // Заполнение всех полей аренды
    public void fillFieldRental(String delivDate, String rentalTime, String colorID, String comment) {
        chooseDeliveryDate(delivDate);
        rentDuration(rentalTime);
        colorScooter(colorID);
        commentForCourier(comment);
        buttonOrderClick();
    }
}
