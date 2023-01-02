package guichetautomatique.visual;

import guichetautomatique.Run;
import util.EndOfFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

        run.clients.get(run.currentClient).getCompte(run.currentCompte).deposer(montant);

        for(int i = 0; i < run.clients.size(); i++) {
            for(int j = 0; j < run.clients.get(i).getNbCompte(); j++) {
                if (nCompte == run.clients.get(i).getCompte(j).getCode()) {
                    run.clients.get(i).getCompte(j).deposer(montant);
                }
            }
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("comptes.txt"))) {

            for(int i = 0; i < run.clients.size(); i++) {
                oos.writeObject(run.clients.get(i));
            }
            oos.writeObject(new EndOfFile());

        }catch (Exception e) {
            e.printStackTrace();
        }

        content = this.formatDiv("g-----------------------------------------------------i\n");
        System.out.println(content);
    }


}
