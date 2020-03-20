package com.class062105;

import java.util.Date;
import java.util.List;

public class UserThree {

    private String cresteID;
    private String name;

     private class UserInfo{
        private Date inTIme;
        private Date outTIme;

        //同行人
         private class Person{
            private String id;
            private String personName;
        }

        private List<Person> people;
    }

    List<UserInfo> userInfoList;



}
