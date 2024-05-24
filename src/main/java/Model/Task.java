package Model;

public class Task {
    private int taskId;
    private String description;
    private String startDate;
    private String endDate;
    private String statut;
    private String resources;
    private int projectId;

    public Task() {
    }

    public Task(int taskId, String description, String startDate, String endDate, String statut, String resources, int projectId) {
        this.taskId = taskId;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statut = statut;
        this.resources = resources;
        this.projectId = projectId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    // Corrected constructor
    public Task(String description, String startDate, String endDate, String statut, String resources, int projectId) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statut = statut;
        this.resources = resources;
        this.projectId = projectId;
    }
}
