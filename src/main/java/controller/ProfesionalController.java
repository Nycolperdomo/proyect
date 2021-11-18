package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsuarioDao;
import model.UsuarioVo;
import model.cargoDao;
import model.cargoVo;
import model.profesionalDao;
import model.profesionalVo;

/**
 * Servlet implementation class ProfesionalController
 */
@WebServlet("/ProfesionalController")
public class ProfesionalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	profesionalVo pVo = new profesionalVo();
	profesionalDao pDao= new profesionalDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesionalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	String accion= request.getParameter("accion");
	//variable de sesion
	//HttpSession session= request.getSession();
	try {
		if (accion != null) {
			switch (accion) {
			/*
			case "abrirlogin":
				abrirLogin(request, response);
				break;
			case "login":
				pVo.getProUs().setCorreo(request.getParameter("correo"));
				pVo.getProUs().setContraseña(request.getParameter("password"));
				
				try {
					pVo=pDao.validarUsuario(pVo.getProUs().getCorreo(), pVo.getProUs().getContraseña());
					
					if(pVo.getProUs().isEstado()==true) {
						System.out.println("Se encontro un usuario activo");
						session.setAttribute("us", pVo);
						response.sendRedirect("ProfessionalController?accion=listar");
						
					}
					else if(pVo.getProUs().isEstado()==false){
						System.out.println("Se encontro un usuario inactivo");
						//para enviar un msm
						request.getRequestDispatcher("ProfesionalController?accion=abrirLogin&msn=Usuario Inactivo consulte con el administrador");
					}
					else {
						System.out.println("Se encontro no registrado");
						request.getRequestDispatcher("ProfesionalController?accion=abrirLogin&msn=Datos de acceso incorrectos");
					}
				}catch(Exception e) {
					System.out.println("Se presentó un error "+e);
				}
				 
				
				break;*/

			case "listar":
				listar(request, response);
				break;
				
			case "abrirForm":
				abrirForm(request,response);
				break;

			case "delete":
				delete(request,response);
				break;
			case "add":
				add(request,response);
				break;
			case "changeEstado":
				changeEstado(request,response);
				break;

			case "ver":
				ver(request,response);
				break;
			case "edit":
				edit(request,response);
			break;
			default:
				response.sendRedirect("login.jsp");
			}
		}
		else {
			response.sendRedirect("login.jsp");
		}
	} catch (Exception e) {
		
	}
} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//(para que del modelo suba al controlador)
			List profes= pDao.listar();
			//(para que del controlador suba a una vista)
			request.setAttribute("profesional", profes);
			request.getRequestDispatcher("views/profesional.jsp").forward(request, response);
			System.out.println("profesionales encontrados");
			
		} catch (Exception e) {
			System.out.println("profesionales no encontradods"+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}



private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		this.obtenerCargo(request, response);
		//para enviar a una vista particular
		request.getRequestDispatcher("views/add-profesional.jsp").forward(request, response);
		System.out.println("Formulario profesional Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario profesionall");
	
	}
		
}


private void obtenerCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("Entramos al método obtener cargos");
	cargoDao cdao=new cargoDao();
	List<cargoVo> cargo=null;
	
	try {
		cargo=cdao.listarCargos();
		request.setAttribute("cargos",cargo);
		
		System.out.println("cargoss encontrados");
		
		
	}catch(Exception e) {
		System.out.println("carfos no encontrados "+e.getMessage());
	}
	finally {
		//rdao=null;
	}
	
}

