package mong.shop.exception;

public class InvalidSigninInformation extends RuntimeException{
    private static final String MESSAGE = "아이디 또는 비밀번호가 맞지 않습니다.";

    public InvalidSigninInformation() {
        super(MESSAGE);
    }
}
