package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static final Menu MENU = new Menu();
    private final Map<String, List<String>> menus = new HashMap<>();

    private Menu() {
        List<String[]> categories = List.of(
                new String[]{"일식", "규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼"},
                new String[]{"한식", "김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음"},
                new String[]{"중식", "깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채"},
                new String[]{"아시안", "팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜"},
                new String[]{"양식", "라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니"}
        );

        for (String[] category : categories) {
            String categoryName = category[0];
            String menuString = category[1];
            menus.put(categoryName, List.of(menuString.split(",")));
        }
    }

    public static Menu getMENU(){
        return MENU;
    }

    public String getMenu(String categoryName){
        return Randoms.shuffle(menus.get(categoryName)).get(0);
    }

    public void containMenu(String menuName){
        if (menuName.isEmpty()){
            return;
        }

        if (!checkContainsMenu(menuName)){
            System.out.println("[ERROR] 메뉴의 이름이 정확하지 않습니다.");
            throw new IllegalArgumentException();
        }

    }

    private boolean checkContainsMenu(String menuName){
        for (List<String> menuNames : menus.values()) {
            if (menuNames.contains(menuName)) {
                return true;
            }
        }
        return false;
    }
}
