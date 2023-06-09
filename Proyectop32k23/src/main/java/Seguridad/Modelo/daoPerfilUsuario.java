/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Meyglin del Rosario Rosales Ochoa Carne: 9959-21-4490
package Seguridad.Modelo;

import Seguridad.Controlador.clsPerfilUsuario;
import Seguridad.Vista.frmMantenimientoPerfilUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author visitante
 */


//Conexion de tablas y combo Box a base de datos trabajado por Carlos Sandoval
public class daoPerfilUsuario {
    String usuariobd = "root";
    String contrabd = "";
    public ArrayList<String> obtenerNombresUsuarios() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT nombre_alumno FROM alumnos";
        ResultSet rs = stmt.executeQuery(sql);

        // 4. Recuperar los resultados
        while (rs.next()) {
            // 5. Agregar los elementos al ArrayList
            nombresUsuarios.add(rs.getString("nombre_alumno"));
        }

        // 6. Cerrar la conexión
        rs.close();
        stmt.close();
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return nombresUsuarios;
}
    
public void cargarTabla(DefaultTableModel modelo) {
    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT nombre_curso FROM cursos";
        ResultSet rs = stmt.executeQuery(sql);

        // 5. Recuperar los resultados y agregarlos al modelo de datos
        while (rs.next()) {
            Object[] fila = new Object[1];
            fila[0] = rs.getString("nombre_curso");
            modelo.addRow(fila);
        }

        // 6. Cerrar la conexión
        rs.close();
        stmt.close();
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


public ArrayList<String> obtenerPerfilesUsuario(String usuario) {
    ArrayList<String> perfilesUsuario = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Obtener el usuid del usuario seleccionado en el combo box
        String sql = "SELECT carnet_alumno FROM alumnos WHERE nombre_alumno='" + usuario + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("carnet_alumno");

        // 4. Ejecutar la consulta SQL para obtener los perfiles asociados al usuario
        sql = "SELECT nombre_curso FROM asignacioncursosalumnos pu INNER JOIN cursos p ON pu.codigo_curso=p.codigo_curso WHERE pu.carnet_alumno=" + usuid;
        rs = stmt.executeQuery(sql);

        // 5. Recuperar los resultados
        while (rs.next()) {
            perfilesUsuario.add(rs.getString("nombre_curso"));
        }

        // 6. Cerrar la conexión
        rs.close();
        stmt.close();
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return perfilesUsuario;
}
 //Boton Asignar todo trabajado por Meyglin del Rosario Rosales Ochoa 
public  void asignartodoPerfilesUsuario(DefaultTableModel modelo, String usuario) {
    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Obtener el usuario seleccionado en el combo box

        // 3. Obtener el usuid del usuario seleccionado en el combo box
        String sql = "SELECT carnet_alumno FROM alumnos WHERE nombre_alumno='" + usuario + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("carnet_alumno");

        // 4. Recorrer los perfiles disponibles en la tabla jTable1
        
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            String pernombre = modelo.getValueAt(i, 0).toString();

            // 5. Obtener el perid del perfil
            sql = "SELECT codigo_curso FROM cursos WHERE curso_nombre='" + pernombre + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            int perid = rs.getInt("codigo_curso");

            // 6. Insertar el registro en tbl_perfilusuario
            sql = "INSERT INTO asignacioncursosalumnos (codigo_curso, carnet_alumno) VALUES (" + perid + ", " + usuid + ")";
            stmt.executeUpdate(sql);
        }

        // 7. Cerrar la conexión y actualizar la tabla jTable2
        rs.close();
        stmt.close();
        con.close();
 

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
   
};




 //Boton Eliminar todo trabajado por Carlos Sandoval
public  void eliminarPerfilesUsuario(DefaultTableModel modelo, String usuario) {
    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Obtener el usuid del usuario seleccionado en el combo box
        String sql = "SELECT carnet_alumno FROM alumnos WHERE nombre_alumno='" + usuario + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("carnet_alumno");

        // 4. Recorrer la tabla 2 y eliminar los perfiles asociados al usuario
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String pernombre = modelo.getValueAt(i, 0).toString();
            sql = "SELECT codigo_curso FROM cursos WHERE nombre_curso='" + pernombre + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            int perid = rs.getInt("codigo_curso");
            sql = "DELETE FROM asignacioncursosalumnos WHERE carnet_alumno=" + usuid + " AND codigo_curso=" + perid;
            stmt.executeUpdate(sql);
        }

        // 5. Cerrar la conexión
        rs.close();
        stmt.close();
        con.close();

        // 6. Actualizar la tabla 2


    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

 //Boton Asignar un perfil, trabajado por María José Véliz Ochoa
public  void asignarunPerfilesUsuario(String pernombre, String usuario) {   
            
            try {
               // Conectar a la base de datos
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);
                
                 // 2. Crear el objeto Statement
                PreparedStatement stmt = con.prepareStatement("SELECT codigo_curso FROM cursos WHERE nombre_curso=?");
                stmt.setString(1, pernombre);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                int perid = rs.getInt("codigo_curso");
                
                // Obtener el usuid del usuario seleccionado en el combo box
                stmt = con.prepareStatement("SELECT carnet_alumno FROM alumnos WHERE nombre_alumno=?");
                stmt.setString(1, usuario);
                rs = stmt.executeQuery();
                rs.next();
                int usuid = rs.getInt("carnet_alumno");
                
                // Insertar el nuevo registro en tbl_perfilusuario
                stmt = con.prepareStatement("INSERT INTO asignacioncursosalumnos (codigo_curso, carnet_alumno) VALUES (?, ?)");
                stmt.setInt(1, perid);
                stmt.setInt(2, usuid);
                stmt.executeUpdate();
                
                // Cerrar la conexión
                rs.close();
                stmt.close();
                con.close();
     
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
         
}
public void eliminarunPerfilesUsuario(String pernombre, String usuario) {   
            
            try {
        // Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);
        
        // Obtener el perid del perfil seleccionado
        Statement stmt = con.createStatement();
        String sql = "SELECT codigo_curso FROM cursos WHERE nombre_curso='" + pernombre + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int perid = rs.getInt("codigo_curso");
        rs.close();
        stmt.close();

        
        // Obtener el usuid del usuario seleccionado en el combo box
        stmt = con.createStatement();
        sql = "SELECT carnet_alumno FROM alumnos WHERE nombre_alumno='" + usuario + "'";
        rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("carnet_alumno");
        rs.close();
        stmt.close();

        
        // Eliminar el registro de la tabla tbl_perfilusuario
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM asignacioncursosalumnos WHERE carnet_alumno=? AND codigo_curso");
        pstmt.setInt(1, usuid);
        pstmt.setInt(2, perid);
        pstmt.executeUpdate();
        pstmt.close();

        stmt.close();
        
        // Cerrar la conexión
        con.close();
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
         
}

}

