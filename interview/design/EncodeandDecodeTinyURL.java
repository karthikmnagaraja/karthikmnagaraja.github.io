package interview.design;

public class EncodeandDecodeTinyURL {
    Map<String,String> map= new HashMap<String,String>();
    String BASE_URL="http://tinyurl.com/";
   
    public String encode(String longUrl) {
        
        String key=String.valueOf(longUrl.hashCode());
        map.put(key,longUrl);
        StringBuilder sb= new StringBuilder();
        sb.append(BASE_URL).append(key);
        return sb.toString();
    }

   
    public String decode(String shortUrl) {
       String[] p= shortUrl.split("/");
           return map.get(p[p.length-1]);
    }
}