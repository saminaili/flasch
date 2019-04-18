package com.team;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		String membreid=request.getParameter("id");//hathi eli bech nekhtiha men viewservlet ki yenzel user 3la delete automatik tekhou id emte student hathaka ow temchi lel Deleteservlet eli fiha el fonction Delete
	
		int id=Integer.parseInt(membreid);
	//be3ed ne7tej nodkhel le database ow ne7thefha we database emte3i hiya StudenSQL ow be3ed na3retha men khilel viweservlet eli te3meli affichage
	
	MembreSQL.delete(id);
	response.sendRedirect("ViewServlet");//ne3rathha 7atta netaked eno teme 7athfha
	
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	


