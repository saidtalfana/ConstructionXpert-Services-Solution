package DAO;

import Model.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
    void addProject(Project project) throws SQLException;
    boolean updateProject(Project project) throws SQLException;
    void deleteProject(int projectId) throws SQLException;
    List<Project> selectAllProjects() throws SQLException;
    Project selectProjectById(int projectId) throws SQLException;
}
