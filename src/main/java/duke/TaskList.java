package duke;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds the given task to the TaskList and returns a response message.
     * @param toAdd the task to be added
     * @return response message to be printed to the user
     */
    public String add(Task toAdd) {
        tasks.add(toAdd);
        String responseMessage = "";
        responseMessage += "Got it. I've added this task:\n";
        responseMessage += toAdd.toString() + "\n";
        responseMessage += "Now you have " + tasks.size() + " tasks in the list.\n";

        return responseMessage;
    }

    /**
     * Marks the task at doneIndex as done and returns a response message. doneIndex is 0-indexed.
     * @param doneIndex the 0-indexed index of the task to be marked as done.
     * @return response message to be printed to the user
     * @throws IndexOutOfBoundsException when doneIndex is out of bounds for the tasks in the TaskList
     */
    public String done(int doneIndex) throws IndexOutOfBoundsException {
        assert doneIndex >= 0 && doneIndex < tasks.size() : "done task index out of bounds";
        tasks.get(doneIndex).markAsDone();
        String responseMessage = "";
        responseMessage += "Nice! I've marked this task as done: \n";
        responseMessage += tasks.get(doneIndex).toString() + "\n";

        return responseMessage;
    }

    /**
     * Marks the task at undoIndex as undone and returns a response message. undoIndex is 0-indexed.
     * @param undoIndex the 0-indexed index of the task to be marked as undone.
     * @return response message to be printed to the user
     * @throws IndexOutOfBoundsException when undoIndex is out of bounds for the tasks in the TaskList
     */
    public String undo(int undoIndex) throws IndexOutOfBoundsException {
        tasks.get(undoIndex).markAsUndone();
        String responseMessage = "";
        responseMessage += "Okay, I've marked this task as undone: \n";
        responseMessage += tasks.get(undoIndex).toString() + "\n";

        return responseMessage;
    }

    /**
     * Deletes the task at deleteIndex as done and returns a response message. deleteIndex is 0-indexed.
     * @param deleteIndex the 0-indexed index of the task to be deleted.
     * @return response message to be printed to the user
     */
    public String delete(int deleteIndex) throws IndexOutOfBoundsException {
        assert deleteIndex >= 0 && deleteIndex < tasks.size() : "delete task index out of bounds";
        // deleteIndex is 0-indexed
        String responseMessage = "";
        responseMessage += "Noted. I've removed this task:\n";
        responseMessage += tasks.remove(deleteIndex).toString() + "\n";
        responseMessage += "Now you have " + tasks.size() + " tasks in the list.\n";

        return responseMessage;
    }

    /**
     * Returns the task list as a formatted string to be printed.
     * @return the task list as a formatted string
     */
    public String list() {
        if (tasks.isEmpty()) {
            return "You currently have no saved tasks.";
        } else {
            String listAsString = "Here are the tasks I've remembered.\n";
            for (int i = 0; i < tasks.size(); i++) {
                listAsString += (i + 1) + ". " + tasks.get(i).toString() + "\n";
            }
            return listAsString;
        }
    }

    /**
     * Returns all the tasks whose descriptions contain the search phrase
     * provided as a formatted string to be printed.
     * @param searchPhrase string to be searched in the task's description.
     * @return the list of tasks that contain the search phrase, asa formatted string to be printed
     */
    public String find(String searchPhrase) {
        // filter tasks on description
        List<Task> foundTasks = this.tasks.stream()
                .filter(task -> task.getDescription().toLowerCase().contains(searchPhrase.toLowerCase()))
                .collect(Collectors.toList());

        // print the tasks
        String foundListAsString = "Here are the matching tasks in your list:\n";
        for (int i = 0; i < foundTasks.size(); i++) {
            foundListAsString += (i + 1) + ". " + foundTasks.get(i).toString() + "\n";
        }

        return foundListAsString;
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Deletes all tasks in this TaskList.
     * @return response message to be displayed to user.
     */
    public String clear() {
        tasks.clear();
        return "I have deleted all tasks!";
    }
}
