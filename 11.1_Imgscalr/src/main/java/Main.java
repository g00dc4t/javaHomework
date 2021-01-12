import java.io.File;

public class Main
{
    private static int newWidth = 300;
//        private static String srcFolder = "C:/Users/goodcat/Desktop/src";
//        private static String dstFolder = "C:/Users/goodcat/Desktop/dst";
    private static String srcFolder = "C:/Users/Technolog320/Desktop/src";
    private static String dstFolder = "C:/Users/Technolog320/Desktop/dst";

    public static void main(String[] args)
    {

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

//        int threadsCount = files.length / 6;   //threads count for home pc

        int threadsCount = files.length / 2; //threads count for work pc

//        File[] files1 = new File[threadsCount];
//        System.arraycopy(files, 0, files1, 0, files1.length);
//        main.ImageResizer resizer1 = new main.ImageResizer(files1, newWidth, dstFolder, start);
//        new Thread(resizer1).start();
//        File[] files2 = new File[threadsCount];
//        System.arraycopy(files, files.length - threadsCount * 5, files2, 0, files2.length);
//        main.ImageResizer resizer2 = new main.ImageResizer(files2, newWidth, dstFolder, start);
//        new Thread(resizer2).start();
//        File[] files3 = new File[threadsCount];
//        System.arraycopy(files, files.length - threadsCount * 4, files3, 0, files3.length);
//        main.ImageResizer resizer3 = new main.ImageResizer(files3, newWidth, dstFolder, start);
//        new Thread(resizer3).start();
//        File[] files4 = new File[threadsCount];
//        System.arraycopy(files, files.length - threadsCount * 3, files4, 0, files4.length);
//        main.ImageResizer resizer4 = new main.ImageResizer(files4, newWidth, dstFolder, start);
//        new Thread(resizer4).start();
//        File[] files5 = new File[threadsCount];
//        System.arraycopy(files, files.length - threadsCount * 2, files5, 0, files5.length);
//        main.ImageResizer resizer5 = new main.ImageResizer(files5, newWidth, dstFolder, start);
//        new Thread(resizer5).start();
//        File[] files6 = new File[threadsCount];
//        System.arraycopy(files, files.length - threadsCount, files6, 0, files6.length);
//        main.ImageResizer resizer6 = new main.ImageResizer(files6, newWidth, dstFolder, start);
//        new Thread(resizer6).start();

        File[] files1 = new File[threadsCount];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        new Thread(resizer1).start();
        File[] files2 = new File[threadsCount];
        System.arraycopy(files, files.length - threadsCount, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        new Thread(resizer2).start();


    }
}
