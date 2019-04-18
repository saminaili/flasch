package com.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Updateservlet2
 */
@WebServlet("/Updateservlet2")
public class Updateservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateservlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter printwriter=response.getWriter();
	printwriter.println("Update Membre Info");
	String membreid=request.getParameter("id");
	int id=Integer.parseInt(membreid);
	
	String name=request.getParameter("name");//el name  Name eli fi  form eli fi Updateservlet mouch eli fi index.html
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	String java=request.getParameter("java");
	int java1=Integer.parseInt(java);
	String scala=request.getParameter("scala");
	int scala1=Integer.parseInt(scala);
	String jenkis=request.getParameter("jenkis");
	int jenkis1=Integer.parseInt(jenkis);
	String git=request.getParameter("git");
	int git1=Integer.parseInt(git);
	Membre membre=new Membre();//3la khater tawika ebdet 3endna ma3loumet ejdida emt3 3ebara 3la student jdide
	membre.setId(id);
	membre.setName(name);
	membre.setPassword(password);
	membre.setEmail(email);
	membre.setJava(java1);
	membre.setScala(scala1);
	membre.setJenkis(jenkis1);
	membre.setGit(git1);
int num=MembreSQL.update(membre);//etha num akbare men 0 ya3ni fiha value
if(num>0) {
response.sendRedirect("ViewServlet");//sendredirect ey3adik lel viewviewservlet eli hiya servlet okhra

}
else {
printwriter.print("sorry not updated");

}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}}
