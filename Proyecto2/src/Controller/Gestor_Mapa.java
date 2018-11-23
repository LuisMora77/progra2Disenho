/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mapa;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Gestor_Mapa {
    private Gestor_DAO gDao;
    private Agregado lista;
    private Mapa mapa;
    
    public Gestor_Mapa(){
        this.gDao = new Gestor_DAO();
        this.mapa = new Mapa();
    }
    
    private void solicitarDatos(){
        //obtiene todos los accidentes que han ocurrido, con el fin de luego filtrarlos para poder generar el grafico deseado
        this.lista = new Lista(this.gDao.obtenerTodosLosDatos());
    }
    
    private void crearMapa(ArrayList<String> datos){
        this.mapa.crearMapa(datos);
    }
    
    public void generarMapa(DTO dto){
        this.solicitarDatos();
        Iterador it = this.lista.obtenerIterador();
        ArrayList<String> datos = new ArrayList();
        ArrayList<String> ubicaciones = new ArrayList();
        String tipoUbic;
        
        boolean banderaAnho, banderaMes, banderaDia, banderaProv, banderaCanton, banderaDist, banderaAfectado, banderaEdadQ, banderaSexo, banderaLesion;
        banderaAnho = verificarSonTodas(dto.getAnhos());
        banderaMes = verificarSonTodas(dto.getMeses());
        banderaDia = verificarSonTodas(dto.getDias());
        banderaProv = verificarSonTodas(dto.getProvincias());
        banderaCanton = verificarSonTodas(dto.getCantones());
        banderaDist = verificarSonTodas(dto.getDistritos());
        banderaAfectado = verificarSonTodas(dto.getTipoAfectado());
        banderaEdadQ = verificarSonTodas(dto.getEdadQuinquenal());
        banderaSexo = verificarSonTodas(dto.getSexo());
        banderaLesion = verificarSonTodas(dto.getLesiones());
        
        //<editor-fold defaultstate="collapsed" desc="Crear los datos para el mapita">
        if (banderaAnho && banderaMes && banderaDia && banderaProv && banderaAfectado && banderaEdadQ && banderaSexo && banderaLesion){
            //si se piden los datos de todo, se presentaran por rol y lesion
            DTO dtoNuevo = new DTO();
            this.gDao.obtenerCatalogos(dtoNuevo);
            for (int k=0; k<dtoNuevo.getProvincias().size(); k++){
                //se usa el iterador para revisar cuales de los accidentes cumplen con cada juego de características
                ArrayList<String> caracteristica = new ArrayList();
                caracteristica.add(dtoNuevo.getTipoAfectado().get(k));
                int ocurrencias = it.getCantOcurrencias(caracteristica);
//                //agregar la linea que solicita las coordenadas de una tabla segun el nombre correspondiente
                datos.add(caracteristica.get(0)+":" +ocurrencias);
            }
            this.crearMapa(datos);
        }
        
        else {
            //construiremos la lista de caracteristicas a utilizar en base a los datos cuyo filtro no es "Todas"
            ArrayList<ArrayList<String>> caracteristicas = new ArrayList();
            if (!banderaProv){
                if (dto.getProvincias().size()!=1){
                    caracteristicas = creadorCaracteristicas(caracteristicas, dto.getProvincias());
                    ubicaciones = dto.getProvincias();
                    tipoUbic = "Provincias";
                } else {
                    caracteristicas = creadorCaracteristicas(caracteristicas, dto.getProvincias());
                    if (!banderaCanton){
                        if (dto.getCantones().size()!=1){
                            caracteristicas = creadorCaracteristicas(caracteristicas, dto.getCantones());
                            ubicaciones = dto.getCantones();
                            tipoUbic = "Cantones";
                        } else {
                            caracteristicas = creadorCaracteristicas(caracteristicas, dto.getCantones());
                            if(!banderaDist){
                                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getDistritos());
                                ubicaciones = dto.getDistritos();
                                tipoUbic = "Distritos";
                            }
                            else {
                                DTO dtoNuevo = new DTO();
                                this.gDao.obtenerCatalogos(dtoNuevo);
                                ubicaciones = dtoNuevo.getDistritos();
                                tipoUbic = "Distritos";
                                caracteristicas = creadorCaracteristicas(caracteristicas, dtoNuevo.getDistritos());
                            }
                        }
                    } else {
                        DTO dtoNuevo = new DTO();
                        this.gDao.obtenerCatalogos(dtoNuevo);
                        ubicaciones = dtoNuevo.getCantones();
                        tipoUbic = "Cantones";
                        caracteristicas = creadorCaracteristicas(caracteristicas, dtoNuevo.getCantones());
                    }
                }
            } else {
                //en caso de que sí se deseen todas las provincias pero con algunos datos filtrados
                DTO dtoNuevo = new DTO();
                this.gDao.obtenerCatalogos(dtoNuevo);
                ubicaciones = dtoNuevo.getProvincias();
                tipoUbic = "Provincias";
                caracteristicas = creadorCaracteristicas(caracteristicas, dtoNuevo.getProvincias());
            }
            
            
            if (!banderaAnho){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getAnhos());
            }
            if (!banderaMes){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getMeses());
            }
            if (!banderaDia){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getDias());
            }          
            if (!banderaAfectado){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getTipoAfectado());
            }
            if (!banderaEdadQ){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getEdadQuinquenal());
            }
            if (!banderaSexo){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getSexo());
            }
            if (!banderaLesion){
                caracteristicas = creadorCaracteristicas(caracteristicas, dto.getLesiones());
            }
            
            //esto lo aplica por filtros, hay que filtrar los resultados a las ubicaciones
            for (int i=0; i<caracteristicas.size(); i++){
                int ocurrencias = it.getCantOcurrencias(caracteristicas.get(i));
                caracteristicas.get(i).add(String.valueOf(ocurrencias));
            }
            
            //ahora es necesario agrupar por ubicación
            if (tipoUbic.equalsIgnoreCase("Provincias")){
                for(int i=0; i<ubicaciones.size(); i++){
                    String ubic = ubicaciones.get(i);
                    String coordenadas = this.gDao.obtenerCoordenadas("Provincias", ubic);
                    int ocurrencias = 0;
                    for (int j=0; j<caracteristicas.size(); j++){
                        ArrayList<String> caract = caracteristicas.get(j);
                        if (caract.get(0).equalsIgnoreCase(ubic))
                            ocurrencias += Integer.valueOf(caract.get(caract.size()-1));
                    }
                    datos.add(coordenadas+":"+ubic+":"+ocurrencias);
                }
            } else if (tipoUbic.equalsIgnoreCase("Cantones")){
                for(int i=0; i<ubicaciones.size(); i++){
                    String ubic = ubicaciones.get(i);
                    String coordenadas = this.gDao.obtenerCoordenadas("Cantones", ubic);
                    int ocurrencias = 0;
                    for (int j=0; j<caracteristicas.size(); j++){
                        ArrayList<String> caract = caracteristicas.get(j);
                        if (caract.get(1).equalsIgnoreCase(ubic))
                            ocurrencias += Integer.valueOf(caract.get(caract.size()-1));
                    }
                    datos.add(coordenadas+":"+ubic+":"+ocurrencias);
                }
            } else {
                //distritos
                for(int i=0; i<ubicaciones.size(); i++){
                    String ubic = ubicaciones.get(i);
                    String coordenadas = this.gDao.obtenerCoordenadas("Distritos", ubic);
                    int ocurrencias = 0;
                    for (int j=0; j<caracteristicas.size(); j++){
                        ArrayList<String> caract = caracteristicas.get(j);
                        if (caract.get(1).equalsIgnoreCase(ubic))
                            ocurrencias += Integer.valueOf(caract.get(caract.size()-1));
                    }
                    datos.add(coordenadas+":"+ubic+":"+ocurrencias);
                }
            }
        }
        //</editor-fold>
        
        //longitud,latitud,nombre y número
        this.mapa.crearMapa(datos);
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
