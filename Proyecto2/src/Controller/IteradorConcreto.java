/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class IteradorConcreto extends Iterador{

    public IteradorConcreto(ArrayList<ArrayList<String>> lista){
        this.lista = lista;
    }

    @Override
    public int getCantOcurrencias(ArrayList<String> caracteristicas) {
        int ocurrencias = 0;
        
        for(int i=0; i<this.lista.size(); i++){
            ArrayList<String> accidente = this.lista.get(i);
            boolean resultado = contiene(accidente,caracteristicas);
            if(resultado)
                ocurrencias++;
        }
        
        return ocurrencias;
    }
    
    private boolean contiene(ArrayList<String> accidente, ArrayList<String> caract){
        outer:
        for (int i=0; i<caract.size(); i++) {
            String a = caract.get(i);
            for (int j=0; j<accidente.size(); j++) {
                String b = accidente.get(j);
                if (a.equalsIgnoreCase(b)) {
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }
}
