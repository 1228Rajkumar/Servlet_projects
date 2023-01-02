package timeshow;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;






@WebServlet("/SelectTimeZone")
public class SelectTimeZone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public SelectTimeZone() {
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CountryName =req.getParameter("country");
		resp.setContentType("text/html");
		PrintWriter pw =resp.getWriter();
		SimpleDateFormat sd  = new SimpleDateFormat();
		sd.setTimeZone(TimeZone.getTimeZone(CountryName));
		sd.applyPattern("dd MMM yyyy HH:mm:ss z");
		String time = sd.format(Calendar.getInstance().getTime());
		RequestDispatcher rd = req.getRequestDispatcher("/timepage.html");
		rd.include(req, resp);
		pw.println("<div class='show time'>"+"<h2>"+CountryName+" Time is :"+"<span>"+time+"<span>"+"</h2>"+"</div>");
		
	
//		pw.println("welcome to my world guys");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		doGet(req, resp);
		
	}
	





}
