package org.launchcode.movie_description.models;

import jakarta.persistence.*;



@Entity
@Table(name = "movies")
public class Movie {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int rating;
    @Column(length = 1000)
    private String description;

    public Movie() {
    }

//constructor
    public Movie(String title, int rating, String description) {

        this.title = title;
        this.rating = rating;
        this.description = description;

    }

//    getter + setter


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }


}
