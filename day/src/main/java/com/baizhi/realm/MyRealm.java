package com.baizhi.realm;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<Role> roles=userService.queryRolesByUsername(primaryPrincipal);
        if (roles!=null && roles.size()!=0){
            roles.forEach(role -> {
                info.addRole(role.getRoletag());
            });
        }
        Set<Permission> permissions = userService.queryPermissionByUsername(primaryPrincipal);

        if(permissions != null && permissions.size() != 0){
            permissions.forEach(permission -> {
                // 主体 绑定权限 数据
                info.addStringPermission(permission.getPemtag());
            });
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User userName = userService.findUserName(username);
        if (username!=null){
            return new SimpleAccount(
                    userName.getName(),
                    userName.getPassword(),
                    ByteSource.Util.bytes(userName.getSalt()),
                            UUID.randomUUID().toString()
            );
        }
        return null;
    }
}
