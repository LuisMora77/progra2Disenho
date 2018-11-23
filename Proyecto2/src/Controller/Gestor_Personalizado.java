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
public class Gestor_Personalizado {
    private Gestor_DAO gDao;
    private Agregado lista;
    private Grafico grafico;
    
    public Gestor_Personalizado(){
        this.gDao = new Gestor_DAO();
        this.grafico = new Grafico();
    }
    
    private void solicitarDatos(){
        //obtiene todos los accidentes que han ocurrido, con el fin de luego filtrarlos para poder generar el grafico deseado
        this.lista = new Lista(this.gDao.obtenerTodosLosDatos());
    }
    
    public void actualizarGrafico(DTO dto){
        //en el DTO viene el año, provincia, rol(tipoAfectado) y tipo de lesión
        this.solicitarDatos();
        Iterador it = this.lista.obtenerIterador();
        ArrayList<String> datos = new ArrayList();
        boolean banderaAnho, banderaProv, banderaAfectado, banderaLesion = false;
        banderaAnho = verificarSonTodas(dto.getAnhos());
        banderaProv = verificarSonTodas(dto.getProvincias());
        banderaAfectado = verificarSonTodas(dto.getTipoAfectado());
        banderaLesion = verificarSonTodas(dto.getLesiones());

        //<editor-fold defaultstate="collapsed" desc="Crear los datos para el gráfico">
        if (banderaAnho && banderaProv && banderaAfectado && banderaLesion){
            //si se piden los datos de todo, se presentaran por rol y lesion
            DTO dtoNuevo = new DTO();
            this.gDao.obtenerCatalogos(dtoNuevo);
            for (int k=0; k<dtoNuevo.getTipoAfectado().size(); k++){
                for (int l=0; l<dtoNuevo.getLesiones().size(); l++){
                    //se usa el iterador para revisar cuales de los accidentes cumplen con cada juego de características
                    ArrayList<String> caracteristica = new ArrayList();
                    caracteristica.add(dtoNuevo.getTipoAfectado().get(k));
                    caracteristica.add(dtoNuevo.getLesiones().get(l));
                    int ocurrencias = it.getCantOcurrencias(caracteristica);
                    datos.add(caracteristica.get(0)+" - "+caracteristica.get(1)+":" +ocurrencias);
                }
            }
            this.crearGrafico(datos);
        } else {
            //construiremos la lista de caracteristicas a utilizar en base a los datos cuyo filtro no es "Todas"
            ArrayList<ArrayList<String>> caracteristicas = new ArrayList();
            if (!banderaAnho){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getAnhos());
            }
            if (!banderaProv){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getProvincias());
            }
            if (!banderaAfectado){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getTipoAfectado());
            }
            if (!banderaLesion){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getLesiones());
            }
            
            for (int i=0; i<caracteristicas.size(); i++){
                int ocurrencias = it.getCantOcurrencias(caracteristicas.get(i));
                if (ocurrencias!=0){
                    String str = "";
                    for(int j=0; j<caracteristicas.get(i).size(); j++){
                        if (j!=0)
                            str += "-";
                        str += caracteristicas.get(i).get(j);
                    }
                    datos.add(str + ":" + ocurrencias);
                }
            }
        }
        //</editor-fold>
        
        this.crearGrafico(datos);
    }
    
    private void crearGrafico(ArrayList<String> datos){
        this.grafico.crearGrafico(datos);
    }
    
    //funciones auxiliares
    private boolean verificarSonTodas(ArrayList<String> solicitados){
        for(int i=0; i<solicitados.size(); i++){
            if(solicitados.get(i).equalsIgnoreCase("Todas"))
                return true;
        }
        return false;
    }
    private ArrayList<ArrayList<String>> creadorCaracteristicas(ArrayList<ArrayList<String>> caract, ArrayList<String> filtroaAgregar){
        ArrayList<ArrayList<String>> nuevasCaracteristicas = new ArrayList();
        if(caract.size()==0){
            //si no existen listas de carcateristicas, debemos crear una para cada dato de la entrada
            for(int i=0; i<filtroaAgregar.size(); i++){
                ArrayList<String> caracteristica = new ArrayList();
                caracteristica.add(filtroaAgregar.get(i));
                nuevasCaracteristicas.add(caracteristica);
            }
        } else {
            //si ya existen listas de caracteristicas, debemos
            for (int i=0; i<caract.size(); i++){
                ArrayList<String> c = caract.get(i);
                for(int j=0; j<filtroaAgregar.size(); j++){
                    ArrayList<String> caracteristica = (ArrayList) c.clone();
                    caracteristica.add(filtroaAgregar.get(j));
                    nuevasCaracteristicas.add(caracteristica);
                }
            }
        }
        return nuevasCaracteristicas;
    }
}
