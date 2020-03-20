package com.class062105;

import java.util.Date;
import java.util.List;

public class UserTwo {

    private String cresteID;
    private String name;

     class UserInfo{
        private Date inTIme;
        private Date outTIme;

        //同行人
         class Person{
            private String id;
            private String personName;
        }

        private List<Person> people;
    }

    List<UserInfo> userInfoList;
}
