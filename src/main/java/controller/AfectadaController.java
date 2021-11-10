package controller;

import java.io.IOException;
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
				
			/*case "abrirForm":
				abrirForm(request,response);
				break;
				
			case "add":
				add(request,response);
				break;
			case "delete":
				delete(request,response);
				break;
			case "cambiarEstado":
				cambiarEstado(request,response);
					break;
			case "ver":
				ver(request,response);
				break;
				
			case "edit":
				edit(request,response);
			break;*/
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
			request.getRequestDispatcher("views/afectadas.jsp").forward(request, response);
			System.out.println("afectadas encontrados");
			
		} catch (Exception e) {
			System.out.println("afectadas no encontradods"+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}

}
