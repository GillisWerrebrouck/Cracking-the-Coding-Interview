import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Object-oriented design for an in memory file system.
 * 
 * @author Gillis Werrebrouck
 */

public class File_System {
    public static void main(final String args[]) {
        
    }
}

abstract class Item {
    protected Directory parent;
    protected String name;
    protected LocalDate created;
    protected LocalDate lastModified;
    protected LocalDate lastAccessed;
    public abstract int getSize();

    public Item(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.created = LocalDate.now();
        this.lastModified = LocalDate.now();
        this.lastAccessed = LocalDate.now();
    }

    public boolean delete() {
        if (this.parent == null) {
            return false;
        }
        return parent.deleteItem(this);
    }

    public String getFullPath() {
        if (this.parent == null) {
            return this.name;
        }
        return this.parent.getFullPath() + '/' + this.name;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getLastAccessed() {
        return lastAccessed;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public void setLastAccessed(LocalDate lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class File extends Item {
    private String data;
    private int size;

    public File(String name, Directory parent, int size) {
        super(name, parent);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

class Directory extends Item {
    protected ArrayList<Item> items;

    public Directory(String name, Directory parent) {
        super(name, parent);
    }

    public int getSize() {
        int size = 0;
        for (Item i : this.items) {
            size += i.getSize();
        }
        return size;
    }

    public boolean deleteItem(Item item) {
        return this.items.remove(item);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}