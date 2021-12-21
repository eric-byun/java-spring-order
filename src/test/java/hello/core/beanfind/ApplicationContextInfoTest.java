package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("findAll bean")
    void findAllBean() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String beanItem : beanDefinitionNames) {
            Object bean = context.getBean(beanItem);
            System.out.println("beanItem = " + beanItem + " object = " + bean);

            /* result =>
             * beanItem = appConfig object = hello.core.AppConfig$$EnhancerBySpringCGLIB$$4e4fa1dc@35950b6a
             * beanItem = memberService object = hello.core.member.MemberServiceImpl@8564cd1
             * beanItem = memberRepository object = hello.core.member.MemoryMemberRepository@5e018dd2
             * beanItem = orderService object = hello.core.order.OrderServiceImpl@47fbd04a
             * beanItem = discountPolicy object = hello.core.discount.RateDiscountPolicy@5a285d84
             */
        }
    }

    @Test
    @DisplayName("findAllApplication bean")
    void findAllApplicationBean() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String beanItem : beanDefinitionNames) {
            BeanDefinition benDefinition = context.getBeanDefinition(beanItem);

            if (benDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = context.getBean(beanItem);
                System.out.println("beanItem = " + beanItem + " object = " + bean);
            }

            /* result =>
             * beanItem = appConfig object = hello.core.AppConfig$$EnhancerBySpringCGLIB$$4e4fa1dc@35950b6a
             * beanItem = memberService object = hello.core.member.MemberServiceImpl@8564cd1
             * beanItem = memberRepository object = hello.core.member.MemoryMemberRepository@5e018dd2
             * beanItem = orderService object = hello.core.order.OrderServiceImpl@47fbd04a
             * beanItem = discountPolicy object = hello.core.discount.RateDiscountPolicy@5a285d84
             */
        }
    }

}
