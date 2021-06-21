package com.carsonlius.interceptor;

import com.carsonlius.interceptor.entity.UserActiveRecord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserActiveRecordTest {

    @Test
    public void testSelectById(){
        UserActiveRecord userActiveRecord = new UserActiveRecord();
        UserActiveRecord userActiveRecord1 = userActiveRecord.selectById(1L);
        System.out.println("result:" + userActiveRecord);
        System.out.println("result1:" + userActiveRecord1);
    }


    @Test
    public void testInsert(){
        UserActiveRecord userActiveRecord = new UserActiveRecord();
        userActiveRecord.setName("ar2");

        userActiveRecord.setAge(30);
        boolean result = userActiveRecord.insert();
        System.out.println("ar insert result:" + result + userActiveRecord);

    }

}
