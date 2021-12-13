package com.min0.blog.test;

import com.min0.blog.model.RoleType;
import com.min0.blog.model.User;
import com.min0.blog.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    private final UserRepository userRepository;

    public DummyControllerTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("id: " + user.getId());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email:" + user.getEmail());
        System.out.println("role: " + user.getRole());
        System.out.println("createDate: " + user.getCreateDate());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

}
