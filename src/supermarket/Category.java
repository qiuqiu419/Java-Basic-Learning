package supermarket;

public enum Category {

    // >> TODO 必须在开始的时候以这种形式，创建所有的枚举对象
    FOOD(1),
    COOK(2),
    SNACK(3),
    CLOTHES(4),
    ELECTRIC(5);

    private int id;
    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Category{" +
                "id=" + id +
                '}';
    }

}
