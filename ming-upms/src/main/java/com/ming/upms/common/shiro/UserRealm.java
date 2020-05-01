package com.ming.upms.common.shiro;

import com.ming.upms.common.util.ShiroUtils;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsPermissionService;
import com.ming.upms.system.service.UpmsUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 自定义Realm 处理登录 权限
 * @param
 * @return
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UpmsPermissionService upmsPermissionService;

    @Autowired
    private UpmsUserService upmsUserService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Long userId = ShiroUtils.getUserId();
        Set<String> upmsPermissionDOSet = upmsPermissionService.getPermsByUserId(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(upmsPermissionDOSet);
        return info;
    }


    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", userName);
        List<UpmsUserDO> userDOList = upmsUserService.list(paramMap);
        if(userDOList == null || userDOList.size() == 0) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        UpmsUserDO user = userDOList.get(0);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (user.getLocked() > 0) {
            throw new LockedAccountException("用户已锁定，请稍后再试！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
