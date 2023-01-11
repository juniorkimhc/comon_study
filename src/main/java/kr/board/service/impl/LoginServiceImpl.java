package kr.board.service.impl;

import kr.board.mapper.LoginMapper;
import kr.board.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper LogMapper;

    @Override
    public boolean isLogin(Map map) {

        return false;
    }
}
