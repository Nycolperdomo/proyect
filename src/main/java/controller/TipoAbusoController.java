package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tipoAbusoDao;
import model.tipoAbusoVo;


/**
 * Servlet implementation class TipoAbusoController
 */
@WebServlet("/TipoAbusoController")
public class TipoAbusoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	tipoAbusoDao tadao=new tipoAbusoDao();
    
	tipoAbusoVo r = new tipoAbusoVo();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public TipoAbusoController() {
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

private void listartipoAbuso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entramos al metodo listar");
		
		try {
			List tipoAbuso=tadao.listartipoAbuso();
			request.setAttribute("abusos",tipoAbuso);
			request.getRequestDispatcher("views/Abusos.jsp").forward(request, response);
			System.out.println("Tipos de abusos encontrados");
			
			
		}catch(Exception e) {
			System.out.println("Tipos de abusos no encontrados "+e.getMessage());
		}
		finally {
			//udao=null;
		}
		
	}

private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//para enviar a una vista particular
		request.getRequestDispatcher("views/add-Abusos.jsp").forward(request, response);
		System.out.println("Formulario Abusos Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario");
	
	}
		
}
private void addA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("nombre") !=null) {
		r.setNombre(request.getParameter("nombre"));
	}
	if(request.getParameter("descripcion") !=null) {
		r.setDescripcion(request.getParameter("descripcion"));
	}

	try {
		tadao.registrar(r);
		response.sendRedirect("TipoAbusoController?accion=listartipoAbuso");
		System.out.println("Tipo de abuso registrado");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario de tipo de abusos");
	}
}
private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id") !=null) {
		r.setIDabuso(Integer.parseInt(request.getParameter("id")));
	}
	
	
	try {
		tadao.eliminar(r.getIDabuso());
		response.sendRedirect("TipoAbusoController?accion=listartipoAbuso");
		System.out.println("Tipo de abuso eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el formulario tipo de abuso");
	}
}
private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	r.setIDabuso(Integer.parseInt(request.getParameter("id")));
	try {
		//(para que del modelo suba al controlador)
		r=tadao.consultaId(r.getIDabuso());
		//(para que del controlador suba a una vista)
		request.setAttribute("abusos", r);
		request.getRequestDispatcher("views/eddit-Abusos.jsp").forward(request, response);
		System.out.println("Tipo de abuso encontrado");
		
	} catch (Exception e) {
		System.out.println("Tipo de abuso no encontrado"+e.getMessage());
	}
	finally {
		//rdao=null;
		}
}
private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//estos datos se miran desde la vista como tal en el name 
	System.out.println(request.getParameter("nombre"));
	r.setIDabuso(Integer.parseInt(request.getParameter("id")));
	r.setDescripcion(request.getParameter("descripcion"));
	r.setNombre(request.getParameter("nombre"));
	
	
	if(request.getParameter("id")!=null && request.getParameter("nombre") !=null && request.getParameter("descripcion")!=null) {
		
	
	
	try {
		tadao.edit(r);
		response.sendRedirect("TipoAbusoController?accion=listartipoAbuso");
		System.out.println("Tipo de abuso cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el tipo de abuso");
	}
	}
}
}
	

	


