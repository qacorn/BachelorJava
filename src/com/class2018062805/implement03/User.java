package com.class2018062805.implement03;

import java.util.Date;
import java.util.List;

public class User {

    private int userID;
    private String name;
    private List<UserCheckInInfo> userInfoList;

    static class UserCheckInInfo {
        private Date inTIme;
        private Date outTIme;
        private List<FellowPerson> people;

        //同行人
        static class FellowPerson {
            private String id;
            private String personName;

            public FellowPerson(String id, String personName) {
                this.id = id;
                this.personName = personName;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPersonName() {
                return personName;
            }

            public void setPersonName(String personName) {
                this.personName = personName;
            }
        }

        public UserCheckInInfo(Date inTIme, Date outTIme, List<FellowPerson> people) {
            this.inTIme = inTIme;
            this.outTIme = outTIme;
            this.people = people;
        }

        public Date getInTIme() {
            return inTIme;
        }

        public void setInTIme(Date inTIme) {
            this.inTIme = inTIme;
        }

        public Date getOutTIme() {
            return outTIme;
        }

        public void setOutTIme(Date outTIme) {
            this.outTIme = outTIme;
        }

        public List<FellowPerson> getPeople() {
            return people;
        }

        public void setPeople(List<FellowPerson> people) {
            this.people = people;
        }
    }

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public User(int userID, String name, List<UserCheckInInfo> userInfoList) {
        this.userID = userID;
        this.name = name;
        this.userInfoList = userInfoList;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserCheckInInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserCheckInInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserId==").append(getUserID()).append(" Username==").append(getName());
        return stringBuffer.toString();
    }
}
