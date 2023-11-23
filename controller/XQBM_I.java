package controller;
import model.*;
public interface XQBM_I {
    void addInterestClass();
    void viewInterestClassList();
    void viewDetailedInterestClass();
    void modifyInterestClass();
    void deleteInterestClass();
    XQB findInterestClassById(int classId);
}

