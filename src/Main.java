// Спасибо, Роза

import practicum.manager.Manager;
import practicum.manager.TaskManager;
import practicum.tasks.Status;
import practicum.tasks.SubTask;
import practicum.tasks.Epic;
import practicum.tasks.Task;

public class Main {
    public static void main(String[] args) {
        System.out.println("Пришло время практики!");
        TaskManager taskManager = Manager.getDefault();


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

        SubTask ep4 = new SubTask(counter, "Подзадача" + counter, "sdasd", Status.NEW, 3);
        counter++;
        taskManager.addSubTask(ep4);

        SubTask ep5 = new SubTask(counter, "Подзадача" + counter, "sdasd", Status.IN_PROGRESS, 3);
        counter++;
        taskManager.addSubTask(ep5);

        SubTask ep5dot5 = new SubTask(5L, "Подзадача5", "sdasd", Status.DONE, 3);
        taskManager.updateSubTask(ep5dot5);

        Task ep6 = new Task(counter, "Задача" + counter, "sdasd", Status.IN_PROGRESS);
        taskManager.addTask(ep6);
        Task ep6dot6 = new Task(counter, "Задача" + counter, "sdasd", Status.DONE);
        taskManager.addTask(ep6dot6);
        counter++;

        SubTask ep7 = new SubTask(counter, "Подзадача" + counter, "sdasd", Status.DONE, 1);

        taskManager.addSubTask(ep7);

        Epic ep3dot3 = new Epic(3L, "Update", "sdasd");
        taskManager.updateEpic(ep3dot3);

        //taskManager.removeById(6L);
        //taskManager.removeById(4L);
        //taskManager.removeById(5L);
        System.out.println("______________________________");
        taskManager.printAllEpic();
        System.out.println("______________________________");
        taskManager.printSubTasksByEpicId(3L);
        System.out.println("______________________________");
        taskManager.printAllTask();

        System.out.println("______________________________");
        taskManager.printHistory();
        System.out.println("______________________________");

        taskManager.printAnyTaskById(1L);//1
        taskManager.printAnyTaskById(5L);//2
        taskManager.printAnyTaskById(4L);//3
        taskManager.printAnyTaskById(2L);//4
        taskManager.printAnyTaskById(2L);//5
        taskManager.printAnyTaskById(4L);//6
        taskManager.printAnyTaskById(3L);//7
        taskManager.printAnyTaskById(2L);//8
        taskManager.printAnyTaskById(4L);//9
        taskManager.printAnyTaskById(4L);//10
        taskManager.printAnyTaskById(7L);//11

        System.out.println("______________________________");
        taskManager.printHistory();
        System.out.println("______________________________");
        // Конец проверки


    }
}
