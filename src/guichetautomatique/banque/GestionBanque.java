package guichetautomatique.banque;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GestionBanque {
    public static final int NB_CLIENTS = 4;

    public static void main(String[] args) throws IOException {

        // Création de la banque
        Banque banque = new Banque("CIH", 2.0E8, "Agadir");

        // Création des agences
        Agence agence1 = new Agence("N 20 Rue Nassim, Hay Dakhla, Agadir");
        Agence agence2 = new Agence("N 2 Rue Nahda, Dcheira Jihadia, Inezgane");

        // Création des directeur
        Employe directeur1 = new Employe("Abid", "Ayoub", "21/03/2019");
        Employe directeur2 = new Employe("Tioussi", "Karam", "21/03/2019");

        // Ajout des directeurs
        agence1.addDirecteur(directeur1);
        agence1.addDirecteur(directeur2);

        // Création des Employés
        Employe e1 = new Employe("e1", "e1", "21/03/2019");
        Employe e2 = new Employe("e2", "e2", "21/03/2019");
        Employe e3 = new Employe("e3", "e3", "21/03/2019");
        Employe e4 = new Employe("e4", "e4", "21/03/2019");
        Employe e5 = new Employe("e5", "e5", "2/05/2019");

        // Ajout des employés
        agence1.addEmploye(e1);
        agence1.addEmploye(e2);
        agence1.addEmploye(e3);

        agence2.addEmploye(e4);
        agence2.addEmploye(e5);

        // Ajout des agences
        banque.addAgence(agence1);
        banque.addAgence(agence2);

        // Création des clients et leurs comptes
        Client[] LesClient = new Client[NB_CLIENTS];

        LesClient[0] = new Client("BERRISS", "Ismail", "Inezgane", agence2);
        LesClient[1] = new Client("CHHOU", "Anass", "Inezgane", agence2);
        LesClient[2] = new Client("BOUHEDDA", "Hind", "Agadir", agence1);
        LesClient[3] = new Client("LACHHAB", "Hamza", "Agadir", agence1);

        // Client 1
        LesClient[0].addCompte(new CompteEpargne(5000));
        // Client 2
        LesClient[1].addCompte(new ComptePayant(500));
        // Client 3
        LesClient[2].addCompte(new ComptePayant(3500));
        LesClient[2].addCompte(new ComptePayant(9800));
        // Client 4
        LesClient[3].addCompte(new CompteEpargne(2300));
        LesClient[3].addCompte(new ComptePayant(4300));

        // Sérialisation
        FileOutputStream f1 = new FileOutputStream("comptes");
        ObjectOutputStream o = new ObjectOutputStream(f1);

        o.writeObject(LesClient);

        o.close(); f1.close();

        // Deposer de l'argent
        if (LesClient[0].getCompte(0) != null) {
            LesClient[0].getCompte(0).deposer(500.0);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        // Retirer de l'argent
        if (LesClient[2].getCompte(1) != null) {
            LesClient[2].getCompte(1).retirer(100.0);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        // Ajout des clients à leurs agences
        for(int i = 0; i < LesClient.length; ++i) {
            if (LesClient[i].getAdresse().equals("Agadir")) {
                agence1.addClient(LesClient[i]);
            } else if (LesClient[i].getAdresse().equals("Inezgane")) {
                agence2.addClient(LesClient[i]);
            }
        }

        // Application de la méthode calculInteret() sur tous les comptes d'épargne
        for(int i = 0; i < Banque.getNbAgences(); ++i) {
            for(int j = 0; j < banque.getAgence(i).getNbClients(); ++j) {
                for(int k = 0; k < banque.getAgence(i).getClient(j).getNbCompte(); ++k) {
                    if (banque.getAgence(i).getClient(j).getCompte(k) instanceof CompteEpargne) {
                        ((CompteEpargne)banque.getAgence(i).getClient(j).getCompte(k)).calculInteret();
                    }
                }
            }
        }

        /*** Affichage ***/

        // Affichage des agences

        System.out.println("--- Affichages des agences ---");

        for(int i = 0; i < Banque.getNbAgences(); i ++) {
            System.out.println(banque.getAgence(i).toString());
        }

        // Liste des différents clients avec leurs différents comptes

        System.out.println("\n--- Liste des differents clients avec leurs differents comptes ---");

        for(int i = 0; i < Banque.getNbAgences(); ++i) {
            for(int j = 0; j < banque.getAgence(i).getNbClients(); ++j) {
                System.out.println(banque.getAgence(i).getClient(j).toString());
            }
        }

        // Liste des comptes d'épargne de l'agence

        System.out.println("\n--- Liste des comptes d'epargne de l'agence ---");

        for(int i = 0; i < Banque.getNbAgences(); ++i) {
            for(int j = 0; j < banque.getAgence(i).getNbClients(); ++j) {
                for(int k = 0; k < banque.getAgence(i).getClient(j).getNbCompte(); ++k) {
                    if (banque.getAgence(i).getClient(j).getCompte(k) instanceof CompteEpargne) {
                        System.out.println(banque.getAgence(i).getClient(j).getCompte(k).toString());
                    }
                }
            }
        }

        // Liste des comptes payants de l'agence

        System.out.println("\n--- Liste des comptes payants de l'agence ---");

        for(int i = 0; i < Banque.getNbAgences(); ++i) {
            for(int j = 0; j < banque.getAgence(i).getNbClients(); ++j) {
                for(int k = 0; k < banque.getAgence(i).getClient(j).getNbCompte(); ++k) {
                    if (banque.getAgence(i).getClient(j).getCompte(k) instanceof ComptePayant) {
                        System.out.println(banque.getAgence(i).getClient(j).getCompte(k).toString());
                    }
                }
            }
        }

    }
}
