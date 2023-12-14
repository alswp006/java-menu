package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Category {
    MENU1(1, "일식"),
    MENU2(2, "한식"),
    MENU3(3, "중식"),
    MENU4(4, "아시안"),
    MENU5(5, "양식");

    private final int categoryNumber;
    private final String categoryName;

    Category(int categoryNumber, String categoryName) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
    }

    public static List<String> getCategories() {
        List<String> categorys = new ArrayList<>();

        while (categorys.size() < 5) {
            String categoryName = getCategoryName();

            if (Collections.frequency(categorys, categoryName) > 1){
                continue;
            }

            categorys.add(categoryName);
        }

        return categorys;
    }

    private static String getCategoryName(){
        int categoryNumber = Randoms.pickNumberInRange(1, 5);

        return Arrays.stream(Category.values())
                .filter(category -> category.categoryNumber == categoryNumber)
                .findFirst()
                .map(category -> category.categoryName)
                .orElse(null);
    }


}
