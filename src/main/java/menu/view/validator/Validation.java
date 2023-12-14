package menu.view.validator;

public abstract class Validation {
    private final String ERROR_HEAD = "[ERROR]" ;

    protected void throwError(String errorMessage){
        System.out.println(ERROR_HEAD + errorMessage);
        throw new IllegalArgumentException();
    }
    protected void checkComma(String input){
        if (input.contains(",,")){
            throwError("이름은 ,로 구분하여 입력해주세요");
        }
    }

    public abstract void validate(String input);
}