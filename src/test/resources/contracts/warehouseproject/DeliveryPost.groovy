//package contracts.warehouseproject
//
//import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpMethod
//
//Contract.make {
//    description"Supply to warehouse with id method post"
//    request {
//        url("/whtostr/create/1@1/1")
//        method(HttpMethod.POST.toString())
//        body("""
//            {
//                "amountsGoods": 10
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
//                "transId": "wts00006",
//                "amountsGoods": 10,
//                "createdAt": \$(regex('\\\\d{4}-\\\\d{2}-\\\\d{2}T\\\\d{2}:\\\\d{2}:\\\\d{2}.\\\\d{3}'))
//            }
//        """)
//    }
//}
//
