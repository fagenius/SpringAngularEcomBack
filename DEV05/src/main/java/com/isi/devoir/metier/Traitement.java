package com.isi.devoir.metier;

import com.isi.devoir.model.Impot;
import org.springframework.stereotype.Service;

@Service
public class Traitement {
    public void calcule(Impot impot)
    {
        String status = impot.getStatus();
        int nbrEnfant = impot.getNbrEnfant();
        int nbrEpouse = impot.getNbrEpouse();

        double NbParts=0.0;

        if(status.equalsIgnoreCase("C")){
            if(nbrEnfant==0){
                NbParts=1;
            }
        }else if(status.equalsIgnoreCase("M")){
            if(nbrEnfant==0){
                NbParts=(nbrEpouse*0.5)+1;
            }else if (nbrEnfant>0){
                NbParts=(nbrEpouse*0.5)+(nbrEnfant*0.5)+1.5;
            }
        }
        if(NbParts>5){
            NbParts = 5;
        }

        impot.setNbrPart(NbParts);
    }
}
