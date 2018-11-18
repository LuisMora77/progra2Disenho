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
public class Controlador {
    private Gestor_DAO gDao;
    private Gestor_Mapa gMapa;
    private Gestor_Indicador gIndicador;
    private Gestor_Personalizado gPersonalizado;

    public Controlador(){
        this.gDao = new Gestor_DAO();
        this.gMapa = new Gestor_Mapa();
        this.gIndicador = new Gestor_Indicador();
        this.gPersonalizado = new Gestor_Personalizado();
    }
    
    public void solicitarDatos(DTO dto){
        
    }
    
    public void filtrarDatos(DTO dto){
        
    }
    
    public void solicitarMapa(DTO dto){
        
    }
    
    public void solicitarIndicador(DTO dto){
        
    }
    
    public void update(DTO dto){
        
    }
}
