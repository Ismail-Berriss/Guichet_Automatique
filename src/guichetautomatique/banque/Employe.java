package guichetautomatique.banque;

public class Employe {
    private String nom;
    private String prenom;
    private String dateEmbauche;
    private static int nbEmploye = 0;

    public Employe(String nom, String prenom, String dateEmbauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        ++nbEmploye;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateEmbauche() {
        return this.dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public static int getNbEmploye() {
        return nbEmploye;
    }
}
