/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoPerfil;
/**
 *
 * @author visitante
 */
 /*Creado por María José Véliz Ochoa 9959-21-5909 */

public class clsPerfil {
    private String IdPerfil;
    private String NombrePerfil;
    private String Direccion;
    private String Telefono;
    private String Email;
    private String EstatusPerfil;

    public clsPerfil() {
    }

    public clsPerfil(String IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public clsPerfil(String NombrePerfil, String EstatusPerfil) {
        this.NombrePerfil = NombrePerfil;
        this.EstatusPerfil = EstatusPerfil;
    }

    public clsPerfil(String IdPerfil, String NombrePerfil, String EstatusPerfil) {
        this.IdPerfil = IdPerfil;
        this.NombrePerfil = NombrePerfil;
        this.EstatusPerfil = EstatusPerfil;
    }

    public String getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(String IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public String getNombrePerfil() {
        return NombrePerfil;
    }

    public void setNombrePerfil(String NombrePerfil) {
        this.NombrePerfil = NombrePerfil;
    }

    public String getEstatusPerfil() {
        return EstatusPerfil;
    }

    public void setEstatusPerfil(String EstatusPerfil) {
        this.EstatusPerfil = EstatusPerfil;
    }
    
        public String getDireccionAlumno() {
        return Direccion;
    }

    public void setDireccionAlumno(String Direccion) {
        this.Direccion = Direccion;
    }
    
        public String getTelefonoAlumno() {
        return Telefono;
    }

    public void setTelefonoAlumno(String Telefono) {
        this.Telefono = Telefono;
    }
    
        public String getEmailAlumno() {
        return Email;
    }

    public void setEmailAlumno(String Email) {
        this.Email = Email;
    }

    
    @Override
    public String toString() {
        return "clsAlumnos{" + "IdPerfil=" + IdPerfil + ", NombrePerfi=" + NombrePerfil + ", DireccionAlumno=" + Direccion + ", TelefonoAlumno=" + Telefono +", EmailAlumno=" + Email +", EstatusPerfil=" + EstatusPerfil +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsPerfil getBuscarInformacionPerfilPorNombre(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.consultaPerfilPorNombre(perfil);
    }
    public clsPerfil getBuscarInformacionPerfilPorId(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.consultaPerfilPorId(perfil);
    }    
    public List<clsPerfil> getListadoPerfiles()
    {
        daoPerfil daoperfil = new daoPerfil();
        List<clsPerfil> listadoPerfiles = daoperfil.consultaPerfil();
        return listadoPerfiles;
    }
    public int setBorrarPerfil(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.borrarPerfil(perfil);
    }          
    public int setIngresarPerfil(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.ingresaPerfil(perfil);
    }              
    public int setModificarPerfil(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.actualizaPerfil(perfil);
    }              
}
