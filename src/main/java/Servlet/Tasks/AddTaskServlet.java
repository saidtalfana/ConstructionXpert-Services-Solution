package Servlet.Tasks;

import DaoImp.ProjectDaoImp;
import DaoImp.TaskDaoImp;
import Model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
    private TaskDaoImp taskDao;
    private ProjectDaoImp projectDao;

    @Override
    public void init() {
        taskDao = new TaskDaoImp();
        projectDao = new ProjectDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int projectId = Integer.parseInt(request.getParameter("projectId"));
            request.setAttribute("projectId", projectId);
            request.getRequestDispatcher("/WEB-INF/Tasks/addTask.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String statut = request.getParameter("tatus");
        String resources = request.getParameter("resources");
        int projectId = Integer.parseInt(request.getParameter("projectId"));

        Task task = new Task();
        task.setDescription(description);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setStatut(statut);
        task.setResources(resources);
        task.setProjectId(projectId);

        try {
            taskDao.addTask(task);
            response.sendRedirect(request.getContextPath() + "/ListTasksServlet?projectId=" + projectId);
        } catch (SQLException e) {
            throw new ServletException("Error adding task", e);
        }
    }
}
