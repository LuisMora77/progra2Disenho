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
public abstract class Iterador {
    protected ArrayList<ArrayList<String>> lista;
    
    public abstract int getCantOcurrencias(ArrayList<String> caracteristicas);
}
