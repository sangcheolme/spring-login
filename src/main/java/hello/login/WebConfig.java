package hello.login;

import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter()); // 우리가 만든 로그 필터 넣기
        filterRegistrationBean.setOrder(1);                // 필터가 체인으로 여러개 들어가므로 순서를 정해줘야함
        filterRegistrationBean.addUrlPatterns("/*");       // 어떤 URL 패턴에 적용할 지, (/*): 모든 URL

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean loginCheckFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginCheckFilter()); // 우리가 만든 로그인 체크 필터 넣기
        filterRegistrationBean.setOrder(2);                // 필터가 체인으로 여러개 들어가므로 순서를 정해줘야함
        filterRegistrationBean.addUrlPatterns("/*");       // 어떤 URL 패턴에 적용할 지, (/*): 모든 URL

        return filterRegistrationBean;
    }
}
