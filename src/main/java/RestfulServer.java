import spark.Spark;
import spark.Request;
import spark.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestfulServer {

    private final Logger log = LoggerFactory.getLogger(RestfulServer.class);

    public RestfulServer(){
        this.configureRestfulApiServer();
        this.processRestfulApiRequests();
    }

    private void processRestfulApiRequests(){
        Spark.get("/", this::echoRequest);
        Spark.post("/", this::logPostRequest);
    }
  
    private void configureRestfulApiServer() {
        Spark.port(8080);
        System.out.println("Server configured to listen on port 8080");
    }

    private String echoRequest(Request request, Response response) {
        response.type("application/json");
        response.header("Access-Control-Allow-Origin", "*");
        response.status(200); // OK
        return HttpRequestToJson(request);
    }

    private String logPostRequest(Request request, Response response) {
        response.type("application/json");
        response.header("Access-Control-Allow-Origin", "*");
        response.status(200); // OK

        log.info(request.body());
        return "";
    }

    private String HttpRequestToJson(Request request) {
        return "{\n"
                + "\"attributes\":\""    + request.attributes()    + "\",\n"
                + "\"body\":\""          + request.body()          + "\",\n"
                + "\"contentLength\":\"" + request.contentLength() + "\",\n"
                + "\"contentType\":\""   + request.contentType()   + "\",\n"
                + "\"contextPath\":\""   + request.contextPath()   + "\",\n"
                + "\"cookies\":\""       + request.cookies()       + "\",\n"
                + "\"header\":\""        + request.headers()       + "\",\n"
                + "\"host\":\""          + request.host()          + "\",\n"
                + "\"ip\":\""            + request.ip()            + "\",\n"
                + "\"params\":\""        + request.params()        + "\",\n"
                + "\"pathInfo\":\""      + request.pathInfo()      + "\",\n"
                + "\"serverPort\":\""    + request.port()          + "\",\n"
                + "\"protocol\":\""      + request.protocol()      + "\",\n"
                + "\"queryParams\":\""   + request.queryParams()   + "\",\n"
                + "\"requestMethod\":\"" + request.requestMethod() + "\",\n"
                + "\"scheme\":\""        + request.scheme()        + "\",\n"
                + "\"servletPath\":\""   + request.servletPath()   + "\",\n"
                + "\"session\":\""       + request.session()       + "\",\n"
                + "\"uri\":\""           + request.uri()           + "\",\n"
                + "\"url\":\""           + request.url()           + "\",\n"
                + "\"userAgent\":\""     + request.userAgent()     + "\",\n"
                + "}";
    }

    public static void main(String[] programArgs) {
        RestfulServer restfulServer = new RestfulServer();
        List<Map<Boolean, String>> grades = new ArrayList<>();
        Map<Boolean, String> a = new HashMap<>();

        Map<Boolean, String> b = new HashMap<>();

        Map<Boolean, String> c = new HashMap<>();

        Map<Boolean, String> d = new HashMap<>();

        Map<Boolean, String> e = new HashMap<>();

    }
}
