package com.inncore.beta.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.inncore.beta.entity.SysPermission;
import com.inncore.beta.entity.SysUser;
import com.inncore.beta.entity.SysUserRole;
import com.inncore.beta.service.SysUserRoleService;
import com.inncore.beta.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class AuthController extends ApiController {
    private static  final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private SysUserService userService;

    @Autowired
    private SysUserRoleService sysUserRoleService;



//    @Value("${spring.cloud.nacos.discovery.ip}")
//    private String ip;

    @PostMapping("/register")
    public R register(SysUser user, Integer[] roleIds) {

        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        userService.save(user);
        Integer userId = user.getId();
        List<SysUserRole> userRoles = new ArrayList<>();
        Arrays.stream(roleIds).forEach((id) -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(id);
            userRoles.add(sysUserRole);
        });
        if (!userRoles.isEmpty()) {
            sysUserRoleService.saveBatch(userRoles);
        }
        return R.ok(null);
    }

    /**
     * 登录
     *
     * @param
     * @param
     * @return
     */

    @PostMapping("/logout")
    public R logout() {
        return R.ok("退出成功");
    }

    @GetMapping("/auth")
    public R auth(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        SysUser user = userService.getOne(queryWrapper);
        if (null == user) {
            log.info("登录用户：" + username + " 不存在.");
            return R.failed("登录用户：" + username + " 不存在");
        }
        Collection<String> authorities = getUserAuthorities(user);
        Map<String, Object> result = new HashMap<>();
        result.put("username", user.getUsername());
        result.put("password", user.getPassword());
        result.put("authorities", authorities);
        result.put("id", user.getId());
        return R.ok(result);
    }

//    @GetMapping("currentUser")
//    public R currentUser() {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        String uid = request.getHeader("uid");
//        SysUserDTO userDTO = userService.getUserDTOById(uid);
//        return R.ok(userDTO);
//    }


    /**
     * 封装 根据user获取权限
     *
     * @param user
     * @return
     */
    private Collection<String> getUserAuthorities(SysUser user) {
        List<SysPermission> permissions = userService.findPermissionListByUser(user);
        Set<String> urls = new HashSet<>();
        for (SysPermission permission : permissions) {
            urls.add(permission.getUrl());
        }
        return urls;
    }


    @GetMapping("hello")
    public Object hello() {
        return "hello, this's from " + "localhost";
    }


}
