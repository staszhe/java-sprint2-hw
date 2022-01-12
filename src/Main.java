// Спасибо, Роза

import practicum.tasks.SubTask;
import practicum.tasks.Epic;
import practicum.tasks.Task;
import practicum.manager.TaskManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Пришло время практики!");
        TaskManager taskManager = new TaskManager();


        // Проверка кода
        long counter = 1;
        Epic ep1 = new Epic(counter, "Эпик" + counter, "sdasd");
        counter++;
        taskManager.addEpic(ep1);

        Epic ep2 = new Epic(counter, "Эпик" + counter, "sdasd");
        counter++;
        taskManager.addEpic(ep2);

        Epic ep3 = new Epic(counter, "Эпик" + counter, "sdasd");
        counter++;
        taskManager.addEpic(ep3);

        SubTask ep4 = new SubTask(counter, "Подзадача" + counter, "sdasd", "NEW", 3);
        counter++;
        taskManager.addSubTask(ep4);

        SubTask ep5 = new SubTask(counter, "Подзадача" + counter, "sdasd", "IN_PROGRESS", 3);
        counter++;
        taskManager.addSubTask(ep5);

        SubTask ep5dot5 = new SubTask(5L, "Подзадача5", "sdasd", "DONE", 3);
        taskManager.updateSubTask(ep5dot5);

        Task ep6 = new Task(counter, "Задача" + counter, "sdasd", "IN_PROGRESS");
        taskManager.addTask(ep6);
        Task ep6dot6 = new Task(counter, "Задача" + counter, "sdasd", "DONE");
        taskManager.addTask(ep6dot6);

        Epic ep3dot3 = new Epic(3L, "Update", "sdasd");
        taskManager.updateEpic(ep3dot3);

        //taskManager.removeById(6L);
        //taskManager.removeById(4L);
        //taskManager.removeById(5L);

        taskManager.printAllEpic();
        taskManager.printSubTasksByEpicId(3L);
        taskManager.printAnyTaskById(4L);
        taskManager.printAllTask();
        // Конец проверки

    }
}
