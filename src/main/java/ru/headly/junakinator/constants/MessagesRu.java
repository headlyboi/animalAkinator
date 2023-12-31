package ru.headly.junakinator.constants;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MessagesRu {

    private final String yes = "да";

    private final String no = "нет";

    private final String startMessage = "Загадай животное. Я попробую отгадать";

    private final String endMessage = "Спасибо за игру. Удачи";

    private final String questionAboutAnimal = "Это животное %s? (да/нет)";

    private final String resultQuestion ="Это %s?";

    private final String incorrectInput = "Некорректный ответ. Введите да или нет (регистр не важен)";

    private final String questionAboutRepeat = "Хочешь сыграть еще раз? (да/нет)";

    private final String questionAboutDiff = "Чем %s отличается от %s?";

    private final String defeatMessage = "Какое животное ты загадал?";

    private final String empty = "";

    private final String alreadyKnowAnimal = "Я знал такое животное, но не угадал!";
}
