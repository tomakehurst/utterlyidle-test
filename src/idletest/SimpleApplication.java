package idletest;

import java.net.URL;

import static com.googlecode.utterlyidle.ApplicationBuilder.application;

public class SimpleApplication {

    public static void main(String... args) throws Exception {
        URL assetsUrl = Thread.currentThread().getContextClassLoader().getResource("assets/");
        System.out.println(assetsUrl);
        application()
                .addContent(assetsUrl, "/assets")
                .addAnnotated(SimpleResource.class)
                .start(8088);
    }
}
