package google.shkim.example.com.mp;

import java.util.List;

public class ListItem {
    private String id;
    private String title;
    private String date;
    private String time;
    private String lat;
    private String lng;

    public String getId(){return id;}
    public String getTitle(){
        return title;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getLat(){
        return lat;
    }
    public String getLng(){
        return lng;
    }

    public ListItem(String id, String title, String date, String time,String lat, String lng)
    {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.lat = lat;
        this.lng = lng;
    }
}
