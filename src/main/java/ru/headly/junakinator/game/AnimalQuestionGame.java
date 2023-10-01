package ru.headly.junakinator.game;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.headly.junakinator.constants.MessagesRu;
import ru.headly.junakinator.model.AnimalNode;
import ru.headly.junakinator.model.AnimalTree;
import ru.headly.junakinator.model.Tree;
import ru.headly.junakinator.service.InputService;
import ru.headly.junakinator.service.OutputService;

@Component
@RequiredArgsConstructor
public class AnimalQuestionGame implements Game {

    private final OutputService output;

    private final InputService input;

    private final MessagesRu messagesRu;

    private final Tree<AnimalNode> animalNodeTree = new AnimalTree<>();

    @Override
    public void startGame() {
        AnimalNode root = new AnimalNode();
        root.setQuestion("живет на суше");
        root.setYes(new AnimalNode("кот"));
        root.setNo(new AnimalNode("кит"));
        animalNodeTree.createTree(root);
        output.printStartMessage();


        boolean processed = true;
        while (processed) {
            AnimalNode currentNode = animalNodeTree.getTree();
            String userInput;

            while (!currentNode.isEndOfTree()) {
                output.printQuestionAboutAnimalMessage(currentNode.getQuestion());
                userInput = input.getInput();
                switch (userInput) {
                    case "да":
                        currentNode = currentNode.getYes();
                        break;
                    case "нет":
                        currentNode = currentNode.getNo();
                        break;
                    default:
                        output.printIncorrectInputMessage();
                }
            }

            userInput = messagesRu.getEmpty();
            while (isIncorrectUserInput(userInput)) {
                output.printResultQuestion(currentNode.getAnimal());
                userInput = input.getInput();
                switch (userInput) {
                    case "да":
                        output.printEndMessage();
                        break;
                    case "нет":
                        output.printDefeatMessage();
                        String newAnimal = input.getInput();
                        if (animalNodeTree.containsNode(newAnimal)) {
                            output.alreadyKnowAnimalMessage();
                            break;
                        }
                        output.printQuestionAboutDiffTwoAnimals(currentNode.getAnimal(), newAnimal);
                        String newQuestion = input.getInput();
                        currentNode.setQuestion(newQuestion);
                        currentNode.setNo(new AnimalNode(currentNode.getAnimal()));
                        currentNode.setYes(new AnimalNode(newAnimal));
                        break;
                    default:
                        output.printIncorrectInputMessage();
                }
            }

            userInput = messagesRu.getEmpty();
            while (isIncorrectUserInput(userInput)) {
                output.printQuestionAboutRepeatGameMessage();
                userInput = input.getInput();
                switch (userInput) {
                    case "да":
                        break;
                    case "нет":
                        output.printEndMessage();
                        processed = false;
                        break;
                    default:
                        output.printIncorrectInputMessage();
                }
            }
        }
        input.closeInput();
    }

    private boolean isIncorrectUserInput(String input) {
        return !messagesRu.getNo().equals(input) && !messagesRu.getYes().equals(input);
    }
}
