package Praktikum;

import Praktikum.Page.HomePageScooter;
import org.junit.Rule;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TestFaq {
    String[] listOfFaqActual;

    String[] listOfFaqExpected;

    // Создание объекта класса для получения драйвера
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void positiveCheckAnswers() {
        // Создание объекта класса главной страницы
        HomePageScooter objHomePage = new HomePageScooter(driverRule.getDriver());
        // Открытие сайта
        objHomePage.openDriver();
        // Скролл до блока FAQ
        objHomePage.scrollToFaq();
        // Получение массива текста с актуальными ответами
        listOfFaqActual = objHomePage.recordInListFaq();
        // Получение массива текста для сравнения
        listOfFaqExpected = objHomePage.getAnswer();
        // Cравнение количества существующих и полученных ответов блока FAQ
        assertEquals("Не совпадает количество существующих и ожидаемых ответов", listOfFaqActual.length, listOfFaqExpected.length);
        // Сравнение текста в ответах
        for (int i = 0; i < listOfFaqActual.length; i++) {
            assertEquals("Не совпадает текст в ответе номер " + i, listOfFaqActual[i], listOfFaqExpected[i]);
        }
    }
}
