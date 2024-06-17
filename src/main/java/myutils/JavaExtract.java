package myutils;
import java.io.File;
import java.util.LinkedList;
public class JavaExtract {
    public LinkedList<String> GetDirectory(String path) {
        File file = new File(path);
        LinkedList<File> dirList = new LinkedList<>();
        LinkedList<String> fileList = new LinkedList<>();
        getOneDir(file, dirList, fileList);
        File tmp;
        while (!dirList.isEmpty()) {
            tmp = dirList.removeFirst();
            getOneDir(tmp, dirList, fileList);
        }
        return fileList;
    }

    private void getOneDir(File file, LinkedList<File> dirList, LinkedList<String> fileList) {
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                dirList.add(f);
            } else if(f.getName().endsWith(".java") || f.getName().endsWith(".ts")){
                //Here lists all files in the root directory of the current folder and adds them to the fileList list
                fileList.add(f.getPath());
            }
        }
    }
}
