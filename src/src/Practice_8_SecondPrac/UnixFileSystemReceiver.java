package Practice_8_SecondPrac;

public class UnixFileSystemReceiver implements FileSystemReceiver {
    @Override
    public void open() {
        System.out.println("Opening file in Unix OS");
    }

    @Override
    public void write(String data) {
        System.out.println("Writing \"" + data + "\" in Unix OS");
    }
}
