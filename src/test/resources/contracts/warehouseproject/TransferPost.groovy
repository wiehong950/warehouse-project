//package contracts.warehouseproject
//
//import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpMethod
//
//Contract.make {
//    description"Supply to warehouse with id method post"
//    request {
//        url("/whtowh/create/1@1/2")
//        method(HttpMethod.POST.toString())
//        body("""
//            {
//                "amountsGoods": 200
//            }
//        """)
//        headers {
//            header('Content-Type', 'application/json')
//        }
//    }
//    response {
//        status(200)
//        body("""
//            {
//                "transId": "wtw00004",
//                "amountsGoods": 200,
//                "createdAt": \$(regex('\\\\d{4}-\\\\d{2}-\\\\d{2}T\\\\d{2}:\\\\d{2}:\\\\d{2}.\\\\d{3}'))
//            }
//        """)
//    }
//
//}
//
