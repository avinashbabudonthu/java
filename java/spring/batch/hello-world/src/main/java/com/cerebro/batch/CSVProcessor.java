package com.cerebro.batch;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Component
public class CSVProcessor implements org.springframework.batch.item.ItemProcessor<com.cerebro.model.UserEntity, com.cerebro.model.UserEntity> {

    private static Map<String, String> deptIdToNameMap = new HashMap<>();

    public CSVProcessor(){
        deptIdToNameMap.put("101", "Engineering");
        deptIdToNameMap.put("102", "R&D");
        deptIdToNameMap.put("103", "QA");
        deptIdToNameMap.put("104", "Devops");
    }

    @Override
    public com.cerebro.model.UserEntity process(com.cerebro.model.UserEntity userEntity) throws Exception {
        String deptId = userEntity.getDept();
        String deptName = deptIdToNameMap.get(deptId);
        userEntity.setDept(deptName);
        return userEntity;
    }

}
