package com.ming.system.shiro;


import com.ming.common.util.ShiroUtils;
import com.ming.system.config.ApplicationContextRegister;
import com.ming.system.dao.UserDao;
import com.ming.system.domain.UserDO;
import com.ming.system.service.MenuService;
import com.ming.system.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

/*    @Autowired
    private UserDao userDao;

    @Autowired
    private MenuService menuService;*/

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Long userId = ShiroUtils.getUserId();

        RoleService roleService = ApplicationContextRegister.getBean(RoleService.class);
        MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);

        Set<String> roles = roleService.listUserRole(userId);
        Set<String> perms = menuService.listUserPerms(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(perms);
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Map<String, Object> userMap = new HashMap();
        userMap.put("userName",username);
        String password = new String((char[]) token.getCredentials());

        UserDao userMapper = ApplicationContextRegister.getBean(UserDao.class);

        UserDO user = userMapper.list(userMap).get(0);

        if (user == null) {
            throw new UnknownAccountException("账号不存在！");
        }else if (!password.equals(user.getPassword())) {
            throw new UnknownAccountException("账户或密码不存在！");
        }

        if("0".equals(user.getStatus())) {
            throw new UnknownAccountException("账户被锁定，请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,getName());
        return info;
    }
}
