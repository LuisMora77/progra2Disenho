/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Usuario
 */
public class Lista extends Agregado{

    @Override
    public Iterador obtenerIterador() {
        return new IteradorConcreto(super.accidentes);
    }
}
