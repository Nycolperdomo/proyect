package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class profesionalDao {

	
	//definir esas variables para realizar operaciones sobre la BD
	Connection con;
	//guarda el resultado de la consulta
	ResultSet rs;
	//prepara la sentencia que se va a ejecutar sql
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c= new Conexion();
	
	//metodos
	
	public List listar() throws SQLException {
		List <profesionalVo> profesional = new ArrayList<>();
		sql = "SELECT IDprofesional,nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento,correo FROM profesional JOIN usuario on usuario.IDusuario = profesional.IDprofesional;";
		
		try {
			con= c.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
			while(rs.next()) {
				profesionalVo p = new profesionalVo();
				p.setIDprofesional(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				p.setTelefono(rs.getString(4));
				p.setTipoDocumento(rs.getString(5));
				p.setNumeroDocumento(rs.getString(6));
				p.setFechaNacimiento(rs.getDate(7));
				
				p.setProUs(new UsuarioVo());
				p.getProUs().setCorreo(rs.getString(8));
				
				// asi no se hace u.setDescripcionRol(rs.getString(10));
				//otra forma de hacerlo
				//r.setIdRol(rs.getInt("idRol"));
			
				profesional.add(p);
				System.out.println("conexion exitosa");
			
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("conexion no exitosa"+e.getMessage());
		}
		finally {
			con.close();
		}
		return profesional;	
	
}

	
	
}
