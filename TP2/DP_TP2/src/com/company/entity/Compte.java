package com.company.entity;

public abstract class Compte {
    protected double solde;
    protected double interet;

    public abstract void getSolde();
    public abstract void getInteret();

    public void retirer(int montant, String typeDeCompte){
        double initSolde = solde+interet;
        if((montant > initSolde || (!typeDeCompte.equals("COMPTE_EPARGNE") && !typeDeCompte.equals("COMPTE_CHEQUE")))){
            System.out.println("Montant trop élevé ou type de compte invalide!!!");
        }else{
            if(typeDeCompte.equals("COMPTE_EPARGNE")){
                montant = montant+200;
                if(montant>initSolde){
                    System.out.println("Montant trop élevé");
                }else{
                    System.out.println("Vous êtes sur le pont d'effectuer \n un retrait sur votre compte : "+typeDeCompte);
                    System.out.println("Solde initial : "+initSolde);
                    System.out.println("Montant du retrait : "+montant);
                    solde = initSolde - montant;
                    System.out.print("Solde après retrait : "+solde);
                }
            }else if(typeDeCompte.equals("COMPTE_CHEQUE")){
                montant = montant+100;
                if(montant>initSolde){
                    System.out.print("Montant trop élevé");
                }else{
                    System.out.println("Vous êtes sur le pont d'effectuer \n un retrait sur votre compte : "+typeDeCompte);
                    System.out.println("Solde initial : "+initSolde);
                    System.out.println("Montant du ajout : "+montant);
                    solde = initSolde - montant;
                    System.out.print("Solde après retrait : "+solde);
                }
            }

        }
    }

    public void ajouter(int montant, String typeDeCompte){
        System.out.println("Vous êtes sur le pointe de créditer \n votre comptre : "+typeDeCompte);
        System.out.println("Solde initiale : "+solde);
        System.out.println("Montant à rajouter : "+montant);
        solde = solde + montant;
        System.out.print("Solde après retrait : "+solde);
    }

}
