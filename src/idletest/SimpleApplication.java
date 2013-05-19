package idletest;

import com.googlecode.utterlyidle.simpleframework.RestServer;

import static com.googlecode.utterlyidle.ApplicationBuilder.application;
import static com.googlecode.utterlyidle.ServerConfiguration.defaultConfiguration;

public class SimpleApplication {

    public static void main(String... args) throws Exception {
        application()
                .add(new SimpleModule())
                .start(defaultConfiguration().port(8088).serverClass(RestServer.class));
    }
}
