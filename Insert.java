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

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Insert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String ename = request.getParameter("ename");
		String esal = request.getParameter("esal");
		String edes = request.getParameter("edes");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b35", "root", "Hetvi1214");
			PreparedStatement pst = con.prepareStatement("INSERT INTO Emp (ename, esal, edes) VALUES (?, ?, ?)");
			
			pst.setString(1, ename);
			pst.setString(2, esal);
			pst.setString(3, edes);
			pst.executeUpdate();

			// Start of HTML output with embedded CSS
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Added</title>");
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
			out.println("  font-size: 18px;");
			out.println("  text-decoration: none;");
			out.println("  padding: 10px 20px;");
			out.println("  border: 2px solid white;");
			out.println("  border-radius: 5px;");
			out.println("  display: inline-block;");
			out.println("  margin: 10px;");
			out.println("}");
			out.println("a:hover {");
			out.println("  background-color: rgba(255, 255, 255, 0.2);");
			out.println("}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");

			// Display success message
			out.println("<h1>Employee Successfully Added</h1>");

			// Links to other actions
			out.println("<a href='Validate'>Show Employees</a>");
			out.println("<a href='index.jsp'>Home</a>");

			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
