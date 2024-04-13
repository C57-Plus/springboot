package com.example.user.service.impl;

import com.example.common.Result;
import com.example.role.service.RoleService;
import com.example.user.vo.UserQueryCommand;
import com.example.utils.MD5Utils;
import com.example.utils.RandomNumberUtil;
import org.apache.commons.lang3.StringUtils;
import cn.hutool.core.util.ObjectUtil;
import com.example.business.entity.Account;
import com.example.common.enums.ResultCodeEnum;
import com.example.exception.CustomException;
import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import com.example.user.vo.UserQueryVO;
import com.example.user.vo.UserSaveCommand;
import com.example.utils.TokenUtils;
import com.example.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Value("${server.port:9090}")
    private String port;

    @Value("${ip:localhost}")
    private String ip;

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public void add(UserSaveCommand saveCommand){
//        // 数据校验
//        if (ObjectUtil.isEmpty(saveCommand.getUserName()) || ObjectUtil.isEmpty(saveCommand.getPassword())) {
//            throw new CustomException(ResultCodeEnum.PARAM_LOST_ERROR);
//        }
        if (StringUtils.isNotBlank(saveCommand.getUserName())){
            Map<String, Object> cond = new HashMap<>(1);
            cond.put("userName", saveCommand.getUserName());
            UserQueryVO userQueryVO = userMapper.selectUser(cond);

            if (ObjectUtil.isNotNull(userQueryVO)) {
                throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
            }
        }else {
            saveCommand.setUserName(createUserName());
        }
        User user = new User();
        BeanUtils.copyProperties(saveCommand, user);

        user.setId(UUIDUtil.get32UUID());
        String userId = TokenUtils.getUserID();
        user.setCreator(userId);
        user.setModifier(userId);
        user.setPassword(MD5Utils.convertMD5(saveCommand.getPassword()));

        if (StringUtils.isBlank(user.getAvatar())){
            String http = "http://" + ip + ":" + port + "/files/";
            user.setAvatar(http + "1712686995727-1697438073596-avatar.png");
        }
        userMapper.insert(user);
    }

    /**
     * 修改
     */
    @Override
    public void updateUser(UserSaveCommand saveCommand) {
        User user = new User();
        BeanUtils.copyProperties(saveCommand, user);
        user.setModifier(TokenUtils.getUserID());
        userMapper.updateUser(user);
    }

    @Override
    public void saveUser(UserSaveCommand saveCommand){
        if (StringUtils.isBlank(saveCommand.getId())){
            // 新增
            add(saveCommand);
        }else {
            // 修改
            updateUser(saveCommand);
        }
    }

    @Override
    public String createUserName(){
        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR)).substring(2);
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String base = year + month;

        String userName = "";
        int flag = 0;
        while (flag == 0){
            String num = RandomNumberUtil.getRandomString(3);
            userName = base + num;
            UserQueryVO userQueryVO = selectByUsername(userName);
            if (userQueryVO == null){
                flag = 1;
            }
        }
        return userName;
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        userMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void deleteBatch(List<String> ids) {
        for (String id : ids) {
            userMapper.deleteById(id);
        }
    }

    /**
     * 根据ID查询
     * @return
     */
    @Override
    public UserQueryVO selectById(String id) {
        return userMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    @Override
    public List<UserQueryVO> selectAll(UserQueryCommand command) {
        Map<String, Object> cond = new HashMap(4);
        cond.put("userName", command.getUserName());
        cond.put("roleCode", command.getRoleCode());
        cond.put("status", command.getStatus());
        cond.put("nickName", command.getNickName());
        cond.put("unit", command.getUnit());
        return userMapper.selectUserBatch(cond);
    }

    /**
     * 分页查询
     */
    @Override
    public PageInfo<UserQueryVO> selectPage(UserQueryCommand command, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<UserQueryVO> list = selectAll(command);
        return PageInfo.of(list);
    }

    /**
     * 用户登录
     */
    @Override
    public Account login(Account account) {
        Map<String, Object> cond = new HashMap<>(1);
        cond.put("userName", account.getUserName());
        UserQueryVO userQueryVO = userMapper.selectUser(cond);

        if (ObjectUtil.isNull(userQueryVO)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }

        if (!MD5Utils.passwordIsTrue(account.getPassword(), userQueryVO.getPassword())){
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }

        // 生成token
        String tokenData = userQueryVO.getId() + "-" + userQueryVO.getRoleCode();
        String password = userQueryVO.getPassword();
        String token = TokenUtils.createToken(tokenData, password);

        Account accountUser = new Account();
        BeanUtils.copyProperties(userQueryVO, accountUser);
        accountUser.setToken(token);
        return accountUser;
    }

    @Override
    public UserQueryVO selectByUsername(String userName) {
        Map<String, Object> cond = new HashMap<>(1);
        cond.put("userName", userName);
        return userMapper.selectUser(cond);
    }

    /**
     * 用户注册
     */
    @Override
    public void register(Account account) {
        UserSaveCommand saveCommand = new UserSaveCommand();
        BeanUtils.copyProperties(account, saveCommand);
        this.add(saveCommand);  // 添加账户信息
    }

    public List<User> queryUsers(String siteID, String userRole){
        return null;
    }
}
