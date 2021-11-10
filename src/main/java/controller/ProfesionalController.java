package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	try {
		if(accion!=null) {
			switch (accion) {
			
			case "listar": 
				listar(request,response);
				break;
				
			case "abrirForm":
				abrirForm(request,response);
				break;
				
			case "add":
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
		//para enviar a una vista particular
		request.getRequestDispatcher("views/add-profesional.jsp").forward(request, response);
		System.out.println("Formulario profesional Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario");
	
	}
		
}

private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
	

private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id") !=null) {
		pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
	}
	
	
	try {
		pDao.eliminar(pVo.getIDprofesional());
		response.sendRedirect("profesionalController?accion=listar");
		System.out.println("Profesional eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el formulario Profesional");
	}
}

private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
	try {
		//(para que del modelo suba al controlador)
		pVo=pDao.consultaId(pVo.getIDprofesional());
		//(para que del controlador suba a una vista)
		request.setAttribute("profesional", pVo);
		request.getRequestDispatcher("views/up-profesional.jsp").forward(request, response);
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
		pVo.setCorreo(request.getParameter("correo"));
		pVo.setContraseña(request.getParameter("contrasena"));
	}
	
	try {
		pDao.edit(pVo);
		response.sendRedirect("ProfesionalController?accion=listar");
		System.out.println("Profesional cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el Profesional");
	}
}

}
	
