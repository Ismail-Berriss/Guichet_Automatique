package guichetautomatique.banque;

import com.sun.source.doctree.SerialDataTree;

import java.io.Serializable;
import java.time.LocalDate;

public class Operation implements Serializable {

    // Attributs
    private double montant;
    private String type;
    private LocalDate date;

    // Constructors
    public Operation(double montant, String type, LocalDate date) {
        this.montant = montant;
        this.type = type;
        this.date = date;
    }

    // Getters and Setters
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Operation{" +
                "montant=" + montant +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
