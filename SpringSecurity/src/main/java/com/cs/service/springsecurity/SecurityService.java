package com.cs.service.springsecurity;

public interface SecurityService {
    String findLoggedInAccount();

    void autologin(String account, String password);
}