## Отчёт по итогам тестирования

### Краткое описание

Выполнена автоматизация тестирования сервиса покупки тура.

Тестировались два способа оплаты:
1. Оплата тура по дебетовой карте
1. Оплата тура, через выдачу кредита

Заявлена поддержка двух СУБД:
* MySQL
* PostgreSQL

**Приложение не работает с PostgreSQL.**

### Количество тест-кейсов
Всего выполнено 46 автоматизированных тест-кейсов

### Процент успешных/не успешных
* 26 успешных (56.52%)
* 20 не успешных (43.47%)

#### Подготовлены отчёты:
* [Отчёт Gradle](https://github.com/Cossmoz/Diploma/issues/15)
* [Отчёт Allure](https://github.com/Cossmoz/Diploma/issues/16)

### Общие рекомендации
* Устранить выявленные баги, которые указаны в [issue](https://github.com/Cossmoz/Diploma/issues);
* Реализовать изменение цвета кнопок "Купить" и "Купить в кредит" после их нажатия, чтобы была возможность определить, какой способ оплаты активен;
* Уточнить какой максимальный срок действия может иметь карта (было принято 5 лет, но карты могут быть и более длительного срока службы).