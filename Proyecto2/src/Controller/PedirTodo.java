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
public class PedirTodo extends Peticion{

    private String querryBase;

    public PedirTodo() {
        this.querryBase = "";       //definir el querry de Select * from table
    }
    
    @Override
    public String obtenerQuerry() {
        return querryBase;
    }
    
}
