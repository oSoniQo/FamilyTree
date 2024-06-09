package ru.gb.family_tree.model.fileHandler;

import ru.gb.family_tree.model.familyTree.FamilyTree;
import ru.gb.family_tree.model.familyTree.FamilyTreeItem;

import java.io.IOException;

public interface FileWritable<T extends FamilyTreeItem<T>>  {

    void save(FamilyTree<T> familyTree) throws IOException;

    FamilyTree<T> load() throws IOException, ClassNotFoundException;
}

