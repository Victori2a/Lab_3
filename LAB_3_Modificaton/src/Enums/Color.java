package Enums;

public enum Color {
    WHITE("Белый"),
    BLACK("Чёрный"),
    GRAY("Серый"),
    YELLOW("Жёлтый"),
    BRIGHT_GREEN("Ярко-зелёный");
    String name;
    Color(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
