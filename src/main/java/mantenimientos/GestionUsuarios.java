package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.UsuarioVo;
import util.Conexion;

public class GestionUsuarios {

	public UsuarioVo obtenerUsuario (UsuarioVo usu) {
		UsuarioVo usuario= null;
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Conexion c= new Conexion();
		
		try {
			con = c.conectar();
			String sql="SELECT*FROM usuario Where correo=? contrasena=?";
			ps= con.prepareStatement(sql);
			ps.setString(1,usu.getCorreo());
			ps.setString(2, usu.getContraseña());
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContraseña(rs.getString("contrasena"));
				System.out.println("cinformacion correcta");			
			}
			
		} catch (Exception e) {
	
			System.out.println("error"+e.getMessage());
		}
		
		
		return usuario;
		
	}
}
