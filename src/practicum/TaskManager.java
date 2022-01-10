package practicum;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    HashMap<Long, SubTask> subTasks;
    HashMap<Long, EpicTask> epics;
    HashMap<Long, Task> tasks;

    public TaskManager() {
        subTasks = new HashMap<>();
        epics = new HashMap<>();
        tasks = new HashMap<>();
    }

    public void printAllTask() {
        if (!tasks.isEmpty()) {
            for (Task task : tasks.values()) {
                System.out.println(task);
            }
        } else {
            System.out.println("Задачи не найдены");
        }
    }

    public void printAllEpic() {
        if (!epics.isEmpty()) {
            for (EpicTask epicTask : epics.values()) {
                System.out.println(epicTask);
            }
        } else {
            System.out.println("Эпики не найдены");
        }
    }

    public void printSubTaskOfEpic(Long id) {
        if (epics.containsKey(id) && epics.get(id).getIdOfSubTask().size() > 0) {
            for (Long idSubTask : epics.get(id).getIdOfSubTask()) {
                System.out.println(subTasks.get(idSubTask));
            }
        } else {
            System.out.println("Id = " + id + " данный эпик не найден или не имеет подзадач");
        }
    }

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

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void addSubTask(SubTask subTask) {
        if (epics.containsKey(subTask.getIdOfEpicTask())) {
            subTasks.put(subTask.getId(), subTask);
            addSubtaskIdToEpicList(epics.get(subTask.getIdOfEpicTask()), subTask.getId());
            updateEpicStatus(epics.get(subTask.getIdOfEpicTask()));
        } else {
            System.out.println("Подзадача НЕ добавлена. " +
                    "Связанный с подзадачей Эпик не найден.");
        }
    }

    public void addEpic(EpicTask epic) {
        epic.setStatus("NEW");
        epics.put(epic.getId(), epic);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateSubTask(SubTask subTask) {
        subTasks.put(subTask.getId(), subTask);
        updateEpicStatus(epics.get(subTask.getIdOfEpicTask()));
    }

    public void updateEpic(EpicTask epic) {
        epic.setIdOfSubTask(epics.get(epic.getId()).getIdOfSubTask());
        epic.setStatus(epics.get(epic.getId()).getStatus());
        epics.put(epic.getId(), epic);
    }

    public void removeAll() {
        tasks.clear();
        subTasks.clear();
        epics.clear();
    }

    public void removeById(Long id) {
        if (epics.containsKey(id)) {
            if (epics.get(id).getIdOfSubTask().size() > 0) {
                for (Long subTaskId : epics.get(id).getIdOfSubTask()) {
                    subTasks.remove(subTaskId); //removing subtasks related with removed epic
                }
            }
            epics.remove(id);
        } else if (subTasks.containsKey(id)) {
            Long epicId = subTasks.get(id).getIdOfEpicTask(); //Epic Id related with removing SubT
            subTasks.remove(id);
            removeSubtaskIdToEpicList(epics.get(epicId), id);
            updateEpicStatus(epics.get(epicId));
        } else if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else {
            System.out.println("Id = " + id + " отсутвует во всех типах задач");
        }
    }

    private void updateEpicStatus(EpicTask epic) {
        // check subTasks
        int counterStatusNew = 0;
        int counterStatusDone = 0;
        if (epic.getIdOfSubTask().size() == 0) {
            epic.setStatus("NEW");
        } else {
            for (Long subTaskId : epic.getIdOfSubTask()) {
                if (subTasks.get(subTaskId).getStatus().equals("NEW")) {
                    counterStatusNew++;
                } else if (subTasks.get(subTaskId).getStatus().equals("DONE")) {
                    counterStatusDone++;
                }
            }

            if (epic.getIdOfSubTask().size() == counterStatusNew) {
                epic.setStatus("NEW");
            } else if (epic.getIdOfSubTask().size() == counterStatusDone) {
                epic.setStatus("DONE");
            } else {
                epic.setStatus("IN_PROGRESS");
            }
        }
        updateEpic(epic);
    }

    private void addSubtaskIdToEpicList(EpicTask epic, long idSubTask) {
        ArrayList<Long> idSubTasks = epic.getIdOfSubTask();
        idSubTasks.add(idSubTask);
        epic.setIdOfSubTask(idSubTasks);
        updateEpic(epic);
    }

    private void removeSubtaskIdToEpicList(EpicTask epic, Long idSubTask) {
        ArrayList<Long> idSubTasks = epic.getIdOfSubTask();
        idSubTasks.remove(idSubTask);
        epic.setIdOfSubTask(idSubTasks);
        updateEpic(epic);
    }
}
