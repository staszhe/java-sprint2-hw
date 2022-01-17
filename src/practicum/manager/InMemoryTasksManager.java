package practicum.manager;

import practicum.tasks.Epic;
import practicum.tasks.SubTask;
import practicum.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTasksManager implements TaskManager {
    HashMap<Long, SubTask> subTasks;
    HashMap<Long, Epic> epics;
    HashMap<Long, Task> tasks;

    public InMemoryTasksManager() {
        subTasks = new HashMap<>();
        epics = new HashMap<>();
        tasks = new HashMap<>();
    }

    @Override
    public void printAllTask() {
        if (!tasks.isEmpty()) {
            for (Task task : tasks.values()) {
                System.out.println(task);
            }
        } else {
            System.out.println("Задачи не найдены");
        }
    }

    @Override
    public void printAllEpic() {
        if (!epics.isEmpty()) {
            for (Epic Epic : epics.values()) {
                System.out.println(Epic);
            }
        } else {
            System.out.println("Эпики не найдены");
        }
    }

    @Override
    public void printSubTasksByEpicId(Long epicId) {
        if (epics.containsKey(epicId) && epics.get(epicId).getSubTasks().size() > 0) {
            for (Long idSubTask : epics.get(epicId).getSubTasks()) {
                System.out.println(subTasks.get(idSubTask));
            }
        } else {
            System.out.println("Id = " + epicId + " данный эпик не найден или не имеет подзадач");
        }
    }

    @Override
    public void printAnyTaskById(Long id) {
        if (epics.containsKey(id)) {
            System.out.println(epics.get(id));
        } else if (subTasks.containsKey(id)) {
            System.out.println(subTasks.get(id));
        } else if (tasks.containsKey(id)) {
            System.out.println(tasks.get(id));
        } else {
            System.out.println("Id = " + id + " отсутвует во всех типах задач");
        }
    }

    @Override
    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void addSubTask(SubTask subTask) {
        if (epics.containsKey(subTask.getEpicId())) {
            subTasks.put(subTask.getId(), subTask);
            addSubTaskToEpic(epics.get(subTask.getEpicId()), subTask.getId());
            updateEpicStatus(epics.get(subTask.getEpicId()));
        } else {
            System.out.println("Подзадача НЕ добавлена. " +
                    "Связанный с подзадачей Эпик не найден.");
        }
    }

    @Override
    public void addEpic(Epic epic) {
        epic.setStatus("NEW");
        epics.put(epic.getId(), epic);
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateSubTask(SubTask subTask) {
        subTasks.put(subTask.getId(), subTask);
        updateEpicStatus(epics.get(subTask.getEpicId()));
    }

    @Override
    public void updateEpic(Epic epic) {
        epic.setSubTasks(epics.get(epic.getId()).getSubTasks());
        epic.setStatus(epics.get(epic.getId()).getStatus());
        epics.put(epic.getId(), epic);
    }

    @Override
    public void removeAll() {
        tasks.clear();
        subTasks.clear();
        epics.clear();
    }

    @Override
    public void removeById(Long id) {
        if (epics.containsKey(id)) {
            if (epics.get(id).getSubTasks().size() > 0) {
                for (Long subTaskId : epics.get(id).getSubTasks()) {
                    subTasks.remove(subTaskId); //removing subtasks related with removed epic
                }
            }
            epics.remove(id);
        } else if (subTasks.containsKey(id)) {
            Long epicId = subTasks.get(id).getEpicId(); //Epic Id related with removing SubT
            subTasks.remove(id);
            removeSubtaskIdToEpicList(epics.get(epicId), id);
            updateEpicStatus(epics.get(epicId));
        } else if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else {
            System.out.println("Id = " + id + " отсутвует во всех типах задач");
        }
    }

    private void updateEpicStatus(Epic epic) {
        // check subTasks
        int counterStatusNew = 0;
        int counterStatusDone = 0;
        if (epic.getSubTasks().size() == 0) {
            epic.setStatus("NEW");
        } else {
            for (Long subTaskId : epic.getSubTasks()) {
                if (subTasks.get(subTaskId).getStatus().equals("NEW")) {
                    counterStatusNew++;
                } else if (subTasks.get(subTaskId).getStatus().equals("DONE")) {
                    counterStatusDone++;
                }
            }

            if (epic.getSubTasks().size() == counterStatusNew) {
                epic.setStatus("NEW");
            } else if (epic.getSubTasks().size() == counterStatusDone) {
                epic.setStatus("DONE");
            } else {
                epic.setStatus("IN_PROGRESS");
            }
        }
        updateEpic(epic);
    }

    private void addSubTaskToEpic(Epic epic, long idSubTask) {
        ArrayList<Long> idSubTasks = epic.getSubTasks();
        idSubTasks.add(idSubTask);
        epic.setSubTasks(idSubTasks);
        updateEpic(epic);
    }

    private void removeSubtaskIdToEpicList(Epic epic, Long idSubTask) {
        ArrayList<Long> idSubTasks = epic.getSubTasks();
        idSubTasks.remove(idSubTask);
        epic.setSubTasks(idSubTasks);
        updateEpic(epic);
    }
}
