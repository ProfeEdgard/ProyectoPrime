/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import dao.EstadoDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Estado;

/**
 *
 * @author Edgard
 */
@Named(value = "estadoMB")
@SessionScoped
public class EstadoMB implements Serializable{

   private Estado estado= new Estado();
   private  ArrayList<Estado> estados;
   private String mensaje; 
    public EstadoMB() {
        mensaje="";
        listar();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }
    
    public void registrar(){
        EstadoDAO ed;
        try{
           ed = new EstadoDAO();
           int r = ed.registrar(estado);
           if(r>0){
            listar();
            mensaje = "Estado registrado";
            limpiar();
           }else{
               mensaje = "Estado no se pudo registrar";
           }
        }catch(SQLException e){
            mensaje = "Error: "+e.getMessage();
        }
    }
    public void modificar(){
        EstadoDAO ed;
        try{
            ed = new EstadoDAO();
            ed.modificar(estado);
            listar();
            mensaje = "Estado actualizado";
            limpiar();
        }catch(Exception e){
            
        }
    }
    public void eliminar(){
        EstadoDAO ed;
        try{
            ed = new EstadoDAO();
            ed.eliminar(estado);
            listar();
            mensaje = "Estado eliminado";
            limpiar();
        }catch(Exception e){
            
        }
    }
    private void listar(){
        EstadoDAO ed;
        try{
           ed = new EstadoDAO();
        estados = ed.obtenerEstados();
            }catch(Exception e){
                    
            }
    }
    private void limpiar(){
        estado.setId(0);
        estado.setNombre("");
    }
    public void obtenerEstado(Estado e){
        EstadoDAO ed;
        Estado temp;
        try{
            ed = new EstadoDAO();
            temp = ed.obtenerEstado(e.getId());
            if(temp!=null){
            this.estado = temp;
        }
        }catch(Exception ex){
            
        }
    }
    
}
