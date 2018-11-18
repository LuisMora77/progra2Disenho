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
        super.lista = lista;
    }

    @Override
    public int getCantOcurrencias(ArrayList<String> caracteristicas) {
        //obtener el numero de ocurrencias en la lista
        return 0;
    }
    
}
