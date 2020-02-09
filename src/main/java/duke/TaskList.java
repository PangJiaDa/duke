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

    public void add(Task toAdd) {
        tasks.add(toAdd);
        System.out.println("Got it. I've added this task:");
        System.out.println(toAdd);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void done(int doneIndex) {
        // doneIndex is 0-indexed
        tasks.get(doneIndex).markAsDone();
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(tasks.get(doneIndex));
    }

    public void delete(int deleteIndex) {
        // deleteIndex is 0-indexed
        System.out.println("Noted. I've removed this task:");
        System.out.println(tasks.remove(deleteIndex));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void list() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
    }

    public void findAndPrint(String searchPhrase) {
        // filter tasks on description
        List<Task> foundTasks = this.tasks.stream()
                .filter(task -> task.getDescription().contains(searchPhrase))
                .collect(Collectors.toList());

        // print the tasks
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < foundTasks.size(); i++) {
            System.out.println((i + 1) + ". " + foundTasks.get(i).toString());
        }
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}
