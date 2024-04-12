package com.example.user.mapper;


import com.example.user.entity.User;
import com.example.user.vo.UserQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    /**
     * 新增
     */
    int insert(User user);

    /**
     * 删除
     */
    int deleteById(String id);

    /**
     * 修改
     */
    int updateUser(User user);

    /**
     * 根据ID查询
     */
    UserQueryVO selectById(String id);

    UserQueryVO selectUser(Map<String, Object> cond);

    /**
//     * 查询所有
//     */
    List<UserQueryVO> selectUserBatch(Map<String, Object> cond);
}
