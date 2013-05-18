package idletest;

import com.googlecode.utterlyidle.Request;
import com.googlecode.utterlyidle.Response;
import com.googlecode.utterlyidle.annotations.GET;
import com.googlecode.utterlyidle.annotations.Path;
import com.googlecode.utterlyidle.annotations.Produces;
import com.googlecode.utterlyidle.handlers.ClientHttpHandler;
import com.googlecode.utterlyidle.handlers.HttpClient;

import static com.googlecode.utterlyidle.MediaType.TEXT_HTML;
import static com.googlecode.utterlyidle.RequestBuilder.get;
import static com.googlecode.utterlyidle.ResponseBuilder.modify;

public class SimpleResource {

    @GET
    @Path("/")
    @Produces(TEXT_HTML)
    public String saySomething() {
        return "<h1>Something</h1>";
    }

    @GET
    @Path("/ft")
    public Response ft() throws Exception {
        Request request = get("http://www.ft.com/home/uk").build();
        HttpClient client = new ClientHttpHandler(5000);
        Response ftResponse = client.handle(request);

        String content = ftResponse.entity().toString();
        String modifiedContent = content.replace("<head>", "<head>\n<!-- Added this  -->");

        return modify(ftResponse).entity(modifiedContent).build();
    }
}
