# 📝 ToDoApp

Небольшое веб-приложение для ведения списка дел. Проект создан на **Spring Boot** и использует **Thymeleaf** для шаблонов и стандартный `TodoItemRepository` для работы с данными.

## ✨ Возможности

- Добавление новых задач
- Просмотр всех задач
- Удаление отдельных задач
- Удаление всех задач сразу
- Поиск по названию задачи

## 🗂️ Структура проекта

- com.dimarzhanov.todoapp.controller.ToDoController` — контроллер, обрабатывающий веб-запросы.
- com.dimarzhanov.todoapp.model.TodoItem` — модель элемента списка дел.
- com.dimarzhanov.todoapp.repositories.TodoItemRepository` — репозиторий для работы с данными(интерфейс JpaRepository).

## ⚙️ Установка и запуск

1. Склонируйте репозиторий:
   
   git clone https://github.com/mr-arzh/todoapp.git
   cd todoApp
2. Убедитесь, что у вас установлены:

# Java 21
# Maven
# Spring Boot(зависимости подтянутся автоматически)

3. Соберите и запустите проект:

mvn spring-boot:run
или:
./mvnw spring-boot:run


## Откройте браузер по адресу:

http://localhost:8080

## 📄 API (эндпоинты)

Метод	URL /	Описание
GET	      /	Отображает список дел
POST	    / add	Добавляет новый элемент
POST	    / delete/{id}	Удаляет элемент по ID
POST	    / deleteAll	Удаляет все элементы
POST	    / search	Ищет элементы по названию

## 📝 Шаблон (frontend)

HTML-шаблон index.html (Thymeleaf) отображает:

1. Список всех задач
2. Форму добавления новой задачи
3. Поле поиска
4. Удаление всех задач

## 🧑‍💻 Автозаполнение при запуске

Контроллер реализует CommandLineRunner, который при старте приложения создаёт 2 тестовых задачи:

# Item 1
# Item 2

## 🚀 Планы развития

1. Добавить аутентификацию(не выполнено)
2. Возможность редактирования задачи(не выполнено)
3. Фильтры по статусу (не выполнено)

<img width="2820" height="1336" alt="image" src="https://github.com/user-attachments/assets/85eac7cb-efb4-4d2a-abef-0fea930b8d9a" />
