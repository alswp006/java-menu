package menu.model;

import java.util.*;

public class Coach {

    List<String> coachMenus = new ArrayList<>();
    List<String> notEatMenu;

    public Coach(List<String> notEatMenu){
        this.notEatMenu = new ArrayList<>(notEatMenu);
    }

    public void putMenu(List<String> categorys, Menu menu){
        for (String category : categorys){
            String createdMenu = createRandomMenu(category, menu);
            coachMenus.add(createdMenu);
        }
    }

    private String createRandomMenu(String categoryName, Menu menu){
        while(true){
            String createdMenu = menu.getMenu(categoryName);

            if (validate(createdMenu)){
                return createdMenu;
            }
        }
    }

    private boolean validate(String createdMenu){
        if (notEatMenu.contains(createdMenu) || coachMenus.contains(createdMenu)){
            return false;
        }
        return true;
    }

    public String getResult(String coachName) {
        return String.format("[ %s | %s ]",
                    coachName,
                    String.join(" | ", coachMenus));
    }
}
