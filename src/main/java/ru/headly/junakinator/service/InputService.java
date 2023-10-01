package ru.headly.junakinator.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class InputService {

    private final Scanner scanner = new Scanner(System.in);

    public String getInput(){
        return scanner.nextLine().toLowerCase();
    }

    public void closeInput(){
        scanner.close();;
    }
}
