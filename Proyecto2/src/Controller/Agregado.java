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
public abstract class Agregado {
    protected ArrayList<ArrayList<String>> accidentes;
    
    public abstract Iterador obtenerIterador();
}
