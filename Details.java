package gls.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Details() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String esal = request.getParameter("esal");
		String edes = request.getParameter("edes");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Employee Details</title>");
		out.println("<style>");
		out.println("body {");
		out.println("  background: linear-gradient(to right, #1e3c72, #2a5298);");
		out.println("  color: white;");
		out.println("  font-family: Arial, sans-serif;");
		out.println("  text-align: center;");
		out.println("  padding: 50px;");
		out.println("}");
		out.println("h1 {");
		out.println("  margin-bottom: 30px;");
		out.println("}");
		out.println("a {");
		out.println("  color: white;");
		out.println("  font-size: 20px;");
		out.println("  text-decoration: none;");
		out.println("  padding: 10px 20px;");
		out.println("  border: 2px solid white;");
		out.println("  border-radius: 5px;");
		out.println("  margin: 10px;");
		out.println("  display: inline-block;");
		out.println("}");
		out.println("a:hover {");
		out.println("  background-color: rgba(255, 255, 255, 0.2);");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>Employee Name: " + ename + "</h1>");
		out.println("<h1>Employee Salary: " + esal + "</h1>");
		out.println("<h1>Employee Designation: " + edes + "</h1>");

		String delUrl = "Delete?eid=" + eid;
		out.println("<a href='" + delUrl + "'>Delete</a>");

		String homeUrl = "index.jsp";
		out.println("<a href='" + homeUrl + "'>Home</a>");

		String editUrl = "EditEmp?eid=" + eid;
		out.println("<a href='" + editUrl + "'>Edit</a>");

		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
