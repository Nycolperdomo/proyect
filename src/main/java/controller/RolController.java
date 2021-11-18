package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import model.UsuarioDao;
import model.UsuarioVo;
import model.UsuarioDao;

/**
 * Servlet implementation class RolController
 */
@WebServlet("/RolController")
public class RolController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDao udao=new UsuarioDao();
	//UsuarioVo r=new UsuarioVo();
	UsuarioVo r = new UsuarioVo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolController() {
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
		HttpSession session = request.getSession();
		try {
			if(accion!=null) {
				switch (accion) {

				case "abrirLogin":
					abrirLogin(request, response);
					break;
				case "login":
					r.setCorreo(request.getParameter("correo"));
					r.setContraseña(request.getParameter("password"));
					
					try {
						r=udao.validarUsuario(r.getCorreo(),r.getContraseña());						
						if(r.isEstado()==true) {
							System.out.println("Se encontro un usuario activo");
							session.setAttribute("us", r);
							response.sendRedirect("RolController?accion=listarRoles");
							
						}
						else if(r.isEstado()==false){
							System.out.println("Se encontro un usuario inactivo");
							//para enviar un msm
							request.getRequestDispatcher("RolController?accion=abrirLogin&msn=Usuario Inactivo consulte con el administrador");
						}
						else {
							System.out.println("Se encontro no registrado");
							request.getRequestDispatcher("RolController?accion=abrirLogin&msn=Datos de acceso incorrectos");
						}
					}catch(Exception e) {
						System.out.println("Se presentó un error "+e);
					}
					 
					
					break;
				case "listarRoles": 
					System.out.println("entro a la accion listar");
					listarRoles(request,response);
					break;
					
				case "abrirForm":
					System.out.println("entro a la accion abrirFormulario");
					abrirForm(request,response);
					break;
					
				case "add":
					System.out.println("entro a la accion aregar");
					add(request,response);
					break;
				case "delete":
					delete(request,response);
					break;
				case "ver":
					ver(request,response);
					break;
				case "edit":
					edit(request,response);
					break;
				case "changeEstado":
					changeEstado(request,response);
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
	
	//el metodo doGet y doPost nos sirven para procesar las peticiones
		//se comenta la segunda linea del do get (response.getwritter().appenes("seved at:"))...
	}

private void listarRoles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entramos al método listar");
		
		try {
			List rol=udao.listarRoles();
			request.setAttribute("roles",rol);
			request.getRequestDispatcher("views/rol.jsp").forward(request, response);
			System.out.println("Roles encontrados");
			
			
		}catch(Exception e) {
			System.out.println("Roles no encontrados "+e.getMessage());
		}
		finally {
			//udao=null;
		}
		
	}

private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//para enviar a una vista particular
		request.getRequestDispatcher("views/rol_Edit.jsp").forward(request, response);
		System.out.println("Formulario Rol Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario");
	
	}
		
}

private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("correo") !=null) {
		r.setCorreo(request.getParameter("correo"));
	}
	if(request.getParameter("contrasena") !=null) {
		r.setContraseña(request.getParameter("contrasena"));
	}

	if(request.getParameter("chkEstado") !=null){
		r.setEstado(true);
	}
	else {
		r.setEstado(false);
	}
	
	try {
		udao.registrar(r);
		response.sendRedirect("RolController?accion=listarRoles");
		System.out.println("Rol registrado");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario Rol");
	}
}
	

private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id") !=null) {
		r.setIDusuario(Integer.parseInt(request.getParameter("id")));
	}
	
	
	try {
		udao.eliminar(r.getIDusuario());
		response.sendRedirect("RolController?accion=listarRoles");
		System.out.println("Rol eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el formulario Rol");
	}
}

private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	r.setIDusuario(Integer.parseInt(request.getParameter("id")));
	r.setEstado(Boolean.parseBoolean(request.getParameter("es")));


try {
	//r dato que s guardo en el Vo (par de datos)
	udao.changeEstado(r);
	response.sendRedirect("RolController?accion=listarRoles");
	System.out.println("Rol cambiado");
}catch(Exception e) {
	
	System.out.println("Error al cambiar el estado del Rol");
}
}

private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	r.setIDusuario(Integer.parseInt(request.getParameter("id")));
	try {
		//(para que del modelo suba al controlador)
		r=udao.consultaId(r.getIDusuario());
		//(para que del controlador suba a una vista)
		request.setAttribute("roles", r);
		request.getRequestDispatcher("views/rol-eddit.jsp").forward(request, response);
		System.out.println("Usuario encontrado");
		
	} catch (Exception e) {
		System.out.println("Usuario no encontrado"+e.getMessage());
	}
	finally {
		//rdao=null;
		}
	
	}

private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id")!=null && request.getParameter("correo") !=null && request.getParameter("contrasena")!=null) {
		
		r.setIDusuario(Integer.parseInt(request.getParameter("id")));
		r.setCorreo(request.getParameter("correo"));
		r.setContraseña(request.getParameter("contrasena"));
		
	}
	if(request.getParameter("chkEstado") !=null){
		r.setEstado(true);
	}
	else {
		r.setEstado(false);
	}
	
	
	
	try {
		udao.edit(r);
		response.sendRedirect("RolController?accion=listarRoles");
		System.out.println("Usuario cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el Usuario");
	}
}
private void abrirLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
	request.getRequestDispatcher("views/loginNico.jsp").forward(request, response);
	System.out.println("Login abierto");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario Login");
	}

	}
}	
		

