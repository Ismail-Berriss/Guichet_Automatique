package guichetautomatique.visual;

import guichetautomatique.Run;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Solde extends Visual {

    // Constructors
    public Solde() {}

    public Solde(Run run) {
        this.run = run;
    }

    // Methods
    public void show() throws IOException, ClassNotFoundException {
        this.header();
        this.content();
    }

    public void header() {
        String header = "";
        header = header + this.formatDiv("a-----------------------------------------------------c\n");
        header = header + this.formatRow("|                       Solde                         |\n");
        header = header + this.formatDiv("d-----------------------------------------------------f\n");

        System.out.print(header);
    }

    public void content() throws IOException, ClassNotFoundException {

        String content = this.formatRow("|            Votre solde est :   " + run.clients.get(run.currentClient).getCompte(run.currentCompte).getSolde());
        System.out.print(content);

        content = this.formatDiv("\ng-----------------------------------------------------i\n");
        System.out.println(content);

        Scanner input = new Scanner(System.in);
        System.out.println("--- Press enter to return...");
        input.nextLine();
    }


}
