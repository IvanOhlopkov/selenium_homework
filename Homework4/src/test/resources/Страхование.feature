#language: ru

  Функционал: Страхование

    Сценарий: Страхование путешественников

      Когда Выбран пункт меню "Застраховать себя"
        И Выбран вид страхования - "Страхование путешественников"
      Тогда Выполнено нажатие кнопки - Оформить онлайн

      Когда Выполнен переход на вторую вкладку браузера
      Тогда Проверка заголовка страницы "Страхование путешественников"

      Когда Выбор пакета страхования "Минимальная"
      Тогда Выполнено нажатие кнопки - Сохранить

      Когда заполняются поля:
        |Фамилия застрахованного(англ)|IVANOV|
        |Имя застрахованного(англ)|IVAN|
        |Дата рождения застрахованного|01.01.1990|
        |Фамилия|Иванов|
        |Имя|Иван|
        |Отчество|Иванович|
        |Дата рождения|01.01.1990|
      Тогда выбран пол "мужской"

      Когда заполняются поля:
        |Серия паспорта|1234|
        |Номер паспорта|567890|
        |Дата выдачи|01.01.2008|
        |Кем выдан|УФМС г. Тестовый|
      Тогда проверяются поля:
        |IVANOV|Фамилия застрахованного(англ)|
        |IVAN|Имя застрахованного(англ)|
        |01.01.1990|Дата рождения застрахованного|
        |Иванов|Фамилия|
        |Иван|Имя|
        |Иванович|Отчество|
        |01.01.1990|Дата рождения|
        |1234|Серия паспорта|
        |567890|Номер паспорта|
        |01.01.2008|Дата выдачи|
        |УФМС г. Тестовый|Кем выдан|

      Когда Выполнено нажатие кнопки - Сохранить
      Тогда Выполняется проверка сообщения "Заполнены не все обязательные поля"