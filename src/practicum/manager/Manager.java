package practicum.manager;

public class Manager {

    public static TaskManager getDefault() {
        return new InMemoryTasksManager();
    }
}
