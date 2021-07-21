package hw3Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw3Model.Assignment;
import hw3Model.Course;
import hw3Model.Submission;

@WebServlet(urlPatterns = "/DisplaySubmissions", loadOnStartup = 3)
public class DisplaySubmissions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplaySubmissions() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Course> courses = new ArrayList<Course>();
		List<Assignment> assignments = new ArrayList<Assignment>();
		List<Submission> submissions = new ArrayList<Submission>();
		int id = Integer.parseInt(request.getParameter("id")); // id of courses
		int idSeed = id - 1;

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

			for (int i = 0; i < courses.size(); i++) {
				rs = stmt.executeQuery("select * from assignments a where course_id=" + courses.get(i).getId() + ";");

				while (rs.next()) {
					assignments.add(new Assignment(rs.getInt("a.id"), rs.getString("a.name")));
				}
				courses.get(i).setAssignmentEntries(assignments);
			}

			for (int j = 0; j < assignments.size(); j++) {
				rs = stmt.executeQuery(
						"select * from submissions s where assignment_id=" + assignments.get(j).getId() + ";");

				while (rs.next()) {
					submissions.add(new Submission(rs.getString("s.name"), rs.getString("s.answer")));
				}
				assignments.get(j).setSubmissionEntries(submissions);
				assignments.get(j).setSubmissionDate(rs.getTimestamp("post_date"));
				submissions.get(j).setSubmissionDate(rs.getTimestamp("post_date"));
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
//		System.out.println(courses.size() + " size");
//		System.out.println(courses.get(0).getId() +" id");

		request.setAttribute("courses", courses);
		request.setAttribute("idSeed", idSeed);
		request.setAttribute("assignments", assignments);
		request.setAttribute("submissions", submissions);
		request.getRequestDispatcher("/WEB-INF/DisplaySubmissions.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
