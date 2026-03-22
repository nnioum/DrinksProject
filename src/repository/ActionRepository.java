package repository;

import model.action.Action;

import java.util.ArrayList;
import java.util.List;

public class ActionRepository {
    private final List<Action> ACTION_LIST;
    private static final ActionRepository INSTANCE = new ActionRepository();

    public ActionRepository() {
        ACTION_LIST = new ArrayList<>();
    }

    public ActionRepository getInstance(){
        return INSTANCE;
    }

    public void create(Action action){
        ACTION_LIST.add(action);
    }

    public List<Action> retrieve(){
        return ACTION_LIST;
    }

}
