package ru.gb.family_tree.model.fileHandler;

import ru.gb.family_tree.model.familyTree.FamilyTree;
import ru.gb.family_tree.model.familyTree.FamilyTreeItem;

import java.io.*;

public class FileHandler<T extends FamilyTreeItem<T>> implements Writable {
    public void save(FamilyTree<T> familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
    public FamilyTree<T> load() throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("familyTree.out"));
        FamilyTree<T> restored = (FamilyTree<T>) objectInputStream.readObject();
        objectInputStream.close();
        return restored;
    }
}
