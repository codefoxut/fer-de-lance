
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;


public class AdapterPattern {
    public static void main (String[] args) {
        String webHost = "Host:https://google.com\n\r";
        WebService service = new WebService(webHost);

        WebAdapter adapter = new WebAdapter();
        adapter.connect(service);

        WebClient client = new WebClient(adapter);
        client.doWork();
    }
}

interface WebRequester {
    public int request(Map<String, String> req);
}

class WebAdapter implements WebRequester {
    private WebService service;

    public void connect(WebService currentService) {
        this.service = currentService;
        System.out.println("connect to the web service.");
    }

    public int request(Map<String, String> req) {
        JSONObject result = this.toJson(req);
        JSONObject response = service.request(result);
        if (response != null)
            return 200;  // OK status code
        return 500;  // server error status code
    }

    private JSONObject toJson(Map<String, String> input){
        return new JSONObject(input);
    }
}

class WebService {
    public String hostString;

    public WebService(String hostString) {
        this.hostString = hostString;
    }

    public JSONObject request(JSONObject object){
        System.out.println("request object. " + object);
        return object;
    }

}


class WebClient {
    private WebRequester webRequester;

    public WebClient(WebRequester webRequester) {
        this.webRequester = webRequester;
    }
    private Map<String, String> makeObject() {
        Map<String, String>  m1 = new LinkedHashMap<String, String>(); 
        m1.put("k11", "v11");
        m1.put("k12", "v12");
        m1.put("k13", "v13");
        return m1;
    }

    public void doWork(){
        Map<String, String> object = makeObject();
        int status = webRequester.request(object);

        if (status == 200) {
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
        return ;

    }

}
