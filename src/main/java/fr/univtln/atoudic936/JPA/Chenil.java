package fr.univtln.atoudic936.JPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chenil {
    @Id
    @GeneratedValue
    @Column(name = "CHENIL_ID")
    private int id;
    @OneToMany(mappedBy = "chenil")
    private List<Chien> chiens = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Chien> getChiens() {
        return chiens;
    }

    public void setChiens(List<Chien> chiens) {
        this.chiens = chiens;
    }

    public Chenil() {
    }
}
