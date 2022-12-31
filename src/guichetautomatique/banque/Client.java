package guichetautomatique.banque;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class Client implements Serializable {
    public final int NB_MAX_COMPTE = 4;
    private String pin = this.generatePIN();
    private int code;
    private final String nom;
    private final String prenom;
    private String adresse;
    private Agence monAgence;
    private Compte[] mesComptes;
    private Employe conseiller;
    private int nbCompte = 0;
    private static int nbClient = 0;

    public Client(String nom, String prenom, String adresse, Agence agence) {
        this.code = ++nbClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.monAgence = agence;
        this.mesComptes = new Compte[4];
    }

    private String generatePIN() {
        Random random = new Random();
        int code = random.nextInt(10000);
        String formattedCode = String.format("%04d", code);
        return formattedCode;
    }

    public void addCompte(Compte c) {
        if (this.nbCompte < 4) {
            this.mesComptes[this.nbCompte++] = c;
        } else {
            System.out.println("Vous avez atteindre le nombre max du comptes que vous pouvez avoir");
        }

    }

    public void deposer(int nCompte, double montant) {
        this.mesComptes[nCompte].deposer(montant);
    }

    public void retirer(int nCompte, double montant) {
        this.mesComptes[nCompte].retirer(montant);
    }

    public Compte getCompte(int n) {
        return this.mesComptes[n];
    }

    public int getCode() {
        return this.code;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
    }

    public Agence getMonAgence() {
        return this.monAgence;
    }

    public void setMonAgence(Agence monAgence) {
        this.monAgence = monAgence;
    }

    public int getNbCompte() {
        return this.nbCompte;
    }

    public static int getNbClient() {
        return nbClient;
    }

    public Employe getConseiller() {
        return this.conseiller;
    }

    public void setConseiller(Employe conseiller) {
        this.conseiller = conseiller;
    }

    @Override
    public String toString() {
        return "Client{" +
                "pin='" + pin + '\'' +
                ", code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mesComptes=" + Arrays.toString(mesComptes) +
                ", conseiller=" + conseiller +
                ", nbCompte=" + nbCompte +
                '}';
    }
}
