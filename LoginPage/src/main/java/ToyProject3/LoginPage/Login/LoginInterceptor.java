package ToyProject3.LoginPage.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("User")== null){
            log.info("미인증 사용자가 접근하였습니다.");
            String requestURI = request.getRequestURI();
            log.info("요청 정보 = {}", requestURI);
            response.sendRedirect("/login?redirectURL="+ requestURI);
            return false;
        }
        return true;

    }


}
