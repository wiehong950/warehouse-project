package contracts.warehouseproject

import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpMethod

Contract.make {
    description "Get all Warehouse"
    request {
        url "/warehouse/viewall"
        method HttpMethod.GET.toString()
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response{
        status 200
        body("""
            [
                {
                    "idWarehouse": 11,
                    "nameWarehouse": "Ini Warehouse 1",
                    "addressWarehouse": "Ini Warehouse Deskripsi 1",
                    "phoneNumberWarehouse": "080808252",
                    "warehouseCode": "wh00011"
                }
            ]
        """)
    }
}


//                {
//                    "idWarehouse": 1,
//                    "nameWarehouse": "Howell and Sons",
//                    "addressWarehouse": "3023 Vidon Road",
//                    "phoneNumberWarehouse": "602-351-7160",
//                    "warehouseCode": "wh00001"
//                },
//                {
//                    "idWarehouse": 2,
//                    "nameWarehouse": "Kiehn-Swaniawski",
//                    "addressWarehouse": "762 Dahle Point",
//                    "phoneNumberWarehouse": "132-554-3067",
//                    "warehouseCode": "wh00002"
//                },
//                {
//                    "idWarehouse": 3,
//                    "nameWarehouse": "Cummings and Sons",
//                    "addressWarehouse": "61797 Stang Junction",
//                    "phoneNumberWarehouse": "254-656-1546",
//                    "warehouseCode": "wh00003"
//                },
//                {
//                    "idWarehouse": 4,
//                    "nameWarehouse": "Lubowitz and Sons",
//                    "addressWarehouse": "398 8th Avenue",
//                    "phoneNumberWarehouse": "889-444-4279",
//                    "warehouseCode": "wh00004"
//                },
//                {
//                    "idWarehouse": 5,
//                    "nameWarehouse": "Runolfsson Group",
//                    "addressWarehouse": "6 Cherokee Drive",
//                    "phoneNumberWarehouse": "943-689-7156",
//                    "warehouseCode": "wh00005"
//                },
//                {
//                    "idWarehouse": 6,
//                    "nameWarehouse": "Barton-Barrows",
//                    "addressWarehouse": "59641 Gulseth Park",
//                    "phoneNumberWarehouse": "173-619-0785",
//                    "warehouseCode": "wh00006"
//                },
//                {
//                    "idWarehouse": 7,
//                    "nameWarehouse": "Turner and Sons",
//                    "addressWarehouse": "24 Del Sol Terrace",
//                    "phoneNumberWarehouse": "994-255-4529",
//                    "warehouseCode": "wh00007"
//                },
//                {
//                    "idWarehouse": 8,
//                    "nameWarehouse": "Sawayn Group",
//                    "addressWarehouse": "0754 Sherman Point",
//                    "phoneNumberWarehouse": "825-443-1039",
//                    "warehouseCode": "wh00008"
//                },
//                {
//                    "idWarehouse": 9,
//                    "nameWarehouse": "Windler Group",
//                    "addressWarehouse": "958 Golden Leaf Crossing",
//                    "phoneNumberWarehouse": "836-452-1446",
//                    "warehouseCode": "wh00009"
//                },
//                {
//                    "idWarehouse": 10,
//                    "nameWarehouse": "Ini Update Warehouse",
//                    "addressWarehouse": "Ini Update Warehouse Deskripsi",
//                    "phoneNumberWarehouse": "08080808",
//                    "warehouseCode": "wh00010"
//                }

