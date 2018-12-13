package com.ming;

import com.alibaba.druid.pool.DruidDataSource;
import com.ming.common.util.ShiroUtils;
import com.ming.system.shiro.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroUtilsTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();


    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("abc","123","admin","user");
    }

    /**
     * Shiro 认证
     */
    @Test
    public void testAuthentication() {

        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(manager);
        Subject subject = ShiroUtils.getSubjct();

        UsernamePasswordToken token = new UsernamePasswordToken("abc","123");

        subject.login(token);

        System.out.println("isAuthentication:" + subject.isAuthenticated());

        subject.checkRoles("admin","user");

    }


    /**
     * 从数据库里面获取信息
     */
    @Test
    public void jdbcRealmTest() {

        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ming");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(druidDataSource);

        String sql = "select su.password from sys_user su where su.user_name = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSql = "select sr.role_sign\n" +
                "from sys_user su, sys_user_role sur, sys_role sr\n" +
                "where su.user_id = sur.user_id\n" +
                "  and sur.role_id = sr.role_id\n" +
                "  and su.user_name = ?";
        jdbcRealm.setUserRolesQuery(roleSql);

        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("mingjie","123456");

        subject.login(token);

        System.out.println("----isAuthentication:" + subject.isAuthenticated());

        subject.checkRoles("admin");
    }


    /**
     *
     */
    @Test
    public void userRealmTest() {

        UserRealm userRealm = new UserRealm();

        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(userRealm);

        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("mingjie","123456");
        subject.login(token);

        System.out.println("----isAuthentication:" + subject.isAuthenticated());

        subject.checkPermissions("sys:menu:menu");

        subject.checkRoles("admin");

    }




}
