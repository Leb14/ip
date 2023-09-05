package command;

import ui.Ui;

import storage.TaskList;
import storage.FileHandler;

/**
 * A command to mark a task as not done.
 */
public class UnmarkCommand extends Command{

    private int index;

    /**
     * Constructs a `UnmarkCommand` object with the specified task index.
     *
     * @param index The index of the task to mark as done.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Marks the specified task as not done.
     *
     * @param t  The task list containing the tasks.
     * @param ui The user interface to display the result.
     * @param f  The file handler (not used in this command).
     */
    @Override
    public void execute(TaskList t, Ui ui, FileHandler f) {
        try {
            t.get(index - 1).markNotDone();
            FileHandler.writeTasksToFile(t);
            ui.unmark(index);
        } catch (IndexOutOfBoundsException e) {
            ui.ioobExceptionMessage();
        }
    }

    /**
     * Checks whether the command is an exit command.
     *
     * @return `false` because this command does not exit the application.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}