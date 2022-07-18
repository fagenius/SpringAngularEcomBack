package com.test.TestDevoir.domaines;

import java.io.Serializable;

public class Pret implements Serializable {
    private double mpret;
    private double tia;
    private int na;
    private double mmens;
    private double mglobal;

    public Pret()
    {

    }
    public double getMpret() {
        return mpret;
    }

    public void setMpret(double mpret) {
        this.mpret = mpret;
    }

    public double getTia() {
        return tia;
    }

    public void setTia(double tia) {
        this.tia = tia;
    }

    public int getNa() {
        return na;
    }

    public void setNa(int na) {
        this.na = na;
    }

    public double getMmens() {
        return mmens;
    }

    public void setMmens(double mmens) {
        this.mmens = mmens;
    }

    public double getMglobal() {
        return mglobal;
    }

    public void setMglobal(double mglobal) {
        this.mglobal = mglobal;
    }
}
