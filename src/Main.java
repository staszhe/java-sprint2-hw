// Спасибо, Роза

import practicum.tasks.SubTask;
import practicum.tasks.Epic;
import practicum.tasks.Task;
import practicum.manager.InMemoryTasksManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Пришло время практики!");
        InMemoryTasksManager inMemoryTasksManager = new InMemoryTasksManager();


        // Проверка кода
        long counter = 1;
        Epic ep1 = new Epic(counter, "Эпик" + counter, "sdasd");
        counter++;
        inMemoryTasksManager.addEpic(ep1);

        Epic ep2 = new Epic(counter, "Эпик" + counter, "sdasd");
        counter++;
        inMemoryTasksManager.addEpic(ep2);

        Epic ep3 = new Epic(counter, "Эпик" + counter, "sdasd");
        counter++;
        inMemoryTasksManager.addEpic(ep3);

        SubTask ep4 = new SubTask(counter, "Подзадача" + counter, "sdasd", "NEW", 3);
        counter++;
        inMemoryTasksManager.addSubTask(ep4);

        SubTask ep5 = new SubTask(counter, "Подзадача" + counter, "sdasd", "IN_PROGRESS", 3);
        counter++;
        inMemoryTasksManager.addSubTask(ep5);

        SubTask ep5dot5 = new SubTask(5L, "Подзадача5", "sdasd", "DONE", 3);
        inMemoryTasksManager.updateSubTask(ep5dot5);

        Task ep6 = new Task(counter, "Задача" + counter, "sdasd", "IN_PROGRESS");
        inMemoryTasksManager.addTask(ep6);
        Task ep6dot6 = new Task(counter, "Задача" + counter, "sdasd", "DONE");
        inMemoryTasksManager.addTask(ep6dot6);

        Epic ep3dot3 = new Epic(3L, "Update", "sdasd");
        inMemoryTasksManager.updateEpic(ep3dot3);

        //inMemoryTasksManager.removeById(6L);
        //inMemoryTasksManager.removeById(4L);
        //inMemoryTasksManager.removeById(5L);

        inMemoryTasksManager.printAllEpic();
        inMemoryTasksManager.printSubTasksByEpicId(3L);
        inMemoryTasksManager.printAnyTaskById(4L);
        inMemoryTasksManager.printAllTask();
        // Конец проверки



    }
}
