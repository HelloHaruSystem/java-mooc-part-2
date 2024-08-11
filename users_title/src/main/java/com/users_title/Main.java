package com.users_title;

import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a title and press enter:");
        String userInput = scanner.nextLine();
        scanner.close();

        Application.launch(UserTitle.class,
                "--title=" + userInput);
    }

}