package DaoImp;

import Connection.Connection_db;
import DAO.ProjectDao;
import Model.Project;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImp implements ProjectDao {

    private static final String INSERT_PROJECT_SQL = "INSERT INTO project (name, description, startDate, endDate, budget) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_PROJECT_SQL = "UPDATE project SET name = ?, description = ?, startDate = ?, endDate = ?, budget = ? WHERE projectId = ?;";
    private static final String DELETE_PROJECT_SQL = "DELETE FROM project WHERE projectId = ?;";
    private static final String SELECT_ALL_PROJECT_SQL = "SELECT * FROM project;";
    private static final String SELECT_PROJECT_BY_ID_SQL = "SELECT * FROM project WHERE projectId = ?;";

    @Override
    public void addProject(Project project) throws SQLException {
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT_SQL)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, Date.valueOf(project.getStartDate()));
            statement.setDate(4, Date.valueOf(project.getEndDate()));
            statement.setDouble(5, project.getBudget());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean updateProject(Project project) throws SQLException {
        boolean isUpdated;
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PROJECT_SQL)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, Date.valueOf(project.getStartDate()));
            statement.setDate(4, Date.valueOf(project.getEndDate()));
            statement.setDouble(5, project.getBudget());
            statement.setInt(6, project.getProjectId());
            isUpdated = statement.executeUpdate() > 0;
        }
        return isUpdated;
    }

    @Override
    public void deleteProject(int projectId) throws SQLException {
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT_SQL)) {
            statement.setInt(1, projectId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Project> selectAllProjects() throws SQLException {
        List<Project> allProjects = new ArrayList<>();
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PROJECT_SQL);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int projectId = rs.getInt("projectId");
                String name = rs.getString("name");
                String description = rs.getString("description");
                LocalDate startDate = rs.getDate("startDate").toLocalDate();
                LocalDate endDate = rs.getDate("endDate").toLocalDate();
                double budget = rs.getDouble("budget");
                allProjects.add(new Project(projectId, name, description, startDate, endDate, budget));
            }
        }
        return allProjects;
    }

    @Override
    public Project selectProjectById(int projectId) throws SQLException {
        Project project = null;
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT_BY_ID_SQL)) {
            statement.setInt(1, projectId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    LocalDate startDate = rs.getDate("startDate").toLocalDate();
                    LocalDate endDate = rs.getDate("endDate").toLocalDate();
                    double budget = rs.getDouble("budget");
                    project = new Project(projectId, name, description, startDate, endDate, budget);
                }
            }
        }
        return project;
    }
}
