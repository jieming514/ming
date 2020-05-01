package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UpmsUserDao {

    public UpmsUserDO get(Long userId);

    public List<UpmsUserDO> list(Map<String, Object> params);

    public int insert(UpmsUserDO upmsUserDO);

    public int update(UpmsUserDO upmsUserDO);

    public int remove(Long userId);

    public UpmsUserDO getUserByName(String userName);

}
