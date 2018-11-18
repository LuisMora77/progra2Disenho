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
public class PedirFiltrado extends Peticion{
    private String filtro;
    private Peticion peticion;
    
    @Override
    public String obtenerQuerry() {
        //se debe eliminar el ; del final y si Peticion es de tipo PedirFiltrado, no agregar el where
        //PedirTodo - ; + where Provincia = Heredia + and Provincia = Alajuela + and ... + ;
        return null;
    }
    
}
