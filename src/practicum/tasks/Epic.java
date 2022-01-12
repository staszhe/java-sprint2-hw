package practicum.tasks;

import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    private ArrayList<Long> subTasks;

    public Epic(long id, String name, String description) {
        super(id, name, description, null);
        this.subTasks = new ArrayList<>();
    }

    public ArrayList<Long> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(ArrayList<Long> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public String toString() {
        return "practicum.tasks.Epic{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", status='" + this.getStatus() + '\'' +
                ", subTasks=" + this.getSubTasks() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subTasks, epic.subTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subTasks);
    }
}
