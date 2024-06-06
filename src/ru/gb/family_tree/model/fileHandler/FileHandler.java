package ru.gb.family_tree.model.fileHandler;

import ru.gb.family_tree.model.familyTree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {
    public void save(FamilyTree familyTree) throws IOException, ClassNotFoundException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
    public FamilyTree load() throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("familyTree.out"));
        FamilyTree restored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return restored;
    }
}
