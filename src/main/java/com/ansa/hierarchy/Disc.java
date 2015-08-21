package com.ansa.hierarchy;


import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "disc_type")
@Entity
@NamedQuery(name = "Disc.getAll", query = "select p from Disc p")
public class Disc {

    @Id
    @GeneratedValue
    Long id;

    String name;
    int price;

    public Disc(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Disc() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