private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("nombre") !=null && request.getParameter("apellido")!=null && request.getParameter("telefono") !=null
			&& request.getParameter("tipodoc") !=null
			&& request.getParameter("numdoc")!=null && request.getParameter("fechaNa")!=null && request.getParameter("correo")!=null
			/*&& request.getParameter("password")!=null)*/) {
		pVo.setNombre(request.getParameter("nombre"));
		pVo.setApellido(request.getParameter("apellido"));
		pVo.setTelefono(request.getParameter("telefono"));
		pVo.setTipoDocumento(request.getParameter("tipodoc"));
		pVo.setNumeroDocumento(request.getParameter("numdoc"));
		pVo.setFechaNacimiento(request.getParameter("fechaNa"));
		//pVo.setCorreo(request.getParameter("correo"));
		//pVo.setPassword(request.getParameter("password"));
		UsuarioVo r=new UsuarioVo();
		r.setIDusuario(Integer.parseInt(request.getParameter("correo")));
		//r.setContraseña(request.getParameter("password"));
		//r.setIDusuario(Integer.parseInt(request.getParameter("")));
		
		cargoVo c= new cargoVo(); 
		c.setIDcargo(Integer.parseInt(request.getParameter("carpro")));
		pVo.setProUs(r);
		pVo.setProCar(c);
		
	}
	
}





/*private void obtenerUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("Entramos al método obtener usuarios");
	UsuarioDao udao=new UsuarioDao();
	List<UsuarioVo> usu=null;
	
	try {
		usu=udao.listarRoles();
		request.setAttribute("usuarios",usu);
		
		System.out.println("Roles encontrados");
		
		
	}catch(Exception e) {
		System.out.println("Roles no encontrados "+e.getMessage());
	}
	finally {
		//rdao=null;
	}
	
}*/



/*private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("correo") !=null) {
		pVo.setCorreo(request.getParameter("correo"));
	}
	
	//if(request.getParameter("contrasena") !=null) {
		//pVo.setContraseña(request.getParameter("contrasena"));
	//}
	
	try {
		pDao.registrar(pVo);
		response.sendRedirect("ProfesionalController?accion=listar");
		System.out.println("profesional registrado");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario profesional");
	}
}
	
*/
private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id") !=null) {
		pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
	}
	
	
	try {
		pDao.eliminar(pVo.getIDprofesional());
		response.sendRedirect("ProfesionalController?accion=listar");
		System.out.println("Profesional eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el formulario Profesional");
	}
}


private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
		pVo.getProUs().setEstado(Boolean.parseBoolean(request.getParameter("es")));
	
	
	try {
		pDao.changeEstado(pVo);
		response.sendRedirect("ProfesionalController?accion=listar");
		System.out.println("Profesional con el	estado cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar estado de Profesional");
	}
}

private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
	try {
		//(para que del modelo suba al controlador)
		pVo=pDao.consultaId(pVo.getIDprofesional());
		//(para que del controlador suba a una vista)
		request.setAttribute("profesional", pVo);
		request.getRequestDispatcher("views/profesional-edit.jsp").forward(request, response);
		System.out.println("Profesional encontrado");
		
	} catch (Exception e) {
		System.out.println("Profesional no encontrado"+e.getMessage());
	}
	finally {
		//rdao=null;
		}
	
	}
private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id")!=null && request.getParameter("correo") !=null && request.getParameter("contrasena")!=null) {
		
		pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
		pVo.setNombre(request.getParameter("nombre"));
		pVo.setApellido(request.getParameter("apellido"));
		pVo.setTelefono(request.getParameter("telefono"));
		pVo.setTipoDocumento(request.getParameter("telefono"));
		pVo.setNumeroDocumento(request.getParameter("numeroDcumento"));
		pVo.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		pVo.getProUs().setCorreo(request.getParameter("correo"));
		pVo.getProUs().setContraseña(request.getParameter("contrasena"));
		pVo.getProCar().setCargo(request.getParameter("cargo"));
		
	}
	
	try {
		pDao.edit(pVo);
		response.sendRedirect("ProfesionalController?accion=listar");
		System.out.println("Profesional cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el Profesional");
	}
}


/*private void abrirLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
	request.getRequestDispatcher("views/loginNico.jsp").forward(request, response);
	System.out.println("Login abierto");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario Login");
	}
}*/
}
	
