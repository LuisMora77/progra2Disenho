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
public class DTO {
    private ArrayList<String> anhos;
    private ArrayList<String> meses;
    private ArrayList<String> dias;
    private ArrayList<String> provincias;
    private ArrayList<String> cantones;
    private ArrayList<String> distritos;
    private ArrayList<String> tipoAfectado;
    private ArrayList<String> edadQuinquenal;
    private ArrayList<String> sexo;
    private ArrayList<String> lesiones;
    private String indicador;

    public DTO(){
        this.anhos = new ArrayList();
        this.meses = new ArrayList();
        this.dias = new ArrayList();
        this.provincias = new ArrayList();
        this.cantones = new ArrayList();
        this.distritos = new ArrayList();
        this.tipoAfectado = new ArrayList();
        this.edadQuinquenal = new ArrayList();
        this.sexo = new ArrayList();
        this.lesiones = new ArrayList();
    }
    
    public ArrayList<String> getAnhos() {
        return anhos;
    }

    public void setAnhos(ArrayList<String> anhos) {
        this.anhos = anhos;
    }

    public ArrayList<String> getMeses() {
        return meses;
    }

    public void setMeses(ArrayList<String> meses) {
        this.meses = meses;
    }

    public ArrayList<String> getDias() {
        return dias;
    }

    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }

    public ArrayList<String> getProvincias() {
        return provincias;
    }

    public void setProvincias(ArrayList<String> provincias) {
        this.provincias = provincias;
    }

    public ArrayList<String> getCantones() {
        return cantones;
    }

    public void setCantones(ArrayList<String> cantones) {
        this.cantones = cantones;
    }

    public ArrayList<String> getDistritos() {
        return distritos;
    }

    public void setDistritos(ArrayList<String> distritos) {
        this.distritos = distritos;
    }

    public ArrayList<String> getTipoAfectado() {
        return tipoAfectado;
    }

    public void setTipoAfectado(ArrayList<String> tipoAfectado) {
        this.tipoAfectado = tipoAfectado;
    }

    public ArrayList<String> getEdadQuinquenal() {
        return edadQuinquenal;
    }

    public void setEdadQuinquenal(ArrayList<String> edadQuinquenal) {
        this.edadQuinquenal = edadQuinquenal;
    }

    public ArrayList<String> getSexo() {
        return sexo;
    }

    public void setSexo(ArrayList<String> sexo) {
        this.sexo = sexo;
    }

    public ArrayList<String> getLesiones() {
        return lesiones;
    }

    public void setLesiones(ArrayList<String> lesiones) {
        this.lesiones = lesiones;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
    
    
}
