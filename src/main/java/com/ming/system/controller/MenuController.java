package com.ming.system.controller;

import com.ming.common.annotation.Log;
import com.ming.common.controller.BaseController;
import com.ming.common.domain.Tree;
import com.ming.common.util.R;
import com.ming.system.domain.MenuDO;
import com.ming.system.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    private final String PREFIX = "system/menu";

    @Log("菜单管理界面")
    @RequiresPermissions("sys:menu:menu")
    @GetMapping(value = "")
    public String menu() {
        return PREFIX + "/menu";
    }


    @Log("菜单列表")
    @RequiresPermissions("sys:menu:menu")
    @GetMapping(value = "/list")
    @ResponseBody
    public List<MenuDO> list(@RequestParam Map<String, Object> params) {
        return menuService.list(params);
    }


    /**
     *
     * 功能描述: 新增目录页面
     *
     * @param:
     * @return:
     * @auther: jie_ming514@163.com
     * @date: 2018/10/12 23:21
     */
    @Log("新增菜单页面")
    @RequiresPermissions("sys:menu:add")
    @GetMapping("/add/{pId}")
    public String add(Model model, @PathVariable("pId") Long pId) {
         model.addAttribute("pId",pId);
         if (pId == 0) {
             model.addAttribute("pName","根目录");
         }else {
             model.addAttribute("pName", menuService.get(pId).getName());
         }
         return PREFIX + "/add";
    }

    @Log("获取菜单结构树")
    @GetMapping("/tree")
    @ResponseBody
    public Tree<MenuDO> tree() {
        return menuService.getTree();
    }

    @Log("通过ID获取菜单节点")
    @GetMapping("/tree/{pId}")
    @ResponseBody
    public Tree<MenuDO> tree(@PathVariable("pId") Long id) {
        return menuService.getTree(id);
    }

    @Log("保存菜单")
    @RequiresPermissions("sys:menu:add")
    @PostMapping("/save")
    @ResponseBody
    public R save(MenuDO menuDO) {
        if (menuService.save(menuDO) > 0) {
            return R.ok();
        } else {
            return R.error(1,"新增菜单保存失败！");
        }
    }

    /**
     *
     * 功能描述: 删除菜单
     *
     * @param:
     * @return:
     * @auther: jie_ming514@163.com
     * @date: 2018/10/13 0:15
     */
    @Log("删除菜单")
    @RequiresPermissions("sys:menu:remove")
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long id) {

        if(menuService.remove(id)) {
            return R.ok();
        }else {
            return R.error(1,"菜单移除失败！");
        }
    }


    /**
     *
     * 功能描述: 编辑菜单界面
     *
     * @param: 用户ID
     * @return: 编辑页面URL
     * @auther: jie_ming514@163.com
     * @date: 2018/10/13 0:39
     */
    @Log("编辑菜单界面")
    @RequiresPermissions("sys:menu:edit")
    @GetMapping("/edit/{pId}")
    public String edit(Model model, @PathVariable("pId") Long pId) {
        MenuDO menuDO = menuService.get(pId);
        model.addAttribute("menu",menuDO);

        Long parentId = menuDO.getParentId();
        model.addAttribute("pId",parentId);
        if (parentId == 0L) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(parentId).getName());
        }

        return PREFIX + "/edit";
    }

    @Log("更新菜单")
    @RequiresPermissions("sys:menu:edit")
    @PostMapping("/update")
    @ResponseBody
    public R update(MenuDO menuDO) {
        if(menuService.update(menuDO) > 0) {
            return R.ok();
        } else {
            return R.error(1,"更新菜单信息失败！");
        }
    }


}
