package p1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String userName="";
       String password="";
       ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);
	    context = getServletContext();
	    userName=context.getInitParameter("admin");
	    password=context.getInitParameter("password");
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String adminUser=request.getParameter("username");
		String adminpassword=request.getParameter("password");
		writer.println(adminUser);
		writer.println(adminpassword);
		writer.println(userName);
		writer.println(password);
		if(adminUser.equals(userName) && adminpassword.equals(password))
		{
			//to redirect to servlet
			//RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.html");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.html");	
		requestDispatcher.forward(request,response);
		}else {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.html");	
			requestDispatcher.forward(request,response);
		}
		//Storing user name in file we are working on it.
		String webInfPath = getServletConfig().getServletContext().getRealPath("WEB-INF");
		File newFile = new File(webInfPath + "/fileName.xml");

		//File file=new File(path);
		writer.println("helloo");
		writer.println(webInfPath);

		
		
		
	}

}
