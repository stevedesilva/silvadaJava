package commonsense.recursion;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Directory {
    public static List<String> findDirectories(String directory) {
        // for each file in list, if it is a directory add to list and recursive call
        List<String> result = new ArrayList<>();
        findDirectoriesRec(directory,result);
        return result;
    }

    public static void findDirectoriesRec(String directory, List<String> result) {
        File directoryPath = new File(directory);
        final File[] files = directoryPath.listFiles();
        for(File file : files) {
            if(file.isDirectory()) {
                final String absolutePath = file.getAbsolutePath();
                System.out.println(absolutePath);
                result.add(absolutePath);
                findDirectoriesRec(absolutePath,result);
            }
        }
    }
}
