package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.afectadaDao;
import model.afectadaVo;

/**
 * Servlet implementation class AfectadasController
 */
@WebServlet("/AfectadaController")
public class AfectadaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	afectadaVo aVo = new afectadaVo();
	afectadaDao aDao= new afectadaDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfectadaController() {
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
			case "delete":
				delete(request,response);
				break;

			case "ver":
				ver(request,response);
				break;
				
			case "changeEstado":
				changeEstado(request,response);
				break;
				
			case "edit":
				edit(request,response);
			break;
			case "add":
				add(request,response);
			break;
			case "abrirFormRegis":
				abrirFormRegis(request,response);
				break;
				
			/*case "abrirForm":
				abrirForm(request,response);
				break;
				
			case "add":
				add(request,response);
				break;
			;*/
			default:
				response.sendRedirect("login.jsp");
			}
		}
		else {
			response.sendRedirect("login.jsp");
		}
	} catch (Exception e) {
		System.out.println("error"+e.getMessage());
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
			List afect= aDao.listar();
			//(para que del controlador suba a una vista)
			request.setAttribute("afectadas", afect);
			request.getRequestDispatcher("views/afectada.jsp").forward(request, response);
			System.out.println("afectadas encontrados");
			
		} catch (Exception e) {
			System.out.println("afectadas no encontradods"+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}


private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id") !=null) {
		aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
	}
	
	
	try {
		aDao.eliminar(aVo.getIDafectada());
		response.sendRedirect("AfectadaController?accion=listar");
		System.out.println("Afectada eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el formulario Afectada");
	}
}

private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
		aVo.getAfecUs().setEstado(Boolean.parseBoolean(request.getParameter("es")));
	
	
	try {
		aDao.changeEstado(aVo);
		
		response.sendRedirect("AfectadaController?accion=listar");
		System.out.println("afectada cambiada");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el estado de afectada");
	}
}


private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
	try {
		//(para que del modelo suba al controlador)
		aVo=aDao.consultaId(aVo.getIDafectada());
		//(para que del controlador suba a una vista)
		request.setAttribute("afectada", aVo);
		request.getRequestDispatcher("views/afectada-edit.jsp").forward(request, response);
		System.out.println("afectada encontrado");
		
	} catch (Exception e) {
		System.out.println("afectada no encontrado"+e.getMessage());
	}
	finally {
		//rdao=null;
		}
	
	}

private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id")!=null && request.getParameter("correo") !=null && request.getParameter("contrasena")!=null) {
		
		aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
		aVo.setNombre(request.getParameter("nombre"));
		aVo.setApellido(request.getParameter("apellido"));
		aVo.setTelefono(request.getParameter("telefono"));
		aVo.setTipoDocumento(request.getParameter("telefono"));
		aVo.setNumeroDocumento(request.getParameter("numeroDocumento"));
		aVo.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		aVo.getAfecUs().setCorreo(request.getParameter("correo"));
		aVo.getAfecUs().setContrase�a(request.getParameter("contrasena"));
		aVo.getAfecUs().setCargo(request.getParameter("cargo"));
	}
	
	try {
		aDao.edit(aVo);
		response.sendRedirect("AfectadaController?accion=listar");
		System.out.println("Afectada cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar a afectada");
	}

}





private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("nombre") !=null) {
		aVo.setNombre(request.getParameter("nombre"));
	}
	if(request.getParameter("apellido") !=null) {
		aVo.setApellido(request.getParameter("apellido"));
	}
	if(request.getParameter("telefono") !=null) {
		aVo.setTelefono(request.getParameter("telefono"));
	}

	if(request.getParameter("tipoDocumento") !=null) {
		aVo.setTipoDocumento(request.getParameter("tipoDocumento"));
	}

	if(request.getParameter("numeroDocumento") !=null) {
		aVo.setNumeroDocumento(request.getParameter("numeroDocumento"));
	}

	if(request.getParameter("fechaNacimiento") !=null) {
		aVo.setTelefono(request.getParameter("fechaNacimiento"));
	}

	try {
		aDao.registrar(aVo);
		response.sendRedirect("AfectadaController?accion=listar");
		System.out.println("Afectada registrada");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario regidtrar afec"+e.getMessage());
	}
}


private void abrirFormRegis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//para enviar a una vista particular
		request.getRequestDispatcher("views/add-afectada.jsp").forward(request, response);
		System.out.println("Formulario afectada Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario afectada"+e.getMessage());
	
	}
		
}


}
