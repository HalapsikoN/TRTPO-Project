# Представление результатов

| ID | Назначение/название | Сценарий | Ожидаемый результат | Фактический результат | Оценка |
|:---:|:---:|:---|:---|:---|:---|
| 1 | Регистрация нового аккаунта пользователя | 1. Перейдите по адресу сайта на [главную страницу](#1).<br> 2. Нажмите кнопку "Зарегистрироваться".<br> 3. На открывшейся [странице](#2) введите имя пользователя и пароль.<br>4. Нажмите кнопку "Зарегистрироваться".| Произошло перенаправление на [главную страницу](#1) сайта. | Произошло перенаправление на главную страницу сайта. | Тест пройден. |
| 2 | Регистрация уже сущестующего аккаунта пользователя | 1. Перейдите по адресу сайта на [главную страницу](#1).<br> 2. Нажмите кнопку "Зарегистрироваться".<br> 3. На открывшейся [странице](#2) введите имя пользователя и пароль, уже сущестующего аккаунта в системе.<br>4. Нажмите кнопку "Зарегистрироваться".| Появилось [сообщение на странице](#3) с уведомлением о том, что данное имя уже занято. | Появилось сообщение на странице с уведомлением о том, что данное имя уже занято. | Тест пройден. |
| 3 | Вход в зарегистрированный аккаунт | 1. Перейдите по адресу сайта на [главную страницу](#1).<br> 2. Нажмите кнопку "Войти".<br> 3. На открывшейся [странице](#4) введите имя пользователя и пароль, уже сущестующего аккаунта в системе.<br>4. Нажмите кнопку "Войти".| Произошло перенаправление на [страницу редактора аккаунта](#5). | Произошло перенаправление на страницу редактора аккаунта. | Тест пройден. |
| 4 | Добавление новой заметки | 1. Выполните сценарий 3.<br> 2. Нажмите кнопку "Добавить".<br> 3. На открывшейся [странице](#6) введите название и текст заметки.<br>4. Нажмите кнопку "Добавить".| Произошло перенаправление на [страницу редактора аккаунта](#7) с вашей новой заметкой. | Произошло перенаправление на страницу редактора аккаунта с новой заметкой. | Тест пройден. |
| 5 | Добавление заметки с занятым именем| 1. Выполните сценарий 3.<br> 2. Нажмите кнопку "Добавить".<br> 3. На открывшейся [странице](#6) введите название, уже использованное на данном аккаунте, и текст заметки.<br>4. Нажмите кнопку "Добавить".| Появилось [сообщение на странице](#8) с уведомлением о том, что данное название уже занято. | Появилось сообщение на странице с уведомлением о том, что данное название уже занято. | Тест пройден. |
| 6 | Поиск существующей заметки по имени | 1. Выполните сценарий 3.<br> 2. Для иллюстрации прмера добавьте ещё одну заметку по сценарию 4.<br> 3. Введите имя интересующей Вас заметки в поле в правом нижнем углу [страницы](#9).<br>4. Нажмите кнопку "Найти".| На [странице](#5) осталась лишь искомая заметка. | На странице осталась лишь искомая заметка. | Тест пройден. |
| 7 | Поиск несуществующей заметки по имени | 1. Выполните сценарий 3.<br>2. Введите имя несуществующей заметки в поле в правом нижнем углу [страницы](#9).<br>3. Нажмите кнопку "Найти".| На [странице](#10) не осталось ни одной заметки. | На странице не осталось ни одной заметки. | Тест пройден. |
| 8 | Просмотр заметки | 1. Выполните сценарий 3.<br>2. На [странице](#9) в таблице заметок нажмите на заголовок интересующей Вас заметки.| На [странице](#11) откроется окно с прикрепленным к данному заголовку текстом. | На странице открылось окно с прикрепленным к данному заголовку текстом. | Тест пройден. |
| 9 | Редактирование заметки | 1. Выполните сценарий 3.<br>2. На [странице](#9) нажмите на иконку с карандашом в графе "Изменить".<br>3. На открывшейся [странице](#12) измените текст заметки.<br>4. Нажмите кнопку "Изменить".| Произошло перенаправление на [страницу редактора аккаунта](#9) с вашей изменённой заметкой. | Произошло перенаправление на страницу редактора аккаунта с изменённой заметкой. | Тест пройден. |
| 10 | Редактирование заметки c изменением имени на уже существующее в сиситеме| 1. Выполните сценарий 3.<br>2. На [странице](#9) нажмите на иконку с карандашом в графе "Изменить".<br>3. На открывшейся [странице](#12) измените имя заметки на уже существующее в системе.<br>4. Нажмите кнопку "Изменить".| Появилось [сообщение на странице](#13) с уведомлением о том, что данное название уже занято. | Появилось сообщение на странице с уведомлением о том, что данное название уже занято. | Тест пройден. |
| 11 | Удаление заметки| 1. Выполните сценарий 3.<br>2. На [странице](#9) нажмите на иконку с крестиком в графе "Удалить".<br>3. На открывшейся [странице](#14) нажмите кнопку "Удалить".| Произошло перенаправление на [страницу редактора аккаунта](#15) без удаленной заметки. | Произошло перенаправление на страницу редактора аккаунта без удалённой заметки.| Тест пройден. |
| 12 | Выход из аккаунта| 1. Выполните сценарий 3.<br>2. На [странице](#15) нажмите на кнопку "Выйти" в правом верхнем углу.| Произошло перенаправление на [страницу входа](#4) в аккаунт. | Произошло перенаправление на страницу входа в аккаунт. | Тест пройден. |
| 13 | Попытка изменения записки другого пользователя по id заметки| 1. Выполните сценарий 3.<br>2. На [странице](#15) нажмите на иконку с карандашом в графе "Изменить".<br>3. На открывшейся [странице](#16) скопируйте id заметки.<br>4. Выполните сценарий 12.<br>5. Выполните сценарий 3 для другого аккаунта.<br>6.На [странице](#17) нажмите на иконку с карандашом в графе "Изменить".<br>7. На открывшейся [странице](#18) замените id заметки на id из буффера обмена.<br>8. Нажмите "Enter". | Произошло перенаправление на [страницу редактора аккаунта](#17) без изменения заметок. | Произошло перенаправление на страницу редактора аккаунта без изменения заметок. | Тест пройден. |
| 14 | Вход в незарегистрированный аккаунт| 1. Перейдите по адресу сайта на [главную страницу](#1).<br> 2. Нажмите кнопку "Войти".<br> 3. На открывшейся [странице](#4) введите имя пользователя и пароль, несущестующего аккаунта в системе. | Появилось сообщение на странице с уведомлением о том, что аккаунт не найден в ситстеме. | Произошло перенаправление на страницу входа. | Тест не пройден. |
| 15 | Добавление файла к записке| 1. Выполните сценарий 3.<br>2. Нажмите кнопку "Добавить".<br> 3. На открывшейся [странице](#6) введите название и текст заметки.4. Нажмите кнопку "Выбрать файл" и выберите файл<br>5. Нажмите кнопку "Добавить". | Произошло перенаправление на [страницу редактора аккаунта](#9) с вашей новой заметкой.  | Нереализован функционал. | Тест не пройден. |
| 16 | Просмотр спарвки о сайте| 1. Перейдите по адресу сайта на [главную страницу](#1).<br> 2. Нажмите иконку "Справка".| Открылось окошко с информацией о сайте. | Нереализован функционал. | Тест не пройден. |
|  |  |  |  |  |  |

# Иллюстрации

<a name="1"/>

Рисунок 1.
![Рисунок 1](../Images/Testing/1.png)

<a name="2"/>

Рисунок 2.
![Рисунок 2](../Images/Testing/2.png)

<a name="3"/>

Рисунок 3.
![Рисунок 3](../Images/Testing/3.png)

<a name="4"/>

Рисунок 4.
![Рисунок 4](../Images/Testing/4.png)

<a name="5"/>

Рисунок 5.
![Рисунок 5](../Images/Testing/5.png)

<a name="6"/>

Рисунок 6.
![Рисунок 6](../Images/Testing/6.png)

<a name="7"/>

Рисунок 7.
![Рисунок 7](../Images/Testing/7.png)

<a name="8"/>

Рисунок 8.
![Рисунок 8](../Images/Testing/8.png)

<a name="9"/>

Рисунок 9.
![Рисунок 9](../Images/Testing/9.png)

<a name="10"/>

Рисунок 10.
![Рисунок 10](../Images/Testing/10.png)

<a name="11"/>

Рисунок 11.
![Рисунок 11](../Images/Testing/11.png)

<a name="12"/>

Рисунок 12.
![Рисунок 12](../Images/Testing/12.png)

<a name="13"/>

Рисунок 13.
![Рисунок 13](../Images/Testing/13.png)

<a name="14"/>

Рисунок 14.
![Рисунок 14](../Images/Testing/14.png)

<a name="15"/>

Рисунок 15.
![Рисунок 15](../Images/Testing/15.png)

<a name="16"/>

Рисунок 16.
![Рисунок 16](../Images/Testing/16.png)

<a name="17"/>

Рисунок 17.
![Рисунок 17](../Images/Testing/17.png)

<a name="18"/>

Рисунок 18.
![Рисунок 18](../Images/Testing/18.png)