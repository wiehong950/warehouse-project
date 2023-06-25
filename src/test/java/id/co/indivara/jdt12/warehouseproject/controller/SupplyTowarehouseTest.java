package id.co.indivara.jdt12.warehouseproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.indivara.jdt12.warehouseproject.entity.SupplyToWarehouse;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.security.SpringSecurityConfig;
import id.co.indivara.jdt12.warehouseproject.service.SupplyService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Import(SpringSecurityConfig.class)
public class SupplyTowarehouseTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SupplyController supplyController;

    @Autowired
    private SupplyService supplyService;

//    @Test
//    public void viewAllSupplyTest() throws Exception{
//        Good good = new Good();
//        good.setIdGood(3L);
//
//        Warehouse warehouse = new Warehouse();
//        warehouse.setIdWarehouse(1L);
//
//        SupplyToWarehouse supplyToWarehouse = new SupplyToWarehouse();
//        supplyToWarehouse.setAmountsGoods(100);
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/supply/create/{goodId}@{warehouseDst}",good.getIdGood(),warehouse.getIdWarehouse())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .with(SecurityMockMvcRequestPostProcessors.user("admin").password("admin123").roles("ADMIN"))
//                        .content(objectMapper.writeValueAsString(good.getIdGood()))
//                        .content(objectMapper.writeValueAsString(warehouse.getIdWarehouse()))
//                        .content(objectMapper.writeValueAsString(supplyToWarehouse))
//                )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.transId").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.amountsGoods").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.amountsGoods").exists())
//        ;
//    }
    // isi object dari master data:
    // isi object good
//    Good good = new Good(
//            1L,
//            "Ini Nama Barang",
//            "Ini Deskripsi Barang",
//            "g00001"
//    );

    // isi object warehouse
//    Warehouse warehouse = new Warehouse(
//            1L,
//            "Ini Nama Warehouse",
//            "Ini Alamat Warehouse",
//            "01801802802",
//            "wh00001"
//    );

//     buat satu object untuk supply to warehouse yang ada isinya

//    @Test
//    public void testViewSupplyAll() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/supply/all"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//    }
}
