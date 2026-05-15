public interface Drawable {
    void draw();
    default String getDisplayColour() { return "default"; }
}
