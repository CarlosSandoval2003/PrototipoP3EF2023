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
    
    public ArrayList<String> obtenerNombreCarrera() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT nombre_carrera FROM carreras";
        ResultSet rs = stmt.executeQuery(sql);

        // 4. Recuperar los resultados
        while (rs.next()) {
            // 5. Agregar los elementos al ArrayList
            nombresUsuarios.add(rs.getString("nombre_carrera"));
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
    
        public ArrayList<String> obtenerNombreSede() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT nombre_sede FROM sedes";
        ResultSet rs = stmt.executeQuery(sql);

        // 4. Recuperar los resultados
        while (rs.next()) {
            // 5. Agregar los elementos al ArrayList
            nombresUsuarios.add(rs.getString("nombre_sede"));
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
        
            public ArrayList<String> obtenerNombreJornada() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT nombre_jornada FROM jornadas";
        ResultSet rs = stmt.executeQuery(sql);

        // 4. Recuperar los resultados
        while (rs.next()) {
            // 5. Agregar los elementos al ArrayList
            nombresUsuarios.add(rs.getString("nombre_jornada"));
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
            
                public ArrayList<String> obtenerNombreSeccion() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT nombre_seccion FROM secciones";
        ResultSet rs = stmt.executeQuery(sql);

        // 4. Recuperar los resultados
        while (rs.next()) {
            // 5. Agregar los elementos al ArrayList
            nombresUsuarios.add(rs.getString("nombre_seccion"));
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
                
                    public ArrayList<String> obtenerNombreAula() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT nombre_aula FROM aulas";
        ResultSet rs = stmt.executeQuery(sql);

        // 4. Recuperar los resultados
        while (rs.next()) {
            // 5. Agregar los elementos al ArrayList
            nombresUsuarios.add(rs.getString("nombre_aula"));
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
        String usuid = rs.getString("carnet_alumno");

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
public  void asignartodoPerfilesUsuario(DefaultTableModel modelo, String usuario, String carrera, String sede, String jornada, String seccion, String aula, float nota) {
try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siu?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Obtener el usuario seleccionado en el combo box

        // 3. Obtener el usuid del usuario seleccionado en el combo box
        String sql = "SELECT carnet_alumno FROM alumnos WHERE nombre_alumno='" + usuario + "'";
        String sql2 = "SELECT codigo_carrera FROM carreras WHERE nombre_carrera='" + carrera + "'";
        String sql3 = "SELECT codigo_sede FROM sedes WHERE nombre_sede='" + sede + "'";
        String sql4 = "SELECT codigo_jornada FROM jornadas WHERE nombre_jornada='" + jornada + "'";
        String sql5 = "SELECT codigo_seccion FROM secciones WHERE nombre_seccion='" + seccion + "'";
        String sql6 = "SELECT codigo_aula FROM aulas WHERE nombre_aula='" + aula + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Statement stmt2 = con.createStatement();
        ResultSet rs2 = stmt2.executeQuery(sql2);
        Statement stmt3 = con.createStatement();
        ResultSet rs3 = stmt3.executeQuery(sql3);
        Statement stmt4 = con.createStatement();
        ResultSet rs4 = stmt4.executeQuery(sql4);
        Statement stmt5 = con.createStatement();
        ResultSet rs5 = stmt5.executeQuery(sql5);
        Statement stmt6 = con.createStatement();
        ResultSet rs6 = stmt6.executeQuery(sql6);
        rs.next();
        rs2.next();
        rs3.next();
        rs4.next();
        rs5.next();
        rs6.next();
        String usuid = rs.getString("carnet_alumno");
        String codcarrera = rs2.getString("codigo_carrera");
        String codsede = rs3.getString("codigo_sede");
        String codjornada = rs4.getString("codigo_jornada");
        String codseccion = rs5.getString("codigo_seccion");
        String codaula = rs6.getString("codigo_aula");

        // 4. Recorrer los perfiles disponibles en la tabla jTable1
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            String pernombre = modelo.getValueAt(i, 0).toString();

            // 5. Obtener el perid del perfil
            sql = "SELECT codigo_curso FROM cursos WHERE nombre_curso='" + pernombre + "'";
            ResultSet rsPer = stmt.executeQuery(sql);
            rsPer.next();
            String perid = rsPer.getString("codigo_curso");

            // 6. Insertar el registro en tbl_perfilusuario
            sql = "INSERT INTO asignacioncursosalumnos (codigo_carrera, codigo_sede, codigo_jornada, codigo_seccion, codigo_aula, codigo_curso, carnet_alumno, nota_asignacioncursoalumnos) VALUES (" + codcarrera + "," + codsede + "," + codjornada + "," + codseccion + "," + codaula + "," + perid + ", " + usuid + "," + nota + ")";
            stmt.executeUpdate(sql);
            rsPer.close();
        }

        // 7. Cerrar la conexión y actualizar la tabla jTable2
        rs.close();
        rs2.close();
        rs3.close();
        rs4.close();
        rs5.close();
        rs6.close();
        stmt.close();
        stmt2.close();
        stmt3.close();
        stmt4.close();
        stmt5.close();
        stmt6.close();
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
        String usuid = rs.getString("carnet_alumno");

        // 4. Recorrer la tabla 2 y eliminar los perfiles asociados al usuario
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String pernombre = modelo.getValueAt(i, 0).toString();
            sql = "SELECT codigo_curso FROM cursos WHERE nombre_curso='" + pernombre + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            String perid = rs.getString("codigo_curso");
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
                String perid = rs.getString("codigo_curso");
                
                // Obtener el usuid del usuario seleccionado en el combo box
                stmt = con.prepareStatement("SELECT carnet_alumno FROM alumnos WHERE nombre_alumno=?");
                stmt.setString(1, usuario);
                rs = stmt.executeQuery();
                rs.next();
                String usuid = rs.getString("carnet_alumno");
                
                // Insertar el nuevo registro en tbl_perfilusuario
                stmt = con.prepareStatement("INSERT INTO asignacioncursosalumnos (codigo_curso, carnet_alumno) VALUES (?, ?)");
                stmt.setString(1, perid);
                stmt.setString(2, usuid);
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
        String perid = rs.getString("codigo_curso");
        rs.close();
        stmt.close();

        
        // Obtener el usuid del usuario seleccionado en el combo box
        stmt = con.createStatement();
        sql = "SELECT carnet_alumno FROM alumnos WHERE nombre_alumno='" + usuario + "'";
        rs = stmt.executeQuery(sql);
        rs.next();
        String usuid = rs.getString("carnet_alumno");
        rs.close();
        stmt.close();

        
        // Eliminar el registro de la tabla tbl_perfilusuario
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM asignacioncursosalumnos WHERE carnet_alumno=? AND codigo_curso");
        pstmt.setString(1, usuid);
        pstmt.setString(2, perid);
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

