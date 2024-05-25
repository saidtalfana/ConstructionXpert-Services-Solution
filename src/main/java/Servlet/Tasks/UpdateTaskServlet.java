package Servlet.Tasks;

import DaoImp.TaskDaoImp;
import Model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateTaskServlet")
public class UpdateTaskServlet extends HttpServlet {
    private TaskDaoImp taskDao;

    @Override
    public void init() {
        taskDao = new TaskDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tId = Integer.parseInt(request.getParameter("taskId"));
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        try {
            Task task = taskDao.selectTaskById(tId);
            request.setAttribute("task", task);
            request.setAttribute("projectId", projectId);
            request.getRequestDispatcher("/WEB-INF/Tasks/updateTask.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving task", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        String description = request.getParameter("description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String statut = request.getParameter("status");
        String resources = request.getParameter("resources");

        Task task = new Task();
        task.setDescription(description);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setStatut(statut);
        task.setResources(resources);
        task.setTaskId(taskId);

        try {
            taskDao.updateTask(task);
            response.sendRedirect(request.getContextPath() + "/ListTasksServlet?projectId=" + projectId);
        } catch (SQLException e) {
            throw new ServletException("Error updating task", e);
        }
    }
}
