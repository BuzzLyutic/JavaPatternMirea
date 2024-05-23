package Practice_8_SecondPrac;

public class WriteCommand implements Command {
    private FileSystemReceiver fileSystemReceiver;
    private String data;

    public WriteCommand(FileSystemReceiver fileSystemReceiver, String data) {
        this.fileSystemReceiver = fileSystemReceiver;
        this.data = data;
    }

    @Override
    public void execute() {
        fileSystemReceiver.write(data);
    }
}