package Practice_8_SecondPrac;

public class WindowsFileSystemReceiver implements FileSystemReceiver {
    @Override
    public void open() {
        System.out.println("Opening file in Windows OS");
    }

    @Override
    public void write(String data) {
        System.out.println("Writing \"" + data + "\" in Windows OS");
    }
}