package guichetautomatique.visual;

import guichetautomatique.Run;

import java.io.IOException;

public abstract class Visual {

    // Attributs
    public Boolean valide;
    protected Run run;

    // Constructors
    public Visual() {
    }

    // Methods
    public abstract void show()  throws IOException, ClassNotFoundException;

    public abstract void header();

    public abstract void content() throws IOException, ClassNotFoundException;

    public String formatRow(String str) {
        return str.replace('|', '│');
    }

    public String formatDiv(String str) {
        return str.replace('a', '┌')
                .replace('b', '┬')
                .replace('c', '┐')
                .replace('d', '├')
                .replace('e', '┼')
                .replace('f', '┤')
                .replace('g', '└')
                .replace('h', '┴')
                .replace('i', '┘')
                .replace('-', '─');
    }
}
