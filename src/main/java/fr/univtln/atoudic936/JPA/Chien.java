package fr.univtln.atoudic936.JPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chien {
    @Id
    @GeneratedValue
    @Column(name = "CHIEN_ID")
    private int id;
    private String nom;
    @OneToOne
    @JoinColumn(name = "PROPRIO_ID")
    private Personne proprio;
    @ManyToOne
    @JoinColumn(name = "CHENIL_ID")
    private Chenil chenil;
    @ManyToMany()
    @JoinTable(name = "CHIEN_PATHOLOGIE",
            joinColumns = {@JoinColumn(name = "CHIEN_ID") },
            inverseJoinColumns = {@JoinColumn(name = "PATHOLOGIE_NAME")})
    private List<Pathologie> pathologies = new ArrayList<>();

    public Chien() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personne getProprio() {
        return proprio;
    }

    public void setProprio(Personne proprio) {
        this.proprio = proprio;
    }

    public Chenil getChenil() {
        return chenil;
    }

    public void setChenil(Chenil chenil) {
        this.chenil = chenil;
    }

    public List<Pathologie> getPathologies() {
        return pathologies;
    }

    public void setPathologies(List<Pathologie> pathologies) {
        this.pathologies = pathologies;
    }

    public void addPathologie(Pathologie p){
        pathologies.add(p);
    }

    @Override
    public String toString() {
        return "Chien{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", proprio=" + proprio +
                ", chenil=" + chenil +
                ", pathologies=" + pathologies +
                '}';
    }
}
