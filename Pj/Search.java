package nozama;

import java.util.ArrayList;

class Search {
    public int search(ArrayList<User> users, String userName){
        
        for(int i = 0; i<users.size(); i++){
            if(users.get(i).getUser().equals(userName)) return i;
        }
        return -1;
    }
}