package Servlet.Resources;

import DaoImp.ResourceDaoImp;
import Model.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddResourceServlet")
public class AddResourceServlet extends HttpServlet {
    private ResourceDaoImp resourceDao;

    @Override
    public void init() {
        resourceDao = new ResourceDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        request.setAttribute("taskId", taskId);
        request.getRequestDispatcher("/WEB-INF/Resources/addResource.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String provider = request.getParameter("provider");
        int taskId = Integer.parseInt(request.getParameter("taskId"));

        Resource resource = new Resource();
        resource.setName(name);
        resource.setType(type);
        resource.setQuantity(quantity);
        resource.setProvider(provider);
        resource.setTaskId(taskId);

        try {
            resourceDao.addResource(resource);
            response.sendRedirect(request.getContextPath() + "/ListResourcesServlet?taskId=" + taskId);
        } catch (SQLException e) {
            throw new ServletException("Error adding resource", e);
        }
    }
}
