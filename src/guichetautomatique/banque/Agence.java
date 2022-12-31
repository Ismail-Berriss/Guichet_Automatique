package guichetautomatique.banque;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class Agence implements Serializable {
    public static final int NB_MAX_COMPTES = 50;
    public static final int NB_MAX_CLIENTS = 30;
    public static final int NB_MAX_EMPLOYES = 6;
    private int numAgence;
    private String adresse;
    private Employe directeur;
    private Employe[] employes;
    private Client[] lesClients;
    private int nbComptes = 0;
    private int nbClients = 0;
    private int nbEmployes = 0;
    private static int nbAgences = 0;

    public Agence(String adresse) {
        this.numAgence = ++nbAgences;
        this.adresse = adresse;
        this.lesClients = new Client[30];
        this.employes = new Employe[6];
    }

    public void addClient(Client c) {
        if (this.nbClients < 30) {
            this.lesClients[this.nbClients] = c;
            Random random = new Random();
            int i = random.nextInt(this.employes.length);
            this.lesClients[this.nbClients++].setConseiller(this.employes[i]);
        } else {
            System.out.println("Vous avez atteindre le nombre max du clients que vous pouvez avoir");
        }

    }

    public void addDirecteur(Employe d) {
        this.directeur = d;
    }

    public void addEmploye(Employe e) {
        if (this.nbEmployes < 6) {
            this.employes[this.nbEmployes++] = e;
        } else {
            System.out.println("Vous avez atteindre le nombre max des employes que vous pouvez avoir");
        }

    }

    public int getNumAgence() {
        return this.numAgence;
    }

    public void setNumAgence(int numAgence) {
        this.numAgence = numAgence;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Client getClient(int n) {
        return this.lesClients[n];
    }

    public static int getNbAgences() {
        return nbAgences;
    }

    public int getNbClients() {
        return this.nbClients;
    }

    public String toString() {
        int var10000 = this.numAgence;
        return "Agence{numAgence=" + var10000 + ", adresse='" + this.adresse + "', lesClients=" + Arrays.toString(this.lesClients) + "}";
    }
}
