package Praktikum.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/***************************************** СТРАНИЦА АРЕНДЫ САМОКАТА **********************************************/
public class RentalPageScooter {
    final WebDriver driver;

    String expectedTextOrder = "Заказ оформлен";

    //Конструктор
    public RentalPageScooter(WebDriver driver) {
        this.driver = driver;
    }



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



    /*------------------------------------ Методы --------------------------------------*/

    // Выбор даты доставки
    public void chooseDeliveryDate(String delivDate) {
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryDate).sendKeys(delivDate);
        // Запись цифр до первой точки в переменную
        String date = delivDate.substring(0, delivDate.indexOf("."));
        // Поиск элемента по тексту из переменной date и клик на этот элемент
        driver.findElement(By.xpath("//div[text()='" + date + "']")).click();
    }

    // Выбор длительности аренды
    public void rentDuration(String rentalTime) {
        driver.findElement(rentField).click();
        driver.findElement(By.xpath("//div[text()='" + rentalTime + "']")).click();
    }

    // Выбор цвета самоката
    public void colorScooter(String colorID) {
        driver.findElement(By.xpath("//input[@id='" + colorID + "']")).click();
    }

    // Комментарий
    public void commentForCourier(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    // Кнопка заказа
    public void buttonOrderClick() {
        driver.findElement(buttonOrder).click();
    }

    // Подтверждение заказа
    public void confirmOrderClick() {
        driver.findElement(confirmOrder).click();
    }

    // Получить текст оформленного заказа
    public String actualTextOrder() {
        String textSuccessOrder = driver.findElement(successOrder).getAttribute("textContent");
        return textSuccessOrder;
    }

    // Получение текста заказа
    public String getExpectedTextOrder() {
        return expectedTextOrder;
    }

    // Заполнение всех полей аренды
    public void fillFieldRental(String delivDate, String rentalTime, String colorID, String comment){
        chooseDeliveryDate(delivDate);
        rentDuration(rentalTime);
        colorScooter(colorID);
        commentForCourier(comment);
        buttonOrderClick();
    }
}
