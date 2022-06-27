public class Animal {
    private String name;
    private int id;
    private int weight;

    public Animal(String name, int id, int weight) {
        this.name = name;
        this.id = id;
        this.weight = weight;
    }
    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
