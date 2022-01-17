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
        counter++;

        SubTask ep7 = new SubTask(counter, "Подзадача" + counter, "sdasd", "DONE", 1);

        inMemoryTasksManager.addSubTask(ep7);

        Epic ep3dot3 = new Epic(3L, "Update", "sdasd");
        inMemoryTasksManager.updateEpic(ep3dot3);

        //inMemoryTasksManager.removeById(6L);
        //inMemoryTasksManager.removeById(4L);
        //inMemoryTasksManager.removeById(5L);

        inMemoryTasksManager.printAllEpic();
        inMemoryTasksManager.printSubTasksByEpicId(3L);

        System.out.println("______________________________");
        inMemoryTasksManager.printHistory();
        System.out.println("______________________________");

        inMemoryTasksManager.printAnyTaskById(1L);//1
        inMemoryTasksManager.printAnyTaskById(5L);//2
        inMemoryTasksManager.printAnyTaskById(4L);//3
        inMemoryTasksManager.printAnyTaskById(2L);//4
        inMemoryTasksManager.printAnyTaskById(2L);//5
        inMemoryTasksManager.printAnyTaskById(4L);//6
        inMemoryTasksManager.printAnyTaskById(3L);//7
        inMemoryTasksManager.printAnyTaskById(2L);//8
        inMemoryTasksManager.printAnyTaskById(4L);//9
        inMemoryTasksManager.printAnyTaskById(4L);//10
        inMemoryTasksManager.printAnyTaskById(7L);//11


        inMemoryTasksManager.printAllTask();

        System.out.println("______________________________");
        inMemoryTasksManager.printHistory();
        System.out.println("______________________________");
        // Конец проверки



    }
}
