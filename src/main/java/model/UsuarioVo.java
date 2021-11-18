package model;

public class UsuarioVo {

	//atributos encapsulados
	private int IDusuario;
	private String correo;
	private String contraseña;
	private boolean estado;
	
	
	//constructores vacio,recibir datos sourse generate  (fields)
	public UsuarioVo() {
		
	}


	
	public UsuarioVo(int iDusuario, String correo, String contraseña, boolean estado) {
		super();
		IDusuario = iDusuario;
		this.correo = correo;
		this.contraseña = contraseña;
		this.estado = estado;
	}






	//getter y setter sourse generate  (acceder de forma segura a los datos)
	public int getIDusuario() {
		return IDusuario;
	}


	public void setIDusuario(int iDusuario) {
		IDusuario = iDusuario;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
}
