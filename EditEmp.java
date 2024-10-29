package gls.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditEmp")
public class EditEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditEmp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Getting employee data from the request
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String esal = request.getParameter("esal");
		String edes = request.getParameter("edes");

		// Start of HTML output with embedded CSS
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Employee</title>");
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
		out.println("  font-size: 36px;");
		out.println("  text-transform: uppercase;");
		out.println("}");
		out.println("table {");
		out.println("  margin: 0 auto;");
		out.println("  border-collapse: collapse;");
		out.println("  font-size: 18px;");
		out.println("}");
		out.println("td {");
		out.println("  padding: 10px;");
		out.println("  color: white;");
		out.println("}");
		out.println("input[type='text'], input[type='submit'] {");
		out.println("  padding: 10px;");
		out.println("  font-size: 16px;");
		out.println("  border: none;");
		out.println("  border-radius: 5px;");
		out.println("}");
		out.println("input[type='submit'] {");
		out.println("  background-color: #4CAF50;");
		out.println("  color: white;");
		out.println("  cursor: pointer;");
		out.println("  transition: background-color 0.3s;");
		out.println("}");
		out.println("input[type='submit']:hover {");
		out.println("  background-color: #45a049;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		// Page content
		out.println("<h1>Edit Employee Details</h1>");
		out.println("<form action='EditAction' method='post'>");
		out.println("<table>");
		out.println("<tr><td><input type='hidden' name='eid' value='" + eid + "'/></td></tr>");
		out.println("<tr><td>Employee Name: </td><td><input type='text' name='ename' value='" + ename + "'/></td></tr>");
		out.println("<tr><td>Employee Salary: </td><td><input type='text' name='esal' value='" + esal + "'/></td></tr>");
		out.println("<tr><td>Employee Designation: </td><td><input type='text' name='edes' value='" + edes + "'/></td></tr>");
		out.println("<tr><td></td><td><input type='submit' value='Edit Employee'></td></tr>");
		out.println("</table>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
