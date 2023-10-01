# Научи меня угадывать животных
Интеллектуальная программа умеет с помощью наводящих вопросов угадывать животное, загаданное игроком. Для этого у нее есть база знаний, состоящая из вопросов о свойствах животных и ответов на них. В начале работы база знаний состоит из одного вопроса “живет на суше?” и двух ответов: да - кот и нет - кит. По ходу игры программа задает вопросы из своей базы знаний и в конце концов либо угадывает животное, если у нее оно есть в базе знаний, либо ошибается, если загаданное животное и имеющееся в базе знаний неотличимы по запрошенным свойствам. Во втором случае, программа спрашивает у игрока, животное, которое он загадал, и свойство, которым оно отличается от имеющегося в базе. После этого программа обновляет свою базу знаний и предлагает сыграть еще раз.

Пример диалога:
 - "Это животное живет на суше? (да/нет)"
 - да
 - "Это кот? (да/нет)"
 - нет
 - "Какое животное ты загадал?"
 - обезьяна
 - "Чем “обезьяна” отличается от “кот”?"
 - ест бананы



### Алгоритм приложения
 - Пройтись по дереву на основании ответов пользователя
 - Когда дерево закончится, попросить пользователя ввести животное, которое он загадал
 - Если животное ранее было загадано и находится в базе, вывести об этом сообщение, не добавляя его в базу знаний


### Можно улучшить
- Сохранять состояние дерева в базу или в файл
- Добавить возможность запускать несколько инстансов и мерджить полученные деревья через очередь
- Сделать валидацию дерева
- Добавить логирование и писать логи в отдельный файл

