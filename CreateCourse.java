package hw3Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw3Model.Assignment;
import hw3Model.Course;

@WebServlet("/CreateCourse")
public class CreateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateCourse() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// course entries
		List<Course> courses = new ArrayList<Course>();
		// get data from db
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu16?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu16";
			String password = "8ii0Sf.4";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			// get course entries from db
			ResultSet rs = stmt.executeQuery("select * from courses c;");
			while (rs.next()) {
				courses.add(new Course(rs.getInt("c.id"), rs.getString("c.name")));
			}
			// get assignment list of each course from db
			for (int i = 0; i < courses.size(); i++) {
				rs = stmt.executeQuery("select * from assignments a where course_id=" + courses.get(i).getId() + ";");

				List<Assignment> assignments = new ArrayList<Assignment>();
				while (rs.next()) {
					assignments.add(new Assignment(rs.getInt("a.id"), rs.getString("a.name")));
				}

				for (int j = 0; j < assignments.size(); j++) {
					courses.get(i).addAssignment(assignments.get(j));
				}
				courses.get(i).setAssignmentEntries(assignments);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("/WEB-INF/CreateCourse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Course> courses = new ArrayList<Course>();
		String courseName = request.getParameter("coursename");

		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu16?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu16";
			String password = "8ii0Sf.4";
			c = DriverManager.getConnection(url, username, password);
			
			String sql = "insert into courses (name) values(?);";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, courseName);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("DisplayCourses");
	}

}
