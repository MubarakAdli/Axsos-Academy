import java.util.Set;
import java.util.HashMap;
public class MapHashmatique{
    public static void main(String[] args){
        HashMap<String,String> trackList= new HashMap<String,String>();
        trackList.put("May be","may be some day");
        trackList.put("Whenever","mwhen ever where ever");
        trackList.put("all the day ","when u  alone all the day");
        trackList.put("Ola Ola ","Ola Ola Ola Ola Ola Ola");

        System.out.println(trackList.get("Ola Ola "));
        Set<String> allSongs = trackList.keySet();
        for (String key : allSongs) {
            System.out.println(String.format( key, trackList.get(key)));
        }


    }
}