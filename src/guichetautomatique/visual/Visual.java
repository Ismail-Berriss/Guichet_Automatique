package guichetautomatique.visual;

import java.io.IOException;

public abstract class Visual {
    public Boolean valide;

    public Visual() {
    }

    public abstract void show()  throws IOException, ClassNotFoundException;

    public abstract void header();

    public abstract void content() throws IOException, ClassNotFoundException;

    public String formatRow(String str) {
        return str.replace('|', '│');
    }

    public String formatDiv(String str) {
        return str.replace('a', '┌').replace('b', '┬').replace('c', '┐').replace('d', '├').replace('e', '┼').replace('f', '┤').replace('g', '└').replace('h', '┴').replace('i', '┘').replace('-', '─');
    }
}
