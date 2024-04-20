package com.example.user.service;

import com.example.business.entity.Account;
import com.example.user.entity.User;
import com.example.user.vo.UserQueryCommand;
import com.example.user.vo.UserQueryVO;
import com.example.user.vo.UserSaveCommand;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void add(UserSaveCommand command);

    void saveUser(UserSaveCommand saveCommand);

    String createUserName();

    void deleteById(String id);

    void deleteBatch(List<String> ids);

    void updateUser(UserSaveCommand saveCommand);

    UserQueryVO selectById(String id);

    List<UserQueryVO> selectAll(UserQueryCommand command);

    PageInfo<UserQueryVO> selectPage(UserQueryCommand command, Integer pageNum, Integer pageSize);

    UserQueryVO selectByUsername(String username);

    void register(Account account);

    Account login(Account account);
}
