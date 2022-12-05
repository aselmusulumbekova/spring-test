package kg.megacom.spring.test.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import kg.megacom.spring.test.configs.Swagger2Config;
import kg.megacom.spring.test.models.requests.AuthRequest;
import kg.megacom.spring.test.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@Api(tags = Swagger2Config.Auth)
public class AuthController {

    @Autowired
    protected AccountService accountService;

    @PostMapping()
    @ApiOperation("Метод авторизации")
    public ResponseEntity<?> auth(@RequestBody AuthRequest authRequest){
        try {
            return ResponseEntity.ok(accountService.auth(authRequest));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
