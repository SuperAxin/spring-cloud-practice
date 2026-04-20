package com.axin.services;

import com.axin.common.model.LoginRequest;
import com.axin.common.model.LoginRsp;
import com.axin.common.model.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

  private static final Map<String, Profile> USERS = new HashMap<>();

  static {
    Profile profile = new Profile();
    profile.setUsername("smartaxin-cloud-demo");
    profile.setPassword("0000");
    profile.setUserId("4e7de6a3-3f7f-45ad-8f88-7023f8c1ec1f");
    profile.setName("Axin");
    profile.setAge(24);
    profile.setPhoneNumber("0912345678");

    USERS.put("smartaxin-cloud-demo", profile);
  }

  public UserService() {

  }

  public LoginRsp login(LoginRequest req) {
    Profile profile = USERS.get(req.username);
    if (profile == null) {
      throw new RuntimeException("使用者不存在");
    }

    if (!profile.getPassword()
            .equals(req.getPassword())) {
      throw new RuntimeException("帳號或密碼錯誤");
    }

    LoginRsp res = new LoginRsp();
    res.status = "Success";
    res.token = UUID.randomUUID()
            .toString();

    return res;
  }

  public Profile getProfile(String userName) {
    Profile profile = USERS.get(userName);
    if (profile == null) {
      throw new RuntimeException("使用者不存在");
    }

    return profile;
  }
}
