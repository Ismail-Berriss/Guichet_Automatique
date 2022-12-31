package guichetautomatique.visual;

import guichetautomatique.Run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Virement extends Visual {

    // Constructors
    public Virement() {}

    public Virement(Run run) {
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
        header = header + this.formatRow("|                    VIREMENT                         |\n");
        header = header + this.formatDiv("d-----------------------------------------------------f\n");

        System.out.print(header);
    }

    public void content() throws IOException, ClassNotFoundException {
        Scanner clavier = new Scanner(System.in);

        String content = this.formatRow("|         Numéro de compte :   ");
        System.out.print(content);
        int nCompte  = clavier.nextInt();
        content = this.formatRow("|         Montant :   ");
        System.out.print(content);
        double montant = clavier.nextDouble();
        content = this.formatRow("|         Motif :   ");
        System.out.print(content);
        String motif = clavier.nextLine();

        run.clients[run.currentClient].getCompte(run.currentCompte).deposer(montant);

        for(int i = 0; i < run.clients.length; i++) {
            for(int j = 0; j < run.clients[i].getNbCompte(); j++) {
                if (nCompte == run.clients[i].getCompte(j).getCode()) {
                    run.clients[i].getCompte(j).deposer(montant);
                }
            }
        }

        LocalDate currentDate = LocalDate.now();

        run.clients[run.currentClient].getCompte(run.currentCompte).addOperation(montant, "depot", currentDate);

        FileOutputStream f1 = new FileOutputStream("comptes");
        ObjectOutputStream o = new ObjectOutputStream(f1);

        o.writeObject(run.clients);

        o.close(); f1.close();

        content = this.formatDiv("g-----------------------------------------------------i\n");
        System.out.println(content);
    }


}