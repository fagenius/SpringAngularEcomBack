package com.company.entity;

public class TypeDeCompte {
    public Compte getTypeDeCompte(String typeCompte){
        if(typeCompte == null){
            return null;
        }
        if(typeCompte.equalsIgnoreCase("COMPTE_CHEQUE")){
            return new CompteCheque();
        }else if(typeCompte.equalsIgnoreCase("COMPTE_EPARGNE")){
            return new CompteEpargne();
        }
        return null;
    }

}
