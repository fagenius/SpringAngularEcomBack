package com.isi.devoir.model;

import java.io.Serializable;

public class Impot implements Serializable {
    private String status;
    private int nbrEnfant;
    private int nbrEpouse;
    private double nbrPart;

    public Impot()
    {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    public int getNbrEpouse() {
        return nbrEpouse;
    }

    public void setNbrEpouse(int nbrEpouse) {
        this.nbrEpouse = nbrEpouse;
    }

    public double getNbrPart() {
        return nbrPart;
    }

    public void setNbrPart(double nbrPart) {
        this.nbrPart = nbrPart;
    }
}
