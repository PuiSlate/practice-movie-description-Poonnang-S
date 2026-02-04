package org.launchcode.movie_description.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movies {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double rating;
    @Column(length = 1000)
    private String description;

//constructor
    public Movies(String title, double rating, String description) {

        this.title = title;
        this.rating = rating;
        this.description = description;

    }

//    getter + setter
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title:'" + title + '\'' +
                ", rating:" + rating +
                ", description:'" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return id == movies.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
