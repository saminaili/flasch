package com.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter printwriter=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("pws");
		String email=request.getParameter("email");
		String java=request.getParameter("ja");int java1=Integer.parseInt(java);
		String scala=request.getParameter("sc");int scala1=Integer.parseInt(scala);
		String jenkis=request.getParameter("je");	int jenkis1=Integer.parseInt(jenkis);
		String git=request.getParameter("gi");int git1 =Integer.parseInt(git);
		
		
	
		
		Membre membre=new Membre();
		membre.setName(name);//name hatha howa eli bech neste3mlouh men be3ed fi methode preparedstatemen.setStrin(2,getName());name ne3touh be set hethi eli fi ligne hatha wenraj3o 
		membre.setPassword(password);
		membre.setEmail(email);
		membre.setJava(java1);
		membre.setScala(scala1);
		membre.setJenkis(jenkis1);
		membre.setGit(git1);
		int num=MembreSQL.save(membre);//hathi etsajel fi data base
		if(num>0) {
			
			printwriter.println("saved successeful");
			request.getRequestDispatcher("index.html").include(request,response);
		}
		else {
			
			printwriter.println("Sorry not Saved");
		}
	
	
	
	
	}

}
