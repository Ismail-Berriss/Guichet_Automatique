package guichetautomatique.visual;


import guichetautomatique.Run;

import java.io.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Retrait extends Visual {

    // Constructors
    public Retrait() {}

    public Retrait(Run run) {
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
        header = header + this.formatRow("|                      Retrait                        |\n");
        header = header + this.formatDiv("d-----------------------------------------------------f\n");

        System.out.print(header);
    }

    public void content() throws IOException, ClassNotFoundException {
        Scanner clavier = new Scanner(System.in);

        String content = this.formatRow("|            Montant :   ");
        System.out.print(content);
        double montant = clavier.nextDouble();

        run.clients[run.currentClient].getCompte(run.currentCompte).retirer(montant);

        LocalDate currentDate = LocalDate.now();

        run.clients[run.currentClient].getCompte(run.currentCompte).addOperation(montant, "retrait", currentDate);

        FileOutputStream f1 = new FileOutputStream("comptes");
        ObjectOutputStream o = new ObjectOutputStream(f1);

        o.writeObject(run.clients);

        o.close(); f1.close();

        content = this.formatDiv("g-----------------------------------------------------i\n");
        System.out.println(content);
    }

}
