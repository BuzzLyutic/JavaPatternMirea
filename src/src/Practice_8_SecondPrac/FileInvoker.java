package Practice_8_SecondPrac;

public class FileInvoker {
    private Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}
