package com.GloQoura.userdetails.excepation;

public class UserNameAlreadyExist extends  Exception {
    public UserNameAlreadyExist() {
    }

    public UserNameAlreadyExist(String message) {
        super(message);
    }
}
