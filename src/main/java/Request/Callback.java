package Request;

public class Callback {
    int code;
    String body;
    public Callback(int code, String body){
        this.code = code;
        this.body = body;
    }

    public String getBody(){
        return this.body;
    }

    public int getCode(){
        return this.code;
    }
}
