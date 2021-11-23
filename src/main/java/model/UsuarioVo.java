package model;

public class UsuarioVo {

	//atributos encapsulados
	private int IDusuario;
	private String correo;
	private String contrase�a,cargo;
	private boolean estado;
	
	profesionalVo profesional;
	afectadaVo afec;
	
	
	//constructores vacio,recibir datos sourse generate  (fields)
	public UsuarioVo() {
		
	}



	public UsuarioVo(int iDusuario, String correo, String contrase�a, String cargo, boolean estado, profesionalVo profesional, afectadaVo afec) {
		super();
		IDusuario = iDusuario;
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.cargo = cargo;
		this.estado = estado;
		this.profesional = profesional;
		this.afec = afec;
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


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public profesionalVo getProfesional() {
		return profesional;
	}



	public void setProfesional(profesionalVo profesional) {
		this.profesional = profesional;
	}



	public afectadaVo getAfec() {
		return afec;
	}



	public void setAfec(afectadaVo afec) {
		this.afec = afec;
	}
	
	
	
	
}
