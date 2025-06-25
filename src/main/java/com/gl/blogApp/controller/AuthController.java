//package com.gl.blogApp.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    private AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//
//        // build login REST api
//        @PostMapping(value = {"/login", "/signin"})
//        public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
//            String token = authService.login(loginDto);
//            JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
//            jwtAuthResponse.setAccessToken(token);
//
//            return ResponseEntity.ok(jwtAuthResponse);
//        }
//        // build register REST api
//        @PostMapping(value={"/register", "/signup"})
//        public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
//            String response = authService.register(registerDto);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        }
//
//    }
//}
