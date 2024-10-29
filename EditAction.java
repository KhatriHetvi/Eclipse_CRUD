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

@WebServlet("/EditAction")
public class EditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditAction() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String esal = request.getParameter("esal");
		String edes = request.getParameter("edes");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b35", "root", "Hetvi1214");
			PreparedStatement pst = con.prepareStatement("UPDATE Emp SET ename=?, esal=?, edes=? WHERE eid=?");

			pst.setString(1, ename);
			pst.setString(2, esal);
			pst.setString(3, edes);
			pst.setString(4, eid);
			pst.executeUpdate();

			// Start of HTML output with embedded CSS
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Updated</title>");
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
			out.println("a {");
			out.println("  color: #ffffff;");
			out.println("  text-decoration: none;");
			out.println("  font-size: 20px;");
			out.println("  background-color: #4CAF50;");
			out.println("  padding: 10px 20px;");
			out.println("  border-radius: 5px;");
			out.println("  transition: background-color 0.3s;");
			out.println("}");
			out.println("a:hover {");
			out.println("  background-color: #45a049;");
			out.println("}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");

			// Page content
			out.println("<h1>Employee Updated Successfully</h1>");
			out.println("<a href='Validate'>View All Employees</a>");

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
		}
	}
}
