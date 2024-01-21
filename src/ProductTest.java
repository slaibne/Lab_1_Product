import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product testProduct = new Product("000001", "laptop", "portable computer", 1000);

    @org.junit.jupiter.api.Test
    void getId() { assert "000001".equals(testProduct.getId());
    }

    @org.junit.jupiter.api.Test
    void setId() {String testId = "500";
        testProduct.setId(testId);
        assert testProduct.getId().equals(testId);
    }

    @org.junit.jupiter.api.Test
    void getname() {assert "laptop".equals(testProduct.getName());
    }

    @org.junit.jupiter.api.Test
    void setname() {String testName = "tablet";
        testProduct.setName(testName);
        assert testProduct.getName().equals(testName);
    }

    @org.junit.jupiter.api.Test
    void getDesc() {assert "portable computer".equals(testProduct.getDesc());
    }

    @org.junit.jupiter.api.Test
    void setDesc() {
        String testDesc = "Mr.";
        testProduct.setDesc(testDesc);
        assert testProduct.getDesc().equals(testDesc);
    }

    @org.junit.jupiter.api.Test
    void getCost() {assert 1000 == testProduct.getCost();
    }

    @org.junit.jupiter.api.Test
    void setCost() {
        double testCost = 2400.0;
        testProduct.setCost(testCost);
        assert testProduct.getCost() == testCost;
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assert "Product{id='000001', name='1000.0', description='portable computer', cost=1000.0}".equals(testProduct.toString());

    }

    @org.junit.jupiter.api.Test
    void toCSV() {
        assert "000001, laptop, portable computer, 1000.0".equals(testProduct.toCSV());
    }
}