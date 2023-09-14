package ru.yandex.practicum;

import ru.yandex.practicum.Page.HomePageScooter;
import org.junit.Rule;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestFaq {
    // Создание объекта класса для получения драйвера
    @Rule
    public DriverRule driverRule = new DriverRule();
    String[] listOfFaqActual;
    String[] listOfFaqExpected;

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
        assertThat("Не совпадает количество существующих и ожидаемых ответов", listOfFaqActual.length, equalTo(listOfFaqExpected.length));
        // Сравнение текста в ответах
        for (int i = 0; i < listOfFaqActual.length; i++) {
            assertThat("Не совпадает текст в ответе номер " + i, listOfFaqActual[i], equalTo(listOfFaqExpected[i]));
        }
    }
}
