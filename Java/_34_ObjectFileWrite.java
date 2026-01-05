import java.io.*;
import java.util.*;

class Circle implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private double radius;
    private String color;

    public Circle(String id, double radius, String color) {
        this.id = id;
        this.radius = radius;
        this.color = color;
    }

    public Circle() {
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle{id='%s', radius=%.2f, color='%s', area=%.2f}",
                id, radius, color, getArea());
    }
}

public class _34_ObjectFileWrite {
    private static final String FILENAME = "circles.dat";
    private List<Circle> circles;

    public _34_ObjectFileWrite() {
        circles = new ArrayList<>();
        loadCircles();
    }

    public boolean addCircle(Circle circle) {
        if (findCircleById(circle.getId()) != null) {
            System.out.println("Circle with ID " + circle.getId() + " already exists!");
            return false;
        }
        circles.add(circle);
        saveCircles();
        return true;
    }

    public List<Circle> getAllCircles() {
        return new ArrayList<>(circles);
    }

    public Circle findCircleById(String id) {
        return circles.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean updateCircle(String id, double newRadius, String newColor) {
        Circle circle = findCircleById(id);
        if (circle == null) {
            System.out.println("Circle with ID " + id + " not found!");
            return false;
        }
        circle.setRadius(newRadius);
        circle.setColor(newColor);
        saveCircles();
        return true;
    }

    public boolean removeCircle(String id) {
        Circle circle = findCircleById(id);
        if (circle == null) {
            System.out.println("Circle with ID " + id + " not found!");
            return false;
        }
        circles.remove(circle);
        saveCircles();
        return true;
    }

    private void saveCircles() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(circles);
            System.out.println("Circles saved to file successfully!");
        } catch (IOException e) {
            System.err.println("Error saving circles: " + e.getMessage());
        }
    }

    private void loadCircles() {
        File file = new File(FILENAME);
        if (!file.exists()) {
            System.out.println("No existing circles file found. Starting fresh.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            circles = (List<Circle>) ois.readObject();
            System.out.println("Loaded " + circles.size() + " circles from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading circles: " + e.getMessage());
            circles = new ArrayList<>();
        }
    }

    public void displayAllCircles() {
        if (circles.isEmpty()) {
            System.out.println("No circles found.");
            return;
        }
        System.out.println("\n All Circles ");
        circles.forEach(System.out::println);
    }

    public static void main(String[] args) {
        _34_ObjectFileWrite manager = new _34_ObjectFileWrite();

        System.out.println("Creating 12 sample circles...");
        String[] colors = { "Red", "Blue", "Green", "Yellow", "Purple", "Orange", "Pink", "Brown", "Gray", "Black",
                "White", "Cyan" };
        for (int i = 1; i <= 12; i++) {
            Circle circle = new Circle("C" + i, 2.0 + i * 0.5, colors[i % colors.length]);
            manager.addCircle(circle);
        }

        manager.displayAllCircles();

        System.out.println("\nFinding circle C5...");
        Circle c5 = manager.findCircleById("C5");
        System.out.println("Found: " + c5);

        System.out.println("\nUpdating circle C3...");
        manager.updateCircle("C3", 10.0, "Gold");
        manager.displayAllCircles();

        System.out.println("\nRemoving circle C1...");
        manager.removeCircle("C1");
        manager.displayAllCircles();

        System.out.println("\n Restarting manager to test persistence ");
        _34_ObjectFileWrite newManager = new _34_ObjectFileWrite();
        newManager.displayAllCircles();
    }
}