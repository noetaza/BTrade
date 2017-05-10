package com.example.noe.btrade;

public class Item {
    private String id;
    private int pic;

    public Item(String uid, int upic) {
        id = uid;
        pic = upic;
    }

    public int getPic() {return pic;}
    public void setPic(int picId) {pic = picId;}
    public String getGenId() {return id;}
    public void setGenId(String uId) {id = uId;}

}
