package org.example;

public class UserResponseCommon {
    UserResponseCommon(){};

    private UserResponseData data;

    public void setData(UserResponseData data) {
        this.data = data;
    }

    public UserResponseData getData() {
        return data;
    }
}
