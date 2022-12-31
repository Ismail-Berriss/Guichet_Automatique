package guichetautomatique.visual;

import guichetautomatique.Run;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Login extends Visual {

    // Constructors
    public Login() {}

    public Login(Run run) {
        this.run = run;
    }

    // Methods
    public void show()  throws IOException, ClassNotFoundException {
        this.header();
        this.content();
    }

    public void header() {
        String header = "";
        header = header + this.formatDiv("a-----------------------------------------------------c\n");
        header = header + this.formatRow("|                BIENVENUE CHER CLIENT                |\n");
        header = header + this.formatDiv("g-----------------------------------------------------i\n");

        System.out.print(header);
    }

    public void content()  throws IOException, ClassNotFoundException {
        Scanner clavier = new Scanner(System.in);

        String content = this.formatDiv("a-----------------------------------------------------c\n");
        System.out.print(content);

        content = this.formatDiv("|            NOM DE FAMILLE :   ");
        System.out.print(content);
        String nom = clavier.nextLine();

        content = this.formatDiv("|            PIN :   ");
        System.out.print(content);
        String pin = clavier.nextLine();

        content = this.formatDiv("g-----------------------------------------------------i\n");

        System.out.println(content);

        this.valide = run.verify(nom, pin);

    }
}