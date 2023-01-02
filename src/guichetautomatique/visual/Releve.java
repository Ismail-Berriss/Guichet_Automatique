package guichetautomatique.visual;

import guichetautomatique.Run;

import java.sql.SQLOutput;


public class Releve extends Visual {

    public Releve() {
    }

    public Releve(Run run) {
        this.run = run;
    }

    public void show() {
        this.header();
        this.content();
    }

    public void header() {
        String header = "";
        header = header + this.formatDiv("a-------------------------------------------------------c\n");
        header = header + this.formatRow("|                    RELEVE BANCAIRE                    |\n");
        header = header + this.formatDiv("d-------------------------------------------------------f\n");
        System.out.print(header);
    }

    public void content() {
        
        for(int i = 0; i < run.clients.get(run.currentClient).getCompte(run.currentCompte).getOperations().size(); ++i) {
            if (run.clients.get(run.currentClient).getCompte(run.currentCompte).getOperation(i) != null) {
                String str1 = String.format("| %-55s |",run.clients.get(run.currentClient).getCompte(run.currentCompte).getOperation(i));
                System.out.println(this.formatRow(str1));
            }
        }


        String content = this.formatDiv("g-----------------------------------------------------i\n");
        System.out.println(content);
    }

}
