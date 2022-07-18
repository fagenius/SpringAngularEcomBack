package com.company;

import com.company.entity.Compte;
import com.company.entity.TypeDeCompte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        TypeDeCompte typeDeCompte = new TypeDeCompte();

        System.out.print("Enter votre type de compte : ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String typeCpt=br.readLine();

        System.out.println("Faite votre choix: ");
        System.out.println("Consulter solde : 1");
        System.out.println("Dépôt : 2");
        System.out.println("Retrait : 3");
        System.out.println("Votre etaux d'intêret : 4");
        int choix=Integer.parseInt(br.readLine());
        switch (choix){
            case 1:
                Compte compte = typeDeCompte.getTypeDeCompte(typeCpt);
                compte.getSolde();
                break;
            case 2:
                Compte compte1 = typeDeCompte.getTypeDeCompte(typeCpt);
                System.out.println("Entrer le montant à déposer");
                int montantDepot = Integer.parseInt(br.readLine());
                compte1.getSolde();
                compte1.ajouter(montantDepot,typeCpt);
                break;
            case 3:
                Compte compte2 = typeDeCompte.getTypeDeCompte(typeCpt);
                System.out.println("Entrer le montant à retirer");
                int montantRetrait = Integer.parseInt(br.readLine());
                compte2.getSolde();
                compte2.retirer(montantRetrait,typeCpt);
                break;
            case 4:
                Compte compte3 = typeDeCompte.getTypeDeCompte((typeCpt));
                compte3.getSolde();
                compte3.getInteret();
                break;
        }



        //System.out.println("Le solde de votre comptre "+typeCpt+"\nEt votre taux d'intêret est de : "+);
    }
}
