# Sprint_4

Проект с автотестами для заказа самокатов.

Присутствуют два тестовых сценария:
1. Количество вопросов и ответов в FAQ, а так же соответствие текста ответа для конкретного вопроса.
2. Флоу оформления заказа самоката с двумя комплектами тестовых данных.

Тестирование проходит в двух браузерах: Firefox и Chrome.
Тест на Chrome запускается по дефолту, для запуска на Firefox нужно в конфигурации idea прописать "-ea -Dbrowser=firefox".

Исползуемые технологии в проекте:
Java 11
Junit 4.13.2
maven 4.0.0
selenium 4.9.1