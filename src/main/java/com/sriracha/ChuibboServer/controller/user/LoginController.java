package com.sriracha.ChuibboServer.controller.user;

import com.sriracha.ChuibboServer.common.Header;
import com.sriracha.ChuibboServer.model.dto.request.user.SignInRequestDto;
import com.sriracha.ChuibboServer.service.user.login.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users/login")
public class LoginController {

    private final LoginService loginService;

    // 로그인
    @ApiOperation("기본 로그인")
    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody SignInRequestDto signInRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(signInRequestDto));
    }

    @ApiOperation("카카오 로그인")
    @RequestMapping(value = "/kakao", produces = "application/json", method = RequestMethod.GET)
    public Header<String> Kakao(@RequestBody String access_token) throws IOException {
        return loginService.Kakao(access_token);
    }

    @ApiOperation("구글 로그인")
    @RequestMapping(value = "/google", produces = "application/json", method = RequestMethod.GET)
    public Header<String> Google(@RequestBody String access_token) throws IOException {
        return loginService.Google(access_token);
    }

    @ApiOperation("네이버 로그인")
    @RequestMapping(value = "/naver", produces = "application/json", method = RequestMethod.GET)
    public Header<String> Naver(@RequestBody String access_token) throws IOException {
        return loginService.Naver(access_token);
    }

}
