package seedu.address.storage;

import java.util.LinkedList;

public class PreviousCommands {
    private LinkedList<String> previous_commands = new LinkedList<>();
    private int location;

    public PreviousCommands() {
    }

    public void addCommand(String input) {
        previous_commands.add(input);
    }

    public String showCommand(int x) {
        return previous_commands.get(x + 1);
    }

    public String getPreviousCommand(boolean isPrev) {
        if (isPrev) {
            location--;
        } else {
            location++;
        }

        if (location < 0 && location >= previous_commands.size()) {
            return "";
        } else {
            return showCommand(location);
        }
    }

    public void resetLocation() {
        location = previous_commands.size();
    }
}
