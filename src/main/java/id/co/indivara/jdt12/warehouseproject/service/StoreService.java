package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public Store createStore(Store store){
        return storeRepository.save(store);
    }

    public List<Store> viewAllStore(){
        return new ArrayList<>(storeRepository.findAll());
    }

    public Store updateStore(Long id, Store store){
        Store storeFind = storeRepository.findById(id).get();
        storeFind.setNameStore(store.getNameStore());
        storeFind.setAddressStore(store.getAddressStore());
        storeFind.setEmailStore(store.getEmailStore());
        storeFind.setPhoneNumberStore(store.getPhoneNumberStore());
        return storeRepository.save(storeFind);
    }


    public void deleteStore(Long id){
        storeRepository.deleteById(id);
    }
}
