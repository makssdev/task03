package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String userRun;
            int userRunInt =0;
            int compRunInt;
            boolean menuExit =true;
            conditions(args);
            Key key = new Key();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            compRunInt = getRandomWord(args);
            key.GenerateKeyAndHMAC(args[compRunInt-1]);
            System.out.println("HMAC: "+key.GetHMAC());

            do{
                menu(args);
                userRun = reader.readLine();

                switch (userRun){
                    case "0": System.exit(0);
                    case "?": Table table = new Table();
                              table.GenerateTable(args);
                              break;
                    default:
                        try {
                            userRunInt = Integer.parseInt(userRun);
                        } catch (NumberFormatException e){
                            System.out.println("You are wrong, please try again\n");
                        }

                        if(userRunInt >=1 && userRunInt <= args.length){
                            System.out.println("Your move: "+args[userRunInt-1]);
                            menuExit=false;
                        }
                }
            }while(menuExit);
            System.out.println("Computer move: "+args[compRunInt-1]);

            Winner winner = new Winner();
            winner.WhoWin(userRunInt, compRunInt, args.length);
            System.out.println(winner.getWin());
            System.out.println("HMAC key: "+key.GetKey());

    }

    static void conditions(String[] args){
        if(args.length%2 == 0 || !(args.length >=3) || DuplicateWorld(args)) {
            System.out.println("Error \nExample: java -jar game.jar rock paper scissors lizard Spock");
            System.exit(0);
        }
    }

    static Integer getRandomWord(String[] words) {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return index+1;

    }

    static boolean DuplicateWorld(String[] words){
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (!set.add(word)) {
                System.out.println("You have duplicate - "+word);
                return true;
            } else continue;
        }
    return false;
    }

    static void menu(String[] args){
        System.out.println("\nAvailable moves:\n");
        for (int i = 0; i < args.length; i++) {
            System.out.println(i+1 +" - "+ args[i]);
        }
        System.out.println("0 - exit\n? - help\nEnter your move: ");
    }
}
