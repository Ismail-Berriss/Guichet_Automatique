package guichetautomatique.banque;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GestionBanque {
    public static final int NB_CLIENTS = 4;

    public GestionBanque() {
    }

    public static void main(String[] args) throws IOException {
        Banque banque = new Banque("CIH", 2.0E8, "Agadir");
        Agence agence1 = new Agence("N 20 Rue Nassim, Hay Dakhla, Agadir");
        Agence agence2 = new Agence("N 2 Rue Nahda, Dcheira Jihadia, Inezgane");
        banque.addAgence(agence1);
        banque.addAgence(agence2);
        Client[] LesClient = new Client[]{new Client("BERRISS", "Ismail", "Inezgane", agence2), new Client("CHHOU", "Anass", "Inezgane", agence2), new Client("BOUHEDDA", "Hind", "Agadir", agence1), new Client("LACHHAB", "Hamza", "Agadir", agence1)};
        LesClient[0].addCompte(new CompteEpargne(5000.0));
        LesClient[1].addCompte(new ComptePayant(500.0));
        LesClient[2].addCompte(new ComptePayant(3500.0));
        LesClient[2].addCompte(new ComptePayant(9800.0));
        LesClient[3].addCompte(new CompteEpargne(2300.0));
        LesClient[3].addCompte(new ComptePayant(4300.0));
        FileOutputStream f1 = new FileOutputStream("comptes");
        ObjectOutputStream o = new ObjectOutputStream(f1);
        o.writeObject(LesClient);
        o.close();
        f1.close();
        if (LesClient[0].getCompte(0) != null) {
            LesClient[0].getCompte(0).deposer(500.0);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        if (LesClient[2].getCompte(1) != null) {
            LesClient[2].getCompte(1).retirer(100.0);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        int i;
        for(i = 0; i < LesClient.length; ++i) {
            if (LesClient[i].getAdresse().equals("Agadir")) {
                agence1.addClient(LesClient[i]);
            } else if (LesClient[i].getAdresse().equals("Inezgane")) {
                agence2.addClient(LesClient[i]);
            }
        }

        int j;
        int k;
        for(i = 0; i < Banque.getNbAgences(); ++i) {
            for(j = 0; j < banque.getAgence(i).getNbClients(); ++j) {
                for(k = 0; k < banque.getAgence(i).getClient(j).getNbCompte(); ++k) {
                    if (banque.getAgence(i).getClient(j).getCompte(k) instanceof CompteEpargne) {
                        ((CompteEpargne)banque.getAgence(i).getClient(j).getCompte(k)).calculInteret();
                    }
                }
            }
        }

        System.out.println("--- Liste des differents clients avec leurs differents comptes ---");

        for(i = 0; i < Banque.getNbAgences(); ++i) {
            for(j = 0; j < banque.getAgence(i).getNbClients(); ++j) {
                System.out.println(banque.getAgence(i).getClient(i).toString());
            }
        }

        System.out.println("\n--- Liste des comptes d'epargne de l'agence ---");

        for(i = 0; i < Banque.getNbAgences(); ++i) {
            for(j = 0; j < banque.getAgence(i).getNbClients(); ++j) {
                for(k = 0; k < banque.getAgence(i).getClient(j).getNbCompte(); ++k) {
                    if (banque.getAgence(i).getClient(j).getCompte(k) instanceof CompteEpargne) {
                        System.out.println(banque.getAgence(i).getClient(j).getCompte(k).toString());
                    }
                }
            }
        }

        System.out.println("\n--- Liste des comptes payants de l'agence ---");

        for(i = 0; i < Banque.getNbAgences(); ++i) {
            for(j = 0; j < banque.getAgence(i).getNbClients(); ++j) {
                for(k = 0; k < banque.getAgence(i).getClient(j).getNbCompte(); ++k) {
                    if (banque.getAgence(i).getClient(j).getCompte(k) instanceof ComptePayant) {
                        System.out.println(banque.getAgence(i).getClient(j).getCompte(k).toString());
                    }
                }
            }
        }

    }
}
