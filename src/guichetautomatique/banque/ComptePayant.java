package guichetautomatique.banque;

import java.io.Serializable;

public class ComptePayant extends Compte implements Serializable {
    private final double TAUX_OPERATION = 5.0;
    public final String typeCompteP = "ComptePayant";

    public ComptePayant(double solde) {
        super(solde);
    }

    public ComptePayant(Client client, Agence agence) {
        super(client, agence);
    }

    public ComptePayant(double solde, Client client, Agence agence) {
        super(solde, client, agence);
    }

    public void retirer(double mt) {
        super.retirer(mt + 5.0);
    }

    public void deposer(double mt) {
        super.deposer(mt - 5.0);
    }

    public String getTypeCompteP() {
        return "ComptePayant";
    }

    public String toString() {
        double var10000 = super.getSolde();
        return "ComptePayant{solde=" + var10000 + ", code=" + super.getCode() + "}";
    }
}
