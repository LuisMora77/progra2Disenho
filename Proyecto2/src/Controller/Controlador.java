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
        //solicita todos los datos de los catalogos
        this.gDao.obtenerCatalogos(dto);
    }
    
    public void filtrarDatos(DTO dto){
        //filtra los datos de un catalogo segun los actualmente seleccionados
        this.gDao.filtrarDatos(dto);
    }
    
    public void solicitarMapa(DTO dto){
        //solicita la ventana del mapa
        this.gMapa.generarMapa(dto);
    }
    
    public void solicitarIndicador(DTO dto){
        //solicita el gráfico de un indicador
        this.gIndicador.generarGrafico(dto);
    }
    
    public void update(DTO dto){
        //actualiza/regenera el gráfico
        this.gPersonalizado.actualizarGrafico(dto);
    }
}
