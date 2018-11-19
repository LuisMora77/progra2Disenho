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
public class Lista extends Agregado{

    public Lista(ArrayList<ArrayList<String>> accidentes){
        super.accidentes = accidentes;
    }
    @Override
    public Iterador obtenerIterador() {
        return new IteradorConcreto(super.accidentes);
    }
}
