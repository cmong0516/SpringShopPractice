package mong.shop.controller;

import javax.security.auth.login.AppConfigurationEntry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mong.shop.config.AppConfig;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;
    private final AppConfig appConfig;
}
