public class Coordinate {
    int x;
    int y;
    int h;

    public Coordinate(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h= h;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "x=" + x + ", y=" + y + ", h=" + h + '}';
    }
}
