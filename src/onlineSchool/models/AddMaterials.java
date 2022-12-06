package onlineSchool.models;

public class AddMaterials extends SuperPuperModels{
    private String bookOne;
    private String bookTwo;

    public AddMaterials(String bookOne, String bookTwo) {
        this.setBookOne(bookOne);
        this.setBookTwo(bookTwo);
    }

    private int id;

    public String getBookOne() {
        return bookOne;
    }

    public void setBookOne(String bookOne) {
        this.bookOne = bookOne;
    }

    public String getBookTwo() {
        return bookTwo;
    }

    public void setBookTwo(String bookTwo) {
        this.bookTwo = bookTwo;
    }
}
