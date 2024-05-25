package DaoImp;

import Connection.Connection_db;
import DAO.ResourceDao;
import Model.Resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceDaoImp implements ResourceDao {

    private static final String INSERT_RESOURCE_SQL = "INSERT INTO resource (name, type, quantity, provider, taskId) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_RESOURCE_SQL = "UPDATE resource SET name = ?, type = ?, quantity = ?, provider = ? WHERE resourceId = ?;";
    private static final String DELETE_RESOURCE_SQL = "DELETE FROM resource WHERE resourceId = ?;";
    private static final String SELECT_ALL_RESOURCE_SQL = "SELECT * FROM resource WHERE taskId = ?;";
    private static final String SELECT_RESOURCE_BY_ID_SQL = "SELECT * FROM resource WHERE resourceId = ?;";

    @Override
    public void addResource(Resource resource) throws SQLException {
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_RESOURCE_SQL)) {
            statement.setString(1, resource.getName());
            statement.setString(2, resource.getType());
            statement.setInt(3, resource.getQuantity());
            statement.setString(4, resource.getProvider());
            statement.setInt(5, resource.getTaskId());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean updateResource(Resource resource) throws SQLException {
        boolean isUpdated;
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_RESOURCE_SQL)) {
            statement.setString(1, resource.getName());
            statement.setString(2, resource.getType());
            statement.setInt(3, resource.getQuantity());
            statement.setString(4, resource.getProvider());
            statement.setInt(5, resource.getResourceId());
            isUpdated = statement.executeUpdate() > 0;
        }
        return isUpdated;
    }

    @Override
    public void deleteResource(int resourceId) throws SQLException {
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_RESOURCE_SQL)) {
            statement.setInt(1, resourceId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Resource> selectAllResources(int taskId) throws SQLException {
        List<Resource> allResources = new ArrayList<>();
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_RESOURCE_SQL)) {
            statement.setInt(1, taskId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int resourceId = rs.getInt("resourceId");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int quantity = rs.getInt("quantity");
                String provider = rs.getString("provider");
                allResources.add(new Resource(resourceId, name, type, quantity, provider, taskId));
            }
        }

        return allResources;
    }

    @Override
    public Resource selectResourceById(int resourceId) throws SQLException {
        Resource resource = null;
        try (Connection connection = Connection_db.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_RESOURCE_BY_ID_SQL)) {
            statement.setInt(1, resourceId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String type = rs.getString("type");
                    int quantity = rs.getInt("quantity");
                    String provider = rs.getString("provider");
                    int taskId = rs.getInt("taskId");
                    resource = new Resource(resourceId, name, type, quantity, provider, taskId);
                }
            }
        }
        return resource;
    }
}
