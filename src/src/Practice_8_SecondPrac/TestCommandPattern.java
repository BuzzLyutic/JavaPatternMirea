package Practice_8_SecondPrac;

public class TestCommandPattern {
    public static void main(String[] args) {
        FileSystemReceiver unixFileSystemReceiver = new UnixFileSystemReceiver();
        FileSystemReceiver windowsFileSystemReceiver = new WindowsFileSystemReceiver();

        Command openUnixFile = new OpenCommand(unixFileSystemReceiver);
        Command writeUnixFile = new WriteCommand(unixFileSystemReceiver, "Hello Unix");

        Command openWindowsFile = new OpenCommand(windowsFileSystemReceiver);
        Command writeWindowsFile = new WriteCommand(windowsFileSystemReceiver, "Hello Windows");

        FileInvoker invoker = new FileInvoker(openUnixFile);
        invoker.execute();

        invoker = new FileInvoker(writeUnixFile);
        invoker.execute();

        invoker = new FileInvoker(openWindowsFile);
        invoker.execute();

        invoker = new FileInvoker(writeWindowsFile);
        invoker.execute();
    }
}
