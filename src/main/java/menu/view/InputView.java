package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.view.validator.CoachNameValidation;

import java.util.Arrays;
import java.util.List;

public enum InputView {
    INSTANCE;

    public static InputView getInstance(){
        return INSTANCE;
    }

    public List<String> inputCoachName(){
        CoachNameValidation coachNameValidation = CoachNameValidation.getInstance();

        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();

        coachNameValidation.validate(input);

        return Arrays.stream(input.split(",")).toList();
    }

    public List<String> inputNotMyStyle(String coachName){
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();

        return Arrays.stream(input.split(",")).toList();
    }
}