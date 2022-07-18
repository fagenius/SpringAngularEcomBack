package com.test.TestDevoir.metiers;

import com.test.TestDevoir.domaines.Pret;
import org.springframework.stereotype.Service;

@Service
public class Traitement {
    public void calcule(Pret pret)
    {
        double mpret=pret.getMpret();
        double tia=pret.getTia();
        int na=pret.getNa();

        double tim=tia/1200;
        double mens=(mpret*tim)/(1-(1/Math.pow(1+tim,12*na)));
        double global=12*na*mens;
        pret.setMmens(mens);
        pret.setMglobal(global);
    }
}
