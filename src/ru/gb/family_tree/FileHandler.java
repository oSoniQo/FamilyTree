package ru.gb.family_tree;

import java.io.*;

public class FileHandler implements Writable, Serializable {
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
