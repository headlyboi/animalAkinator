package ru.headly.junakinator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headly.junakinator.constants.MessagesRu;

@Service
@RequiredArgsConstructor
public class OutputService {

    private final MessagesRu messagesRu;

    public void printStartMessage() {
        System.out.printf(messagesRu.getStartMessage());
        System.out.println();
    }

    public void printEndMessage() {
        System.out.println(messagesRu.getEndMessage());
    }

    public void printQuestionAboutAnimalMessage(String question) {
        System.out.printf(messagesRu.getQuestionAboutAnimal(), question);
        System.out.println();
    }

    public void printIncorrectInputMessage() {
        System.out.println(messagesRu.getIncorrectInput());
    }

    public void printResultQuestion(String animal) {
        System.out.printf(messagesRu.getResultQuestion(), animal);
        System.out.println();
    }

    public void printQuestionAboutRepeatGameMessage() {
        System.out.println(messagesRu.getQuestionAboutRepeat());
    }

    public void printQuestionAboutDiffTwoAnimals(String firstAnimal, String secondAnimal) {
        System.out.printf(messagesRu.getQuestionAboutDiff(), firstAnimal, secondAnimal);
        System.out.println();
    }

    public void printDefeatMessage() {
        System.out.println(messagesRu.getDefeatMessage());
    }

    public void alreadyKnowAnimalMessage() {
        System.out.println(messagesRu.getAlreadyKnowAnimal());
    }
}
