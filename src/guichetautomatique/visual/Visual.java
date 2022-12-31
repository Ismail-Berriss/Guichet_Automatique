package guichetautomatique.visual;

public abstract class Visual {
    public Visual() {
    }

    public abstract void show();

    public abstract void header();

    public abstract void content();

    public String formatRow(String str) {
        return str.replace('|', '│');
    }

    public String formatDiv(String str) {
        return str.replace('a', '┌').replace('b', '┬').replace('c', '┐').replace('d', '├').replace('e', '┼').replace('f', '┤').replace('g', '└').replace('h', '┴').replace('i', '┘').replace('-', '─');
    }
}
