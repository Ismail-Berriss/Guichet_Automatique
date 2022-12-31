package guichetautomatique;

import guichetautomatique.banque.Client;
import guichetautomatique.banque.Compte;
import guichetautomatique.visual.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Run {

    // Attributs
    private Visual login = new Login(this);
    public Client[] clients;
    public int currentClient;
    public int currentCompte;


    // Methods
    public boolean verify(String nom, String pin) throws IOException, ClassNotFoundException {

        FileInputStream f2 = new FileInputStream("comptes");
        ObjectInputStream o = new ObjectInputStream(f2);

        clients = (Client[])o.readObject();

        o.close(); f2.close();

        for (int i = 0; i < clients.length; i++) {
            for(int j = 0; j < clients[i].getNbCompte(); j++) {
                if(nom.equals(clients[i].getNom()) && pin.equals(clients[i].getCompte(j).getPin()))  {
                    currentClient = i;
                    currentCompte = j;
                    return true;
                }
            }
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
                continueLogin = false;

                Scanner clavier = new Scanner(System.in);

                while(continueMain) {

                    int choix;

                    do {
                        Visual mainMenu = new MainMenu(this);
                        mainMenu.show();
                        choix = clavier.nextInt();

                    } while(choix < 1 || choix > 6);

                    switch (choix) {
                        case 1:
                            Visual retrait = new Retrait(this);
                            retrait.show();
                            break;
                        case 2:
                            Visual depot = new Depot(this);
                            depot.show();
                            break;
                        case 3:
                            Visual virement = new Virement(this);
                            virement.show();
                            break;
                        case 4:
                            Visual solde = new Solde(this);
                            solde.show();
                            break;
                        case 5:
                            Visual releve = new Releve(this);
                            releve.show();
                            break;
                        case 6:
                            continueMain = false;
                        default:
                            break;
                    }
                }
            }
        }



    }
}