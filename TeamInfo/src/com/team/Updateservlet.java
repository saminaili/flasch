package com.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Updateservlet
 */
@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter printwriter=response.getWriter();
		printwriter.println("Update Membre Info");
		String membreid=request.getParameter("id");
		int id=Integer.parseInt(membreid);
		Membre membre=MembreSQL.getMembreId(id);// el methode etraga3 7eja etype emte3ha student emsejla fiha id wel name we email...
		printwriter.print("<head>");
		printwriter.print("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" >");
		printwriter.print("</head>");
		printwriter.print("<body>");
		printwriter.print("<form action='Updateservlet2' method='post'>");
		
		//lehna tokhrojlk form fiha elmo3tayet emte3 e student eli a3titlo el id emte3o,ki  en8ayer fi mo3tayete ow men be3ed nenzel submit net3eda le Updateservlet2 eli tetsajel fiha eli m3tayette eli bedeltha 
		printwriter.print("<table>");
		printwriter.print("<tr><td></td><td><input name='id' value='"+membre.getId()+"'/></td>");
		printwriter.print("<tr><td></td><td><input type='text' name='name' value='"+membre.getName()+"'/></td></tr>");
		printwriter.print("<tr><td></td><td><input type='password' name='password' value='"+membre.getPassword()+"'/></td></tr>");
		printwriter.print("<tr><td></td><td><input type='text' name='email' value='"+membre.getEmail()+"'/></td></tr>");
		printwriter.print("<tr><td></td><td><input type='text' name='java' value='"+membre.getJava()+"'/></td></tr>");
		printwriter.print("<tr><td></td><td><input type='text' name='scala' value='"+membre.getScala()+"'/></td></tr>");
		printwriter.print("<tr><td></td><td><input type='text' name='jenkis' value='"+membre.getJenkis()+"'/></td></tr>");
		printwriter.print("<tr><td></td><td><input type='text' name='git' value='"+membre.getGit()+"'/></td></tr>");
		printwriter.print("</td></tr>");
		
		
		printwriter.print("<tr><td colspan='2'><input type='submit' value='submit'/></td></tr>");
		
		printwriter.print("</table>");
		printwriter.print("</form>");//updateservlet2 mafiha 7ettta afichage just teml ete8yer el mo3tayet ,ken sare update et3edik lel viewservlet ken masarech yekhrojlk messaje d'erreur
		
		printwriter.print("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
