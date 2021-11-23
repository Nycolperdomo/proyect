package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class UsuarioDao {

	//definir variables necesarias pra realizar operaciones sibre la bd
	UsuarioVo uvo = new UsuarioVo();

	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c= new Conexion();
	
	
	//metodos
	public List listarRoles() throws SQLException {
		List <UsuarioVo> roles = new ArrayList <>();
		sql = "SELECT * FROM usuario;";
		//sql = "SELECT * FROM usuario";
		
		try {
			con= c.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
			//para recorrer el resulset (los datos)
			while(rs.next()) {
				UsuarioVo r= new UsuarioVo();
				 r.setIDusuario(rs.getInt("IDusuario"));
				 r.setCorreo(rs.getString("correo"));
				 r.setContraseña(rs.getString("contrasena"));
				 r.setEstado(rs.getBoolean("estado"));
				 r.setCargo(rs.getString("cargo"));
				
				roles.add(r);
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
		return roles;
	}
	
	
	
	//metodo registro
	public int registrar(UsuarioVo r) throws SQLException {
		sql="INSERT INTO usuario(correo,contrasena,estado,cargo) VALUES(?,?,?,?)";
		try {
			con= c.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			ps.setString(1, r.getCorreo());
			ps.setString(2, r.getContraseña());
			ps.setBoolean(3,r.isEstado());
			ps.setString(4, r.getCargo());
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
			ps.close();
			System.out.println("se registro un usuario");
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error al registrar el rol"+e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//retorna cantidad de filas afectadas
	}
	
	public int registrarAfe(UsuarioVo r) throws SQLException {
		sql="INSERT INTO usuario(correo,contrasena,estado,cargo) VALUES(?,?,?,?)";
		try {
			con= c.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			ps.setString(1, r.getCorreo());
			ps.setString(2, r.getContraseña());
			ps.setBoolean(3,r.isEstado());
			ps.setString(4, r.getCargo());
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
			ps.close();
			System.out.println("se registro una afectada");
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error al registrar el afec"+e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//retorna cantidad de filas afectadas
	}
	
	public int registrarDatos(UsuarioVo r) throws SQLException {
		sql="INSERT INTO usuario(correo,contrasena,estado,cargo) VALUES(?,?,?,?)";
		try {
			con= c.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			ps.setString(1, r.getCorreo());
			ps.setString(2, r.getContraseña());
			ps.setBoolean(3,r.isEstado());
			ps.setString(4, r.getCargo());
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
			ps.close();
			System.out.println("se registro una afectada");
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error al registrar el afec"+e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//retorna cantidad de filas afectadas
	}
		
		

public int eliminar(int id) throws SQLException {
	sql="DELETE FROM usuario WHERE IDusuario="+id;
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se eliminó un rol");
		
	}catch(Exception e) {
		System.out.println("Error al eliminar el rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int changeEstado(UsuarioVo r) throws SQLException {
	sql="UPDATE usuario SET estado=? WHERE IDusuario="+r.getIDusuario();
	try {
		con= c.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		ps.setBoolean(1, r.isEstado());
		
		System.out.println(ps);
		ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
		ps.close();
		System.out.println("se cambio el estado de un rol");
		
	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("error al cambiar el estado del rol"+e.getMessage());
	}
	finally {
		
		con.close();
	}
	return row;//retorna cantidad de filas afectadas
}


public UsuarioVo consultaId(int id) throws SQLException {
	UsuarioVo r= new UsuarioVo();
	sql = "SELECT *from usuario WHERE IDusuario="+id;
	
	try {
		con= c.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSetes una sentencia de consulta por eso es query
		
		while(rs.next()) {
		
			r.setIDusuario(rs.getInt("IDusuario"));
			r.setCorreo(rs.getString("correo"));
			r.setContraseña(rs.getString("contrasena"));
			r.setEstado(rs.getBoolean("estado"));
			r.setCargo(rs.getString("cargo"));
			
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
	return r;
}



public int edit(UsuarioVo r) throws SQLException {
	sql="UPDATE usuario SET correo=?, contrasena=?, estado=?, cargo=? WHERE IDusuario="+r.getIDusuario();
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1, r.getCorreo());
		ps.setString(2, r.getContraseña());
		ps.setBoolean(3,r.isEstado());
		ps.setString(4, r.getCargo());
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se cambió el rol");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar el rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public UsuarioVo validarUsuario(String correo,String passw) throws SQLException {
	UsuarioVo u=new UsuarioVo();
	sql="SELECT IDusuario,correo,estado,cargo FROM usuario WHERE correo=? and contrasena=?;";
	try {
		con=c.conectar();
		ps=con.prepareStatement(sql);
		ps.setString(1, correo);
		ps.setString(2, passw);
		rs=ps.executeQuery();
		while(rs.next()) {
			u.setIDusuario(rs.getInt(1));
			u.setCorreo(rs.getString(2));
			u.setEstado(rs.getBoolean(3));
			u.setCargo(rs.getString(4));
		}
		ps.close();
		System.out.println("Se encontró el Usuario");
	}catch(Exception e) {
		System.out.println("Se encontró el Usuario"+e.getMessage());
	}finally {
		con.close();
	}
	return u;
}



}
