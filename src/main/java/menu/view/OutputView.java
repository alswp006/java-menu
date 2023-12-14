package menu.view;

import java.util.Arrays;
import java.util.List;

public enum OutputView {
    INSTANCE;

    public static OutputView getInstance(){
        return INSTANCE;
    }

    public void printStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }
    public void printResult(List<String> list, List<String> categories){
        System.out.println("메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf("[ %s | %s ]\n",
                "카테고리",
                String.join(" | ", categories));
        list.forEach(System.out::println);
    }

    public void printEnd(){
        System.out.println("추천을 완료했습니다.");
    }
}
