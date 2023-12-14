package menu.controller;

import menu.model.Category;
import menu.model.Coach;
import menu.model.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.*;

public class Controller {
    private final InputView inputView = InputView.getInstance();
    ;
    private final OutputView outputView = OutputView.getInstance();
    private final Menu menu = Menu.getMENU();

    public void play() {
        outputView.printStart();
        List<String> coachNames = inputCoachName();
        Map<String, List<String>> coachNotEatMenu = new HashMap<>(inputCoachNotEatMenu(coachNames));
        Map<String, Coach> coachMenus = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String name : coachNames){
            coachMenus.put(name, new Coach(coachNotEatMenu.get(name)));
        }
        List<String> categories = Category.getCategories();
        coachMenus.values().forEach(coach -> coach.putMenu(categories,menu));
        for (String coachName : coachNames){
            coachMenus.values().forEach(coach -> coach.getResult(coachName));
            result.add(coachMenus.get(coachName).getResult(coachName));
        }
        outputView.printResult(result,categories);
        outputView.printEnd();
    }

    private List<String> inputCoachName() {
        while (true) {
            try {
                List<String> coachName = inputView.inputCoachName();

                return coachName;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private Map<String, List<String>> inputCoachNotEatMenu(List<String> coachNames) {
        Map<String, List<String>> coachNotEatMenu = new HashMap<>();

        for (String coachName : coachNames) {
            List<String> notEatMenu = checkNotEatMenu(coachName);

            coachNotEatMenu.put(coachName, notEatMenu);
        }

        return coachNotEatMenu;
    }

    private List<String> checkNotEatMenu(String coachName){
        while(true){
            try{
                List<String> coachMenus = inputView.inputNotMyStyle(coachName);

                coachMenus.forEach(menu::containMenu);

                return coachMenus;
            }catch (IllegalArgumentException e){}
        }
    }

}