/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controlador;

/**
 *
 * @author Usuario
 */
public abstract class Sujeto {
    protected Controlador observador;
    
    public void asignarObservador(Controlador observador){
        this.observador = observador;
    }
    
    public abstract void notificar();
}
