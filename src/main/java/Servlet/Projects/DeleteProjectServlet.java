package Servlet.Projects;

import DaoImp.ProjectDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteProjectServlet")
public class DeleteProjectServlet extends HttpServlet {
    private ProjectDaoImp projectDao;

    @Override
    public void init() {
        projectDao = new ProjectDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("projectId"));

        try {
            projectDao.deleteProject(id);
        } catch (SQLException e) {
            throw new ServletException("Error deleting project", e);
        }

        response.sendRedirect(request.getContextPath() + "/Projects/listProjects");
    }
}
