package Practice_8_SecondPrac;

public class OpenCommand implements Command {
    private FileSystemReceiver fileSystemReceiver;

    public OpenCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        fileSystemReceiver.open();
    }
}