public class SubTask extends Task {
    private long idOfEpicTask;

    public SubTask(long id, String name, String description, String status, long idOfEpicTask) {
        super(id, name, description, status);
        this.idOfEpicTask = idOfEpicTask;
    }

    public long getIdOfEpicTask() {
        return idOfEpicTask;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", status='" + this.getStatus() + '\'' +
                ", idOfEpicTask=" + idOfEpicTask +
                '}';
    }
}
