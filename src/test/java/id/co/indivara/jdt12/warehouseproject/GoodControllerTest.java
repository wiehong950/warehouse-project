//package id.co.indivara.jdt12.warehouseproject;
//
//import id.co.indivara.jdt12.warehouseproject.controller.GoodController;
//import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
//import id.co.indivara.jdt12.warehouseproject.repository.GoodRepository;
//import id.co.indivara.jdt12.warehouseproject.security.SpringSecurityConfig;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@Import(SpringSecurityConfig.class)
//public class GoodControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private GoodRepository goodRepository;
//
//    @Autowired
//    private GoodController goodController;
//
//    @Test
//    public void createGoodTest() throws Exception{
//        Good good = new Good(
//                40L,
//                "Ini Nama Barang",
//                "Ini Deskripsi Barang",
//                "g00020"
//        );
//    }
//}
