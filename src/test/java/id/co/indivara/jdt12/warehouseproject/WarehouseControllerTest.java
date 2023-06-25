package id.co.indivara.jdt12.warehouseproject;

import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class WarehouseControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void createWarehouse() throws Exception{
        Warehouse warehouse = new Warehouse(
                1L,
                "Ini Nama Warehouse",
                "Ini Alamat Warehouse",
                "01801802802",
                "wh00001"
        );
    }
}
