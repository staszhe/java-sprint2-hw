package practicum.manager;

import practicum.tasks.Epic;
import practicum.tasks.SubTask;
import practicum.tasks.Task;

public interface TaskManager {

    void printAllTask();

    void printAllEpic();

    void printSubTasksByEpicId(Long epicId);

    void printAnyTaskById(Long id);

    void addTask(Task task);

    void addSubTask(SubTask subTask);

    void addEpic(Epic epic);

    void updateTask(Task task);

    void updateSubTask(SubTask subTask);

    void updateEpic(Epic epic);

    void removeAll();

    void removeById(Long id);

    void printHistory();

}
