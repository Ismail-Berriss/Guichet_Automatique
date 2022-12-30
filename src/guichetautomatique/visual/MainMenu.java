package guichetautomatique.visual;


public class MainMenu extends Visual {


    public void header() {

        String header = "";
        header += formatDiv("a------------------------------------c\n");
        header += formatRow("|         BIENVENUE M. ....          |\n");
        header += formatDiv("d------------------------------------f\n");
        System.out.print(header);

    }

    public void content() {

        String[] contenu = {"Retrait", "Dépôt", "Virement", "Solde", "Relevé Bancaire", "Quitter"};

        for (int i = 0; i < 6; i++)
        {
            //int y = primeEquation(x);
            String str1 = String.format("| %3d.  %-28s |", i + 1, contenu[i]);
            System.out.println(formatRow(str1));
        }

        System.out.println(formatDiv("g------------------------------------i"));

        System.out.print("          Votre Choix : ");

    }

}
