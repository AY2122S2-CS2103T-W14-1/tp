package seedu.address.storage;

import java.util.LinkedList;

public class PreviousCommands {
    private LinkedList<String> previousCommands = new LinkedList<>();
    private int location = 0;

    public PreviousCommands() {
    }

    public void addCommand(String input) {
        previousCommands.add(input);
    }

    public String showCommand(int x) {
        return previousCommands.get(x + 1);
    }

    public String getPreviousCommand(boolean isPrev) {
        if (isPrev) {
            location--;
        } else {
            location++;
        }

        if (location < 0 || location > previousCommands.size()) {
            return "";
        } else {
            return showCommand(location);
        }
    }

    public void resetLocation() {
        location = previousCommands.size();
    }
}
