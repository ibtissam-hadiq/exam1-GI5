package org.example.Entities;

public class CD {
    private Long id;
    private String titre;
    private String genre;
    private boolean disponible;
    private boolean isDisponible = true;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
