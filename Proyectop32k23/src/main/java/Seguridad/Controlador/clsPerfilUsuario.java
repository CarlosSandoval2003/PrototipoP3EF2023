/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoPerfilUsuario;
import Seguridad.Vista.frmMantenimientoPerfilUsuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author visitante
 */
 /*Creado por María José Véliz Ochoa 9959-21-5909 */

public class clsPerfilUsuario {
    

    public clsPerfilUsuario() {
    }


    public ArrayList<String> obtenerNombresUsuarios() {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerNombresUsuarios();
    }

    public ArrayList<String> obtenerNombreCarrera() {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerNombreCarrera();
    }
    
        public ArrayList<String> obtenerNombreSede() {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerNombreSede();
    }
        
            public ArrayList<String> obtenerNombreJornada() {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerNombreJornada();
    }
            
                public ArrayList<String> obtenerNombreSeccion() {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerNombreSeccion();
    }
                
                    public ArrayList<String> obtenerNombreAula() {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerNombreAula();
    }

    public void cargarTabla(DefaultTableModel modelo) {
        daoPerfilUsuario dao = new daoPerfilUsuario();
        dao.cargarTabla(modelo);
    }

    public ArrayList<String> obtenerPerfilesUsuario(String usuario) {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerPerfilesUsuario(usuario);
}

public void eliminarPerfilesUsuario(DefaultTableModel modelo, String usuario) {
        daoPerfilUsuario dao = new daoPerfilUsuario();
        dao.eliminarPerfilesUsuario(modelo, usuario);
    }
public void asignarunPerfilesUsuario(String pernombre, String usuario, String carrera, String sede, String jornada, String seccion, String aula) {
        daoPerfilUsuario dao = new daoPerfilUsuario();
      dao.asignarunPerfilesUsuario(pernombre, usuario, carrera, sede, jornada, seccion, aula);
    }

public void asignartodoPerfilesUsuario(DefaultTableModel modelo, String usuario, String carrera, String sede, String jornada, String seccion, String aula, float nota) {
        daoPerfilUsuario dao = new daoPerfilUsuario();
        dao.asignartodoPerfilesUsuario(modelo, usuario, carrera, sede, jornada, seccion, aula, nota);
    }

   public void eliminarunPerfilesUsuario(String pernombre, String usuario) {
        daoPerfilUsuario dao = new daoPerfilUsuario();
      dao.eliminarunPerfilesUsuario(pernombre, usuario);
    }

   


     

}
