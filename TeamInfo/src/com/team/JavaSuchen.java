package com.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaSuchen
 */
@WebServlet("/JavaSuchen")
public class JavaSuchen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaSuchen() {
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
	String javaid=request.getParameter("javv");
		int java=Integer.parseInt(javaid);
		printwriter.print("<html>");
		printwriter.print("<head>");
		
		printwriter.print("</head>");
		printwriter.print("<body>");
		printwriter.print("<a href='index.html' class='btn btn-info' role='button'> Membre Hinzufügen</a>");
		printwriter.print("<h1>Membre Table</h1>");
		
		List<Membre>list=MembreSQL.getJava(java);
		printwriter.print("<table border='1' width='100%'>");
		printwriter.print("<tr><th>id</th><th>Name</th><th>Password</th><th>Email</th><th>Java</th><th>Scala</th><th>Jenkis</th><th>Git</th></tr>");
	for(Membre membre:list) {
		printwriter.print("<tr><td>"+membre.getId() +"</td><td>"+membre.getName()+"</td><td>"+membre.getPassword()+"</td><td>"+membre.getEmail()+
				"</td><td>"+membre.getJava()+"</td><td>"+membre.getScala() +"</td><td>"+membre.getJenkis()+"</td><td>"+membre.getGit()+"</td></tr>");
		
		
	}
	printwriter.print("</tabel");
	printwriter.print("</body");
	
	printwriter.print("</html>");
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
