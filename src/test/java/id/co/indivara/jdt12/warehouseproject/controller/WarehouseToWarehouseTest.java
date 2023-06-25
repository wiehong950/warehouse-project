package id.co.indivara.jdt12.warehouseproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToStore;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToWarehouse;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class WarehouseToWarehouseTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    public void transferTest() throws Exception{
//        Good good = new Good();
//        good.setIdGood(3L);
//
//        Warehouse warehouse = new Warehouse();
//        warehouse.setIdWarehouse(1L);
//
//        Warehouse warehouseTo = new Warehouse();
//        warehouse.setIdWarehouse(5L);
//
//        WarehouseToWarehouse warehouseToWarehouse = new WarehouseToWarehouse();
//        warehouseToWarehouse.setAmountsGoods(100);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/whtowh/create/{goodId}@{warehouseSrc}/{warehouseDst}", good.getIdGood(),warehouse.getIdWarehouse(), warehouseTo.getIdWarehouse())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .with(SecurityMockMvcRequestPostProcessors.user("admin").password("admin123").roles("ADMIN"))
//                        .content(objectMapper.writeValueAsString(good.getIdGood()))
//                        .content(objectMapper.writeValueAsString(warehouse.getIdWarehouse()))
//                        .content(objectMapper.writeValueAsString(warehouseTo.getIdWarehouse()))
//                        .content(objectMapper.writeValueAsString(warehouseToWarehouse)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.transId").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.amountsGoods").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").exists())
//        ;
//    }
}
