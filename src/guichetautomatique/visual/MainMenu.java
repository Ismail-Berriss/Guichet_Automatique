package guichetautomatique.visual;

import guichetautomatique.Run;

public class MainMenu extends Visual {
    public MainMenu() {
    }

    public MainMenu(Run run) {
        this.run = run;
    }

    public void show() {
        this.header();
        this.content();
    }

    public void header() {
        String header = "";
        header = header + this.formatDiv("a------------------------------------c\n");
        header = header + this.formatRow("|         BIENVENUE  " + run.clients[run.currentClient].getNom());
        header = header + this.formatDiv("\nd------------------------------------f\n");
        System.out.print(header);
    }

    public void content() {
        String[] contenu = new String[]{"Retrait", "Dépôt", "Virement", "Solde", "Relevé Bancaire", "Quitter"};

        for(int i = 0; i < 6; ++i) {
            String str1 = String.format("| %3d.  %-28s |", i + 1, contenu[i]);
            System.out.println(this.formatRow(str1));
        }

        System.out.println(this.formatDiv("g------------------------------------i"));
        System.out.print("          Votre Choix : ");
    }
}
