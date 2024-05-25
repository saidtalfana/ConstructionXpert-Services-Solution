package DaoImp;

import Connection.Connection_db;
import DAO.TaskDao;
import Model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImp implements TaskDao {

    private static final String INSERT_TASK_SQL = "INSERT INTO task (description, startDate, endDate, statut, resources, projectId) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_TASK_SQL = "UPDATE task SET description = ?, startDate = ?, endDate = ?, statut = ?, resources = ? WHERE taskId = ?;";
    private static final String DELETE_TASK_SQL = "DELETE FROM task WHERE taskId = ?;";
    private static final String SELECT_ALL_TASK_SQL = "SELECT * FROM task WHERE projectId = ?;";
    private static final String SELECT_TASK_BY_ID_SQL = "SELECT * FROM task WHERE taskId = ?;";

    @Override
    public void addTask(Task task) throws SQLException {
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TASK_SQL)) {
            statement.setString(1, task.getDescription());
            statement.setString(2, task.getStartDate());
            statement.setString(3, task.getEndDate());
            statement.setString(4, task.getStatut());
            statement.setString(5, task.getResources());
            statement.setInt(6, task.getProjectId());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean updateTask(Task task) throws SQLException {
        boolean isUpdated;
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TASK_SQL)) {
            statement.setString(1, task.getDescription());
            statement.setString(2, task.getStartDate());
            statement.setString(3, task.getEndDate());
            statement.setString(4, task.getStatut());
            statement.setString(5, task.getResources());
            statement.setInt(6, task.getTaskId());
            isUpdated = statement.executeUpdate() > 0;
        }
        return isUpdated;
    }

    @Override
    public void deleteTask(int taskId) throws SQLException {
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TASK_SQL)) {
            statement.setInt(1, taskId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Task> selectAllTasks(int projectId) throws SQLException {
        List<Task> allTasks = new ArrayList<>();
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_TASK_SQL)) {
            statement.setInt(1, projectId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int taskId = rs.getInt("taskId");
                    String description = rs.getString("description");
                    String startDate = rs.getString("startDate");
                    String endDate = rs.getString("endDate");
                    String statut = rs.getString("statut");
                    String resources = rs.getString("resources");
                    int pId = rs.getInt("projectId");
                    allTasks.add(new Task(taskId, description, startDate, endDate, statut, resources, pId));
                }
            }
        }
        return allTasks;
    }

    @Override
    public Task selectTaskById(int taskId) throws SQLException {
        Task task = null;
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_TASK_BY_ID_SQL)) {
            statement.setInt(1, taskId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String description = rs.getString("description");
                    String startDate = rs.getString("startDate");
                    String endDate = rs.getString("endDate");
                    String statut = rs.getString("statut");
                    String resources = rs.getString("resources");
                    int pId = rs.getInt("projectId");
                    task = new Task(taskId, description, startDate, endDate, statut, resources, pId);
                }
            }
        }
        return task;
    }
}
