import java.util.ArrayList;

public class EpicTask extends Task {
    private ArrayList<Long> idOfSubTasks;

    public EpicTask(long id, String name, String description) {
        super(id, name, description, null);
        this.idOfSubTasks = new ArrayList<>();
    }

    public ArrayList<Long> getIdOfSubTask() {
        return idOfSubTasks;
    }

    public void setIdOfSubTask(ArrayList<Long> idOfSubTask) {
        this.idOfSubTasks = idOfSubTask;
    }

    @Override
    public String toString() {
        return "EpicTask{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", status='" + this.getStatus() + '\'' +
                ", idOfSubTasks=" + idOfSubTasks +
                '}';
    }
}
