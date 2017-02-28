package lesson6._home.task5;

import java.io.File;
import java.util.*;

/**
 * Created by artem on 15.02.17.
 */

public class FolderWatcher implements Runnable {
    private String folderStr;
    private File folder;
    private HashSet<String> oldFolderState = new HashSet<>();
    private HashSet<String> newFolderState = new HashSet<>();

    public FolderWatcher() {
    }

    public FolderWatcher(String folderStr) {
        this.folderStr = folderStr;
        setFolderStr(this.folderStr);
    }

    public String getFolderStr() {
        return this.folderStr;
    }

    public void setFolderStr(String folderStr) {
        File folder = new File(folderStr);
        if (folder.exists()) {
            if (folder.isDirectory()) {
                this.folder = folder;
                return;
            }
        }
        System.out.println("Folder '" + folderStr + "' doesn't exist");
        System.exit(1);
    }

    public void watch() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            String[] content = this.folder.list();
            if(content != null) {
                Collections.addAll(this.newFolderState, content);
            }
            if(this.newFolderState.size() > this.oldFolderState.size()) {
                this.newFolderState.removeAll(this.oldFolderState);
                System.out.println("Added:");
                this.newFolderState.forEach(System.out::println);
                this.oldFolderState.addAll(this.newFolderState);
            } else if(this.newFolderState.size() < this.oldFolderState.size()) {
                this.oldFolderState.removeAll(this.newFolderState);
                System.out.println("Removed:");
                this.oldFolderState.forEach(System.out::println);
                this.oldFolderState = (HashSet)this.newFolderState.clone();
            }
            this.newFolderState.clear();
        }
    }

    @Override
    public void run() {
        String[] content = this.folder.list();
        if(content != null) {
            Collections.addAll(this.oldFolderState, content);
        }
        watch();
    }
}
