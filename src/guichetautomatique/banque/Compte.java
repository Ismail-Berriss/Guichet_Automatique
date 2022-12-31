package guichetautomatique.banque;

import java.io.Serializable;

public class Compte implements Serializable {
    private static int nbCompte = 0;
    protected int code;
    protected double solde;
    protected Agence lAgence;
    protected Client proprietaire;

    public Compte() {
    }

    public Compte(double solde) {
        this.solde = solde;
        this.code = ++nbCompte;
    }

    public Compte(Client client, Agence agence) {
        this(50.0, client, agence);
    }

    public Compte(double solde, Client client, Agence agence) {
        this.code = ++nbCompte;
        this.solde = solde;
        this.proprietaire = client;
        this.lAgence = agence;
    }

    public void retirer(double montant) {
        if (montant < this.solde) {
            this.solde -= montant;
        }

    }

    public void deposer(double montant) {
        this.solde += montant;
    }

    public static int getNbCompte() {
        return nbCompte;
    }

    public static void setNbCompte(int nbCompte) {
        Compte.nbCompte = nbCompte;
    }

    public int getCode() {
        return this.code;
    }

    public double getSolde() {
        return this.solde;
    }

    public Agence getlAgence() {
        return this.lAgence;
    }

    public Client getProprietaire() {
        return this.proprietaire;
    }

    public String toString() {
        return "Compte{solde=" + this.solde + ", code=" + this.code + "}";
    }
}
