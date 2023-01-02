package guichetautomatique;

import shared.Client;
import guichetautomatique.visual.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    // Attributs
    private Visual login;
    public ArrayList<Client> clients;
    public int currentClient;
    public int currentCompte;

    // Constructors
    public Run() {
        login = new Login(this);
        clients = new ArrayList<Client>();
    }

    // Methods
    public boolean verify(String nom, String pin) throws IOException, ClassNotFoundException {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("comptes.txt"))) {
            Object client;
            int i = 0;

            while (!((client = ois.readObject()) instanceof util.EndOfFile)) {
                clients.add((Client)client);
                i++;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        for (int k = 0; k < clients.size(); k++) {
            for(int j = 0; j < clients.get(k).getNbCompte(); j++) {
                if(nom.equals(clients.get(k).getNom()) && pin.equals(clients.get(k).getCompte(j).getPin()))  {
                    currentClient = k;
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