package LoginAuth;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录认证的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor{


    /**
     * handler 执行之前调用这个方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String url = request.getServletPath();
        // URL:login.jsp是公开的；这个demo是除了login.jsp是可以公开访问的，其他的url都进行拦截控制
        if (url.indexOf("login.action") >= 0){
            return true;
        }

        //获取session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if (username != null){
            return true;
        }

        // 不符合条件的，跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }


    /**
     * handler 执行完成之后，ModelAndView返回之前调用这个方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }


    /**
     * Handler执行完成之后调用这个方法
     * @param request
     * @param response
     * @param handler
     * @param exc
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
    HttpServletResponse response, Object handler, Exception exc) throws Exception {

    }
}
