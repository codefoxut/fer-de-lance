import netscape.javascript.JSObject;

public class AdapterPattern {
    
}

interface WebRequester {
    public int request(Object);
}

class WebAdapter implements WebRequester {
    private WebService service;

    public void connect(WebService currentService) {
        this.service = currentService;
        System.out.println("connect to the web service.");
    }

    public int request(Object request) {
        JSObject i;
        Json result = this.toJson(request);
        Json response = service.request(result);
        if (response != null)
            return 200;  // OK status code
        return 500;  // server error status code
    }

    private Json toJson(object input){

    }
}

class WebService {

}

