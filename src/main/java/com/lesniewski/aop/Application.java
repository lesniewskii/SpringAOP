package com.lesniewski.aop;

import com.lesniewski.aop.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by adrian on 20.03.17.
 */
public class Application {

    public static void main(String []args){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        {
          SomeBean someBean =   context.getBean("someBean",SomeBean.class);
            someBean.someMethod();
            try {

                someBean.throwSomeException();
            }

            catch (Exception excepion){

            }
        }



    }
}
