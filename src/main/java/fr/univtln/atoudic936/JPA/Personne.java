package fr.univtln.atoudic936.JPA;

import javax.persistence.*;

@Entity
public class Personne {
    @Id
    @GeneratedValue
    @Column(name = "PERSONNE_ID")
    private int ident;
    private String nom;
    private String prenom;
    private int age;
    @OneToOne(mappedBy = "proprio")
    private Chien chien;

    public Personne() {
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Personne(String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "ident=" + ident +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }
}
