package edu.unbosque.FourPawsCitizens_LazarusAES_25.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pet")
public class Pet {
    @Id
    @Column(name = "pet_id", nullable = false)
    private Integer pet_id;

    @Column(name = "microship", nullable = false,unique = true)
    private String microship;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "picture", nullable = false)
    private String picture;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Owner owner_id;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Case> cases = new ArrayList<>();

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<>();

    public Pet(){

    }

    public Pet(Integer pet_id, String microship, String name, String species, String race, String size, String sex, String picture, Owner owner_id, List<Case> cases, List<Visit> visits) {
        this.pet_id = pet_id;
        this.microship = microship;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.owner_id = owner_id;
        this.cases = cases;
        this.visits = visits;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public String getMicroship() {
        return microship;
    }

    public void setMicroship(String microship) {
        this.microship = microship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Owner getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Owner owner_id) {
        this.owner_id = owner_id;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void addCases(Case aCase) {
        cases.add(aCase);
        aCase.setPet_id(this);

    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void addVisits(Visit visit) {
        visits.add(visit);
        visit.setPet(this);
    }
}
