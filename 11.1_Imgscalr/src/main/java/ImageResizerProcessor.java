import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ImageResizerProcessor extends RecursiveAction {

    private File[] files;
    private String srcFolder;
    private String dstFolder;
    private int newWidth;
    private long start;
    private int availableProcessors = Runtime.getRuntime().availableProcessors();

    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final Marker ALL = MarkerManager.getMarker("All");

    public ImageResizerProcessor(File[] files, String srcFolder, String dstFolder, int newWidth, long start) {
        this.files = files;
        this.srcFolder = srcFolder;
        this.dstFolder = dstFolder;
        this.newWidth = newWidth;
        this.start = start;
    }

    @Override
    protected void compute() {
        if (files.length > availableProcessors) {
            ImageResizerProcessor.invokeAll(createSubtasks(files));
        } else {
            imageResizing();
        }
        LOGGER.info(ALL, (System.currentTimeMillis() - start) + " ms");
    }

    private List<ImageResizerProcessor> createSubtasks (File[] files) {
        List<ImageResizerProcessor> subTasks = new ArrayList<>();
        File[] files1 = new File[files.length / 2];
        System.arraycopy(files, 0, files1, 0, files1.length);
        subTasks.add(new ImageResizerProcessor(files1, srcFolder, dstFolder, newWidth, start));
        File[] files2 = new File[files.length - files1.length];
        System.arraycopy(files, files.length - (files.length -files1.length), files2, 0, files2.length);
        subTasks.add(new ImageResizerProcessor(files2, srcFolder, dstFolder, newWidth, start));
        return subTasks;
    }

    private void imageResizing () {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
                BufferedImage newImage = Scalr.resize(image, newWidth, newHeight);    //task with a star

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
        }
    }
}

