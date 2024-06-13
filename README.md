# Облачное хранилище

API для хранения, загрузки, удаления и переименования файлов на сервере.

### Описание

REST-интерфейс для интеграции с
готовым [FRONT](https://github.com/netology-code/jd-homeworks/blob/master/diploma/netology-diplom-frontend). Реализует
методы,
описанные [в спецификации](https://github.com/netology-code/jd-homeworks/blob/master/diploma/CloudServiceSpecification.yaml):

- Авторизация
- Вывод списка файлов пользователя с установленным лимитом
- Загрузка файлов
- Переименование файлов
- Удаление файлов

Подключение к API осуществляется по порту 8080. FRONT занимает следующий за 8080 свободный порт.

### Запуск

Возможен запуск с помощью IDE или с помощью Docker (docker-compose).

### Используемые технологии

- Spring Boot
- СУБД Postgresql
- Сборщик пакетов Maven
- Система управления миграциями баз данных Liquibase
- Docker, docker-compose
- Mockito
- Testcontainers
- jjwt
- Lombok
