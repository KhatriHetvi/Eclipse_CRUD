package gls.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String eid = request.getParameter("eid");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Delete Employee</title>");
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

		out.println("<h1>Deleted Employee with ID: " + eid + "</h1>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b35", "root", "Hetvi1214");
			PreparedStatement pst = con.prepareStatement("DELETE FROM Emp WHERE eid = " + eid);
			pst.executeUpdate();
			out.println("<h2>Employee Deleted Successfully!</h2>");
			
			// Link back to home page or employee validation page
			String linkUrl = "Validate";
			out.println("<a href='" + linkUrl + "'>Back to Home</a>");
		} catch (Exception e) {
			out.println("<h3>Error Occurred: " + e.getMessage() + "</h3>");
		}

		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
