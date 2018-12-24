package com.baizhi.aop;

import com.baizhi.entity.Tranpation;
import com.baizhi.service.TranpationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

@Component
@Aspect
public class CustomAdvice {
    @Autowired
    private TranpationService tranpationService;
    //切入点
    @Pointcut(value = "execution(* com.baizhi.service.PersonService.*(..))")
    public void pc() {
    }

    //环绕通知方法
    @Around(value = "pc()")
    public Object doAround(ProceedingJoinPoint pjp) {
        Object object = null;
        //获取方法的签名对象
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String name = method.getName();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        if (name.equals("insertP") || name.equals("deleteP") || name.equals("updateP")) {
//            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//            //从获取RequestAttributes中获取HttpServletRequest的信息
//            //从获取RequestAttributes中获取session的信息
//            //从获取RequestAttributes中获取session的信息
//            HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
//            User login = (User) session.getAttribute("login");
            Subject subject = SecurityUtils.getSubject();
            String principal = (String) subject.getPrincipal();
            System.out.println("写入日志");
            Tranpation tranpation=new Tranpation();
            tranpation.setId(UUID.randomUUID().toString());
            tranpation.setUsername(principal);
            tranpation.setDatetime(new Date());
            if (name.equals("deleteP")){
                Object[] args = pjp.getArgs();
                tranpation.setHandle("将用户id为"+args[0]+"的用户删除");
            }else if (name.equals("insertP")){
                Object[] args = pjp.getArgs();
                tranpation.setHandle("添加了一个用户，用户信息为"+args[0].toString());
            }else {
                Object[] args = pjp.getArgs();
                tranpation.setHandle("修改了用户信息,修改内容为："+args[0].toString());
            }
            try {
                object = pjp.proceed();
                tranpation.setResult("成功");
            }catch (Throwable throwable){
                throwable.printStackTrace();
                tranpation.setResult("失败");
            }finally {
                tranpationService.insert(tranpation);
            }
        }else {
            try {
                object=pjp.proceed();
            }catch (Throwable throwable){
                throwable.printStackTrace();
            }

        }
        return object;
    }
}
