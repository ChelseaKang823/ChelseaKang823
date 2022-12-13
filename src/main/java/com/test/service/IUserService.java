package com.test.service;

import com.test.model.User;
import com.test.util.JsonResponseBody;

public interface IUserService {
    JsonResponseBody login(User user);

    JsonResponseBody insertSelective(User record);
}
