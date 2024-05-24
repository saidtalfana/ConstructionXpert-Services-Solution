package Model;

public class Resource {
    private int resourceId;
    private String name;
    private String type;
    private int quantity;
    private String provider;
    private int taskId;


    public Resource() {
    }

    public Resource(String name, String type, int quantity, String provider, int taskId) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.provider = provider;
        this.taskId = taskId;
    }

    public Resource(int resourceId, String name, String type, int quantity, String provider, int taskId) {
        this.resourceId = resourceId;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.provider = provider;
        this.taskId = taskId;
    }


    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
