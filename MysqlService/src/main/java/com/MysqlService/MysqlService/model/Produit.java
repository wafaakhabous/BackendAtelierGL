package com.MysqlService.MysqlService.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produit")
    private Long id;

    @Column(name = "nom_produit")
    private String name;

    @Column(name = "prix_produit")
    private double price;

    @Column(name = "description_produit")
    private String description;

    @Column(name = "image_produit")
    private String image;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "nom_categorie")
    private String nom_categorie;

    @Column(name = "date_ajout")
    private LocalDate date_ajout;
    //constructeurs, getters et setters


    public Produit(Long id, String name, double price, String description, String image, int quantite, String nom_categorie, LocalDate date_ajout) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.quantite = quantite;
        this.nom_categorie = nom_categorie;
        this.date_ajout = date_ajout;
    }


    public LocalDate getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(LocalDate date_ajout) {
        this.date_ajout = date_ajout;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getnom_categorie() {
        return nom_categorie;
    }

    public void setnom_categorie(String  nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

   

    public Produit() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
