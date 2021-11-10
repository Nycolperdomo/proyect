package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class afectadaDao {
		
		//metodos
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
			List <afectadaVo> afectada = new ArrayList<>();
			sql = "SELECT IDafectada,nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento,correo FROM afectada JOIN usuario on usuario.IDusuario = afectada.IDafectada;";
			try {
				con= c.conectar();//abriendo la conexion a la bd
				ps= con.prepareStatement(sql);//preparar sentencia
				rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
				while(rs.next()) {
					afectadaVo a = new afectadaVo();
					a.setIDafectada(rs.getInt(1));
					a.setNombre(rs.getString(2));
					a.setApellido(rs.getString(3));
					a.setTelefono(rs.getString(4));
					a.setTipoDocumento(rs.getString(5));
					a.setNumeroDocumento(rs.getString(6));
					a.setFechaNacimiento(rs.getDate(7));
					a.setAfecUs(new UsuarioVo());
					a.getAfecUs().setCorreo(rs.getString(8));
					
					// asi no se hace u.setDescripcionRol(rs.getString(10));
					//otra forma de hacerlo
					//r.setIdRol(rs.getInt("idRol"));
				
					afectada.add(a);
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
			return afectada;	
		
	}

		public int registrar (profesionalVo pVo) {
			sql="";
		}
		
		
		
		
		
}