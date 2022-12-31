package guichetautomatique.visual;

import java.util.Scanner;

public class Login extends Visual {
    public Login() {
    }

    public void show() {
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

    public void content() {
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
    }
}
