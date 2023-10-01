package ru.headly.junakinator.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.headly.junakinator.game.Game;

@Component
@RequiredArgsConstructor
public class GameRunner implements CommandLineRunner {

    private final Game game;

    @Override
    public void run(String... args){
        game.startGame();
    }
}
