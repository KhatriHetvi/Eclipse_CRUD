package gls.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Validate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b35", "root", "Hetvi1214");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Emp");
			ResultSet rs = pst.executeQuery();

			// Start HTML output
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Validation</title>");
			out.println("<style>");
			out.println("body {");
			out.println("  background: linear-gradient(to right, #1e3c72, #2a5298);");
			out.println("  color: white;");
			out.println("  font-family: Arial, sans-serif;");
			out.println("  text-align: center;");
			out.println("  padding: 50px;");
			out.println("}");
			out.println("h1 { margin-bottom: 50px; }");
			out.println("a {");
			out.println("  color: white;");
			out.println("  font-size: 20px;");
			out.println("  text-decoration: none;");
			out.println("  padding: 10px 20px;");
			out.println("  border: 2px solid white;");
			out.println("  border-radius: 5px;");
			out.println("  display: inline-block;");
			out.println("  margin-bottom: 20px;");
			out.println("}");
			out.println("a:hover {");
			out.println("  background-color: rgba(255, 255, 255, 0.2);");
			out.println("}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Employee List</h1>");

			// Output the employee details with links
			while (rs.next()) {
				String eid = rs.getString(1);
				String ename = rs.getString(2);
				String esal = rs.getString(3);
				String edes = rs.getString(4);

				String linkUrl = "Details?eid=" + eid + "&ename=" + ename + "&esal=" + esal + "&edes=" + edes;
				out.println("<a href='" + linkUrl + "'>" + ename + "</a><br>");
			}

			// Home link at the bottom
			String homeUrl = "index.jsp";
			out.println("<br><a href='" + homeUrl + "'>Home</a>");

			out.println("</body>");
			out.println("</html>");

			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
