package com.GloQoura.userdetails.excepation;

public class UserNotFound extends  Exception{
    public UserNotFound() {
    }

    public UserNotFound(String message) {
        super(message);
    }
}
