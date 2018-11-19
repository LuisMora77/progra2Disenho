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
public class Gestor_DAO {
    private DAO dao;
    
    public Gestor_DAO(){
        this.dao = new DAO();
    }
    
    public void obtenerCatalogos(DTO dto){
        //obtiene los datos de los catálogos
        Peticion solicitud = new PedirTodo("Anhos");
        dto.setAnhos(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("Meses");
        dto.setMeses(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("Dias");
        dto.setDias(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("Provincias");
        dto.setProvincias(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("Cantones");
        dto.setCantones(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("Distritos");
        dto.setDistritos(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("TipoAfectado");
        dto.setTipoAfectado(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("EdadQuinquenal");
        dto.setEdadQuinquenal(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("Sexo");
        dto.setSexo(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
        
        solicitud = new PedirTodo("Lesiones");
        dto.setLesiones(dao.ejecutarQuerry(solicitud.obtenerQuerry()).get(0));
    }
    
    public ArrayList<ArrayList<String>> obtenerTodosLosDatos(){
        //obtiene todos los datos de la tabla general
        Peticion solicitud = new PedirTodo("Tabla");        //Esto debe ser de la tabla en la que están los datos
        ArrayList<ArrayList<String>> datos = this.dao.ejecutarQuerry(solicitud.obtenerQuerry());
        return datos;
    }
    
    public void filtrarDatos(DTO dto){
        //filtra los catalogos según los que hay en el DTO
        if(dto.getCantones().size() == 0){
            //no hay cantones seleccionados, hay que filtrarlos
            if(dto.getProvincias().size() == 1){
                //seleccionar los cantones pertenecientes a una unica provincia
                Peticion solicitud = new PedirTodo("Provincias");
                solicitud = new PedirFiltrado(dto.getProvincias().get(0),solicitud);
                ArrayList<ArrayList<String>> datos = this.dao.ejecutarQuerry(solicitud.obtenerQuerry());
                dto.setCantones(datos.get(0));
            } else if (dto.getProvincias().size() >= 2){
                //desactivar los cantones y distritos por ser varias provincias
                dto.setCantones(null);
                dto.setDistritos(null);
            }
        } else  if(dto.getCantones().size() == 1){
            //seleccionar los distritos  pertenecientes a un unico canton
            Peticion solicitud = new PedirTodo("Cantones");
            solicitud = new PedirFiltrado(dto.getCantones().get(0),solicitud);
            ArrayList<ArrayList<String>> datos = this.dao.ejecutarQuerry(solicitud.obtenerQuerry());
            dto.setDistritos(datos.get(0));
        } else {
            dto.setDistritos(null);
        }
    }
    
    public int obtenerTotal(){
        Peticion solicitud = new PedirTodo("Tabla");        //Esto debe ser de la tabla en la que están los datos
        ArrayList<ArrayList<String>> datos = this.dao.ejecutarQuerry(solicitud.obtenerQuerry());
        int total = datos.size();
        return total;
    }
}
