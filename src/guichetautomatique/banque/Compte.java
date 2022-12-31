package guichetautomatique.banque;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Compte implements Serializable {

    // Attributs
    private static final int NB_MAX_OPERATIONS = 100;

    private static int nbCompte = 0;

    protected String pin;
    protected int code;
    protected double solde;
    protected Agence lAgence;
    protected Client proprietaire;
    protected Operation[] operations;
    protected int nbOperations = 0;

    // Constructors
    public Compte() {
    }

    public Compte(double solde) {
        this.solde = solde;
        this.code = ++nbCompte;
        this.pin = generatePIN();
        operations = new Operation[NB_MAX_OPERATIONS];
    }

    public Compte(Client client, Agence agence) {
        this(50.0, client, agence);
    }

    public Compte(double solde, Client client, Agence agence) {
        this.code = ++nbCompte;
        this.solde = solde;
        this.proprietaire = client;
        this.lAgence = agence;
        this.pin = generatePIN();
        operations = new Operation[NB_MAX_OPERATIONS];
    }

    // Methods
    public void retirer(double montant) {
        if (montant < this.solde) {
            this.solde -= montant;
        }
    }

    public void deposer(double montant) {
        this.solde += montant;
    }

    public void addOperation(double montant, String type, LocalDate date) {
        operations[nbOperations++] = new Operation(montant, type, date);
    }

    private String generatePIN() {
        Random random = new Random();

        int code = random.nextInt(10000);

        String formattedCode = String.format("%04d", code);

        return formattedCode;
    }


    // Getters and Setters
    public static int getNbCompte() {
        return nbCompte;
    }

    public static void setNbCompte(int nbCompte) {
        Compte.nbCompte = nbCompte;
    }

    public int getCode() {
        return this.code;
    }

    public String getPin() {
        return pin;
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

    public Operation getOperation(int i) {
        return operations[i];
    }

    public Operation[] getOperations() {
        return operations;
    }

    public int getNbOperations() {
        return nbOperations;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "pin='" + pin + '\'' +
                ", code=" + code +
                ", solde=" + solde +
                ", operations=" + Arrays.toString(operations) +
                ", nbOperations=" + nbOperations +
                '}';
    }
}
