/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Grafico;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Gestor_Indicador {
    private Gestor_DAO gDao;
    private Agregado lista;
    private Grafico grafico;
    
    public Gestor_Indicador(){
        this.gDao = new Gestor_DAO();
        this.grafico = new Grafico();
    }
    
    private void solicitarDatos(){
        //obtiene todos los accidentes que han ocurrido, con el fin de luego filtrarlos para poder generar el grafico deseado
        this.lista = new Lista(this.gDao.obtenerTodosLosDatos());
    }
    
    private void crearGrafico(ArrayList<String> datos){
        this.grafico.crearGrafico(datos);
    }
    
    public void generarGrafico(DTO dto){
        this.solicitarDatos();
        this.gDao.obtenerCatalogos(dto);
        ArrayList<String> indicadorDatos = new ArrayList();
        //<editor-fold defaultstate="collapsed" desc="Obtención de los datos del Indicador">
        switch(dto.getIndicador()){
            case "Anhos":
                indicadorDatos = dto.getAnhos();
                break;
            case "Meses":
                indicadorDatos = dto.getMeses();
                break;
            case "Dias":
                indicadorDatos = dto.getDias();
                break;
            case "Provincias":
                indicadorDatos = dto.getProvincias();
                break;
            case "Cantones":
                indicadorDatos = dto.getCantones();
                break;
            case "Distritos":
                indicadorDatos = dto.getDistritos();
                break;
            case "TipoAfectado":
                indicadorDatos = dto.getTipoAfectado();
                break;
            case "EdadQuinquenal":
                indicadorDatos = dto.getEdadQuinquenal();
                break;
            case "Sexo":
                indicadorDatos = dto.getSexo();
                break;
            case "Lesiones":
                indicadorDatos = dto.getLesiones();
                break;
            default:
                System.out.println("Error de indicador");
                break;
        }
        //</editor-fold>
        
        for (int i=0; i<indicadorDatos.size(); i++){
            ArrayList<String> caracteristica = new ArrayList();
            caracteristica.add(indicadorDatos.get(i));
            int ocurrencias = this.lista.obtenerIterador().getCantOcurrencias(caracteristica);
            indicadorDatos.set(i, indicadorDatos.get(i)+":"+ocurrencias);
        }
        
        this.grafico.crearGrafico(indicadorDatos);
    }
}
