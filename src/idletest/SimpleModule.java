package idletest;

import com.googlecode.utterlyidle.Resources;
import com.googlecode.utterlyidle.modules.ResourcesModule;

import java.net.URL;

import static com.googlecode.utterlyidle.annotations.AnnotatedBindings.annotatedClass;
import static com.googlecode.utterlyidle.dsl.DslBindings.bindings;
import static com.googlecode.utterlyidle.dsl.StaticBindingBuilder.in;

public class SimpleModule implements ResourcesModule {

    @Override
    public Resources addResources(Resources resources) throws Exception {
        URL assetsUrl = Thread.currentThread().getContextClassLoader().getResource("assets/");
        System.out.println(assetsUrl);

        return resources
                .add(annotatedClass(SimpleResource.class))
                .add(bindings(in(assetsUrl).path("/assets")));

    }
}
