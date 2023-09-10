package Praktikum.Page;

import Praktikum.EnvConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/********************************** ГЛАВНАЯ СТРАНИЦА ******************************************/
public class HomePageScooter {
    final WebDriver driver;

    // Текст ответов в FAQ
    private String[] listOfFaqAnswersExpected = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области." };

    //Конструктор
    public HomePageScooter (WebDriver driver) {
        this.driver = driver;
    }




    /*------------------------------------------- ЛОКАТОРЫ -------------------------------------------*/

    // Верхняя кнопка заказа
    private By topButtonOrderClick = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Нижняя кнопка заказа
    private By downButtonOrderClick = By.xpath("//body/div/div/div[1]/div[4]/div[2]/div[5]/button");




    /*--------------------------------------------- МЕТОДЫ ---------------------------------------------------*/

    // Перейти на сайт для тестов
    public void openDriver () {
        driver.get(EnvConfig.UrlForTestScooter);
    }

    // Нажать на верхнюю кнопку заказа
    public void topButtonOrderClick () {
        driver.findElement(topButtonOrderClick).click();
    }

    // Нажать на нижнюю кнопку заказа
    public void downButtonOrderClick() {
        // Скрол до кнопки
        WebElement element = driver.findElement(downButtonOrderClick);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Нажатие на кнопку, игнорируя перекрывающие элементы
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    // Скрол до FAQ
    public void scrollToFaq() {
        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Заполненине массива полученным текстом из FAQ
    public String[] recordInListFaq() {
        String[] listTextOfFaq = new String[8];
        for (int i = 0; i < 8; i++) {
            listTextOfFaq[i] = getTextInFaq(i);
        }
        return listTextOfFaq;
    }

    // Получение текста FAQ для последующей записи в массив
    public String getTextInFaq(int index) {
        String textForList = driver.findElement(By.id("accordion__panel-" + index)).getAttribute("textContent");
        return textForList;
    }

    // Получение актуального текста для ответов FAQ
    public String[] getAnswer () {
        return listOfFaqAnswersExpected;
    }
}
