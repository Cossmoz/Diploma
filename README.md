## Запуск приложения
### Подготовительный этап
1. Установить и запустить IntelliJ IDEA;
1. Установить и запустить Docker Desktop;
1. Скопировать репозиторий с Github [по ссылке](https://github.com/Cossmoz/Diploma).
1. Открыть проект в IntelliJ IDEA.

### Запуск тестового приложения
1. Запустить MySQL, PostgreSQL, NodeJS через терминал командой:
   ```
   docker-compose up
   ```
1. В новой вкладке терминала запустить тестируемое приложение командой:
    * Для MySQL:
   ```
   java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar
   ```
    * Для PostgreSQL:
   ```
   java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app -jar artifacts/aqa-shop.jar
   ```
   .
1. Убедиться в готовности системы (приложение доступно по адресу):
```
http://localhost:8080/
```

### Запуск тестов
В новой вкладке терминала запустить тесты командой:
1. Для MySQL:
   ```
   gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app
   ```
1. Для PostgreSQL:
   ```
   gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app
   ```

### Перезапуск тестов и приложения
Остановить приложение командой `Ctrl+С` в терминале. Повторить необходимые шаги, описанные выше.

## Формирование отчёта о тестировании
Для формирования отчета тестирования с помощью Allure в новой вкладке терминала ввести команду
```
gradlew allureServe
```