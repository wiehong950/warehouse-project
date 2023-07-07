//package contracts.warehouseproject
//
//import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpMethod
//
//Contract.make {
//    description"Supply to warehouse with id method post"
//    request {
//        url("/supply/create/1@11")
//        method(HttpMethod.POST.toString())
//        body("""
//            {
//                "amountsGoods": 500
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
//                "transId": "sup00010",
//                "amountsGoods": 500,
//                "createdAt": \$(regex('\\\\d{4}-\\\\d{2}-\\\\d{2}T\\\\d{2}:\\\\d{2}:\\\\d{2}.\\\\d{3}'))
//            }
//        """)
//        // cara ambil date gimana ? cek format memakai regex - saran chatgpt
//    }
//
//}
//