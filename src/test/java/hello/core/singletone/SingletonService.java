package hello.core.singletone;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    private SingletonService () {}

    public static SingletonService getInstance() {
        return instance;
    }

    @Test
    @DisplayName("같은 instance가 리턴되어야 한다")
    void isSameInstance () {
        SingletonService instance1 = getInstance();
        SingletonService instance2 = getInstance();

        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("싱글톤 컨테이너")
    void springContainer () {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = context.getBean("memberService", MemberService.class);
        MemberService memberService2 = context.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
