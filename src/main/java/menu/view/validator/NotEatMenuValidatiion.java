package menu.view.validator;

public class NotEatMenuValidatiion extends Validation{
    @Override
    public void validate(String input) {
        checkComma(input);
        checkMenuNumber(input);
    }

    private void checkMenuNumber(String input){
        String[] names = input.split(",");

        if (names.length > 2){
            throwError("못 먹는 메뉴는 2개까지만 입력해주세요.");
        }
    }
}
