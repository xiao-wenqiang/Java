package pojo;

import java.util.*;

public class Student {
    private String name;    //注入普通值：用value
    private Address address;    //注入bean：普通对象：用ref
    private String[] books;    //注入bean：数组对象：用<array>
    private List<String> hobbys;    //注入bean：集合对象：
    private Set<String> games;
    private Map<String,String> card;    //...比较特殊
    private String wife;    //注入空的值""，用value注入""
                            //注入空null，用<null/>
    private Properties inof;    //...比较特殊

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", books=" + Arrays.toString(books) +
                ", hobbys=" + hobbys +
                ", games=" + games +
                ", card=" + card +
                ", wife='" + wife + '\'' +
                ", inof=" + inof +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public Map<String, String> getCard() {
        return card;
    }

    public void setCard(Map<String, String> card) {
        this.card = card;
    }

    public Set<String> getGames() {
        return games;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public Properties getInof() {
        return inof;
    }

    public void setInof(Properties inof) {
        this.inof = inof;
    }
}
