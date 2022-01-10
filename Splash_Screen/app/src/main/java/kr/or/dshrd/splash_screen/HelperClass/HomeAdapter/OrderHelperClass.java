package kr.or.dshrd.splash_screen.HelperClass.HomeAdapter;

public class OrderHelperClass {

    int image;
    String title, description;
    // 성격이 같은 변수는 ,로 나란히 선언 가능
    

    public OrderHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
