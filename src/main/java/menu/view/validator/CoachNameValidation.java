package menu.view.validator;

import java.util.Arrays;

public class CoachNameValidation extends Validation{
    private static final CoachNameValidation COACH_NAME_VALIDATION = new CoachNameValidation();

    private CoachNameValidation() {
    }
    public static CoachNameValidation getInstance(){return COACH_NAME_VALIDATION;}

    @Override
    public void validate(String input) {
        checkComma(input);
        checkCoachNumber(input);
        checkNameLength(input);
    }

    private void checkCoachNumber(String input){
        String[] names = input.split(",");

        if (names.length > 5 || names.length <2){
            throwError("코치는 2명에서 5명까지 입력해주세요.");
        }
    }
    private void checkNameLength(String input){
        String[] names = input.split(",");
        Arrays.stream(names).forEach(name -> {
            if (name.length() < 2 || name.length() > 4){
                throwError("코치의 이름은 2글자에서 4글자여야 합니다.");
            }
        });
    }

}
