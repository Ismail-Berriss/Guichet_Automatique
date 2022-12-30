package guichetautomatique;

import guichetautomatique.visual.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import guichetautomatique.banque.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        boolean continueMain = false; // true
        int choix;
        Scanner clavier = new Scanner(System.in);

        // Désérialisation ------------------------------------------------------------

        FileInputStream f2 = new FileInputStream("comptes");
        ObjectInputStream o = new ObjectInputStream(f2);

        Client clients[] = (Client[])o.readObject();

        for(int i = 0; i < Client.getNbClient(); i++) {
            System.out.println(clients[i].toString());
        }

        f2.close(); o.close();

        // ------------------------------------------------------------

        while(continueMain) {
            do {
                Visual mainMenu = new MainMenu();
                mainMenu.header();
                mainMenu.content();

                choix = clavier.nextInt();
            } while(choix < 1 || choix > 6);

            switch (choix) {
                case 1:

                    break;
                case 6:
                    continueMain = false;
                    break;
            }


        }


    }



}