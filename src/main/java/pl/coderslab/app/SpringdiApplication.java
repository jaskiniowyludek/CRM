package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringdiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.register(ConverterConfig.class);
    }
}
