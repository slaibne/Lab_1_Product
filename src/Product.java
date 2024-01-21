public class Product
{
    private String id;
    private String name;
    private String desc;
    private double cost;

    public Product(String id, String name, String desc, double cost)
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getDesc()
    {
        return desc;
    }
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    public double getCost()
    {
        return cost;
    }
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + cost + '\'' +
                ", description='" + desc + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String toCSV()
    {
        return id + ", " + name + ", " + desc + ", " + cost;
    }





}