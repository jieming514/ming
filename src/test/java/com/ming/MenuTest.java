package com.ming;

import com.ming.system.dao.MenuDao;
import com.ming.system.domain.MenuDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTest {

    @Autowired
    private MenuDao menuDao;

    @Test
    public void MenuListTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("parentId","0");

        List<MenuDO> MenuList = menuDao.list(map);
        for (MenuDO menuDO : MenuList) {
            System.out.println(menuDO.toString());
        }
    }


    @Test
    public void getSysMenuListTest() {
        Long id = Long.valueOf(1);
        List<MenuDO> menuDOList = menuDao.getSysMenuList(id);
        for (MenuDO menuDO : menuDOList) {
            System.out.println(menuDO.toString());
        }
    }



    @Test
    public void generatorTest() {
        String bean = "";
        String fieIds = "role_id|role_name|role_sign|remark|user_id_create|gmt_create|gmt_modified";
        List pramList = new ArrayList<String>();
        String[] fieIdList = fieIds.split("\\|");

        for (String s : fieIdList) {
            String s1 = fromat(s);
            System.out.printf("<if test=\"%s != null and %s != ''\"> and %s = #{%s}</if>\n",s1,s1,s,s1);
        }
    }


    @Test
    public void MenuTest() {
        System.out.println(fromat("parent_id_date"));
    }

    public String fromat(String fieIdName) {
        String result = "";
        //将字段名转行成java属性名
        if( fieIdName == null || fieIdName.length() <= 0) {
            return null;
        }

        String[] prams = fieIdName.split("_");
        if(prams.length == 1) {
            return prams[0];
        }else {
            result = prams[0];
            for (int i = 1; i < prams.length; i++) {
                result += upperCase(prams[i]);
            }
        }

        return result;
    }

    public String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}