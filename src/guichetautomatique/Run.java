package guichetautomatique;

import guichetautomatique.banque.Client;
import guichetautomatique.visual.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Run {
    public Run() {
    }

    public void run() throws IOException, ClassNotFoundException {
        FileInputStream f2 = new FileInputStream("comptes");
        ObjectInputStream o = new ObjectInputStream(f2);
        Client[] clients = (Client[])o.readObject();

        for(int i = 0; i < clients.length; ++i) {
            System.out.println(clients[i].toString());
        }

        o.close();
        f2.close();
        boolean continueLogin = true;

        while(continueLogin) {
            Visual login = new Login();
            login.show();
        }

        boolean continueMain = true;
        Scanner clavier = new Scanner(System.in);

        while(continueMain) {
            int choix;
            do {
                Visual mainMenu = new MainMenu();
                mainMenu.show();
                choix = clavier.nextInt();
            } while(choix < 1 || choix > 6);

            switch (choix) {
                case 1:
                default:
                    break;
                case 6:
                    continueMain = false;
            }
        }

    }
}
