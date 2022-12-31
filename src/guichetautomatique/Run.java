package guichetautomatique;

import guichetautomatique.banque.Client;
import guichetautomatique.visual.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Run {

    // Attributs
    Visual login = new Login();

    // Methods
    public boolean verify(String nom, String pin) throws IOException, ClassNotFoundException {

        FileInputStream f2 = new FileInputStream("comptes");
        ObjectInputStream o = new ObjectInputStream(f2);

        Client[] clients = (Client[])o.readObject();

        o.close(); f2.close();

        for (int i = 0; i < clients.length; i++) {
            if(nom.equals(clients[i].getNom()) && pin.equals(clients[i].getPin()))
                return true;
        }

        return false;
    }

    public void run() throws IOException, ClassNotFoundException {

        // Affichage
        boolean continueLogin = true, continueMain = true;

        while(continueLogin) {

            continueMain = true;

            login.show(); // Affichage du menu

            if (!login.valide) {
                System.out.println("----- Identifiant ou code PIN est errone. Veuillez reesayez -----\n");
            }
            else {
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



    }
}
