//package contracts.warehouseproject
//
//import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpMethod
//
//Contract.make {
//    description "Create a warehouse"
//    request {
//        url "/warehouse/create"
//        method HttpMethod.POST.toString()
//        body(
//                """{
//                    "nameWarehouse":"Nama Warehouse",
//                    "addressWarehouse":"Alamat Warehouse",
//                    "phoneNumberWarehouse":"080128092",
//                    "warehouseCode": null
//                }"""
//        )
//        headers {
//            header('Content-Type', 'application/json')
//        }
//    }
//    response {
//        status 200
//        body("""
//            {
//                "idWarehouse": 4,
//                "nameWarehouse": "Nama Warehouse",
//                "addressWarehouse": "Alamat Warehouse",
//                "phoneNumberWarehouse": "080128092",
//                "warehouseCode": null
//            }
//        """)
//    }
//}