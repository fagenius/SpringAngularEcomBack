package com.company.entity;

public class CompteCheque extends Compte{
    @Override
    public void getSolde() {
        solde = 4000000;
        System.out.println("#######--- MONTANT DU SOLDE ---#######");
        System.out.println(solde);
        System.out.println("#########-_-__-_-_-_-_-_-_-_-_#########");
    }

    @Override
    public void getInteret() {
        if(solde>100000){
            interet = solde + (solde*0.02);
            solde = solde+interet;
            System.out.println("######--- MONTANT DE VOTRE INTERET ---#######");
            System.out.println(interet);
            System.out.println("######------- -------#######");
            System.out.println("######--- MONTANT DU SOLDE AVEC INTERET ---#######");
            System.out.println(solde);
            System.out.println("######------- -------#######");
        }else{
            System.out.println("XXXXXXXX--- VOTRE SOLDE EST INFERIEUR A 100000 ---XXXXXXXX");
            System.out.println("Votre solde est toujours à : "+solde);
            System.out.println("XXXXXXXX------------------------XXXXXXXX");
        }
    }
}
