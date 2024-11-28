package com.parkauto.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="VEHICULE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDVEHICULE")
    private Long matricule;

    @Column(name = "ANNEEMODEL")
    private int anneeModel;

    @Column(name = "PRIX")
    private double prix;

    public Long getMatricule() {
        return matricule;
    }

    public void setMatricule(Long matricule) {
        this.matricule = matricule;
    }

    public int getAnneeModel() {
        return anneeModel;
    }

    public void setAnneeModel(int anneeModel) {
        this.anneeModel = anneeModel;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Vehicule() {
        super();
    }

    public Vehicule(Long matricule, int anneeModel, double prix) {
        super();
        this.matricule = matricule;
        this.anneeModel = anneeModel;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Vehicule [matricule=" + matricule + ", anneeModel=" + anneeModel + ", prix=" + prix + "]";
    }

    public String demarrer() {
        return "Brouuuuuuummmm!";
        }

    public String accelerer() {
        return "Vrouuuuuuummmm!";
    }

}