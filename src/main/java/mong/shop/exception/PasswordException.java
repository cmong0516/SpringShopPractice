package mong.shop.exception;

import antlr.debug.MessageEvent;

public class PasswordException extends Exception {

    private static final String MESSAGE = "비밀번호가 맞지 않습니다.";


    public PasswordException() {
        super(MESSAGE);
    }
}
