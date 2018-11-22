/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author Monserrath
 */
public class DTO_Controlador {
    private ArrayList<String> provincia;
    private ArrayList<String> cantones;
    private ArrayList<String> distritos;
    private ArrayList<String> lesion;
    private ArrayList<String> edades;
    private ArrayList<String> anho;
    private ArrayList<String> sexo;

    public DTO_Controlador() {
    }

    public ArrayList<String> getProvincia() {
        return provincia;
    }

    public ArrayList<String> getCantones() {
        return cantones;
    }

    public ArrayList<String> getDistritos() {
        return distritos;
    }

    public ArrayList<String> getLesion() {
        return lesion;
    }

    public ArrayList<String> getEdades() {
        return edades;
    }

    public ArrayList<String> getAnho() {
        return anho;
    }

    public ArrayList<String> getSexo() {
        return sexo;
    }

    public void setProvincia(ArrayList<String> provincia) {
        this.provincia = provincia;
    }

    public void setCantones(ArrayList<String> cantones) {
        this.cantones = cantones;
    }

    public void setDistritos(ArrayList<String> distritos) {
        this.distritos = distritos;
    }

    public void setLesion(ArrayList<String> lesion) {
        this.lesion = lesion;
    }

    public void setEdades(ArrayList<String> edades) {
        this.edades = edades;
    }

    public void setAnho(ArrayList<String> anho) {
        this.anho = anho;
    }

    public void setSexo(ArrayList<String> sexo) {
        this.sexo = sexo;
    }
    
    
}
