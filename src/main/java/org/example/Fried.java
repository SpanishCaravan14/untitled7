package org.example;

import java.util.List;

public class Fried {
    List<String> friendsList;

    public Fried(List<String> friendsList) {
        this.friendsList = friendsList;
    }
    public int getListSize(){
        return friendsList.size();
    }
}
