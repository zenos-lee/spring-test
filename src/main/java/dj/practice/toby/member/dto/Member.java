package dj.practice.toby.member.dto;

public class Member {
    int id;
    String name;
    double point;
    public Member() {
    }
    public Member(int id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public int getId() { return this.id; }

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPoint(double point) {this.point = point;}
    public String getName(){return this.name;}
    public double getPoint(){return this.point;}
}
