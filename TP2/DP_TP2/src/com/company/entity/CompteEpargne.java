package com.company.entity;

public class CompteEpargne extends Compte{
    @Override
    public void getSolde() {
        solde = 250000;
        System.out.println("#######--- MONTANT DU SOLDE ---#######");
        System.out.println(solde);
        System.out.println("#########-_-__-_-_-_-_-_-_-_-_#########");
    }

    @Override
    public void getInteret() {
        interet = solde + (solde*0.01);
        solde = solde+interet;
        System.out.println("######--- MONTANT DE VOTRE INTERET ---#######");
        System.out.println(interet);
        System.out.println("######------- -------#######");
        System.out.println("######--- MONTANT DU SOLDE AVEC INTERET ---#######");
        System.out.println(solde);
        System.out.println("######------- -------#######");
    }
}
