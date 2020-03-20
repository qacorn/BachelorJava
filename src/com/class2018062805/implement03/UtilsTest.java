package com.class2018062805.implement03;




import java.util.*;

public class UtilsTest {

    public static void main(String[] args) {

//        testListTomap();
//        testListToMapInnerClass();
        testGroupList();

    }

    private static void testGroupList() {

        List<Student> studentList = new ArrayList<>();
        Student student001 = new Student(12001,301,"ChangYunxin301");
        Student student002 = new Student(12002,301,"ChangYunxin301");
        Student student003 = new Student(12003,303,"ChangYunxin303");
        Student student004 = new Student(12004,304,"ChangYunxin304");
        Student student005 = new Student(12005,305,"ChangYunxin305");
        Student student006 = new Student(12006,302,"ChangYunxin302");
        Student student007 = new Student(12007,303,"ChangYunxin303");
        Student student008 = new Student(12008,304,"ChangYunxin304");
        Student student009 = new Student(12009,305,"ChangYunxin305");
        Student student010 = new Student(12010,306,"ChangYunxin306");
        Student student011 = new Student(12011,301,"ChangYunxin301");
        Student student012 = new Student(12012,302,"ChangYunxin302");
        Student student013 = new Student(12013,303,"ChangYunxin303");
        Student student014 = new Student(12014,304,"ChangYunxin304");
        Student student015 = new Student(12015,305,"ChangYunxin305");
        Student student016 = new Student(12016,306,"ChangYunxin306");
        Student student017 = new Student(12017,301,"ChangYunxin301");
        Student student018 = new Student(12018,302,"ChangYunxin302");
        Student student019 = new Student(12019,303,"ChangYunxin303");
        Student student020 = new Student(12020,304,"ChangYunxin304");
        studentList.add(student001);
        studentList.add(student002);
        studentList.add(student003);
        studentList.add(student004);
        studentList.add(student005);
        studentList.add(student006);
        studentList.add(student007);
        studentList.add(student008);
        studentList.add(student009);
        studentList.add(student010);
        studentList.add(student011);
        studentList.add(student012);
        studentList.add(student013);
        studentList.add(student014);
        studentList.add(student015);
        studentList.add(student016);
        studentList.add(student017);
        studentList.add(student018);
        studentList.add(student019);
        studentList.add(student020);


//        Map<Integer,List<Student>>
        Map<Integer, List<Student>> gradeIDGroupMap = ListToMapUtils.groupList(studentList, new ListToMapUtils.GroupListByKeyword<Student, Integer>() {
            @Override
            public Integer getKeyword(Student student) {
                return student.getGradeID();
            }
        });

        Set<Integer> integers = gradeIDGroupMap.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---------------------------");

        Set<Map.Entry<Integer, List<Student>>> studentGroupEntries = gradeIDGroupMap.entrySet();
        Iterator<Map.Entry<Integer, List<Student>>> entryIterator = studentGroupEntries.iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Integer, List<Student>> next = entryIterator.next();
            System.out.println(next.getKey());
            List<Student> value = next.getValue();
            for (int i = 0; i < value.size(); i++) {
                System.out.println(value.get(i));
            }
        }

    }


    public static void testListToMapInnerClass() {

        List<User> userList = new ArrayList<>();
        User user001 = new User(1001, "WangYajun");
        User user002 = new User(1002, "ChangYunxin");
        User user003 = new User(1003, "GuanHao");
        User user004 = new User(1004, "LiQianqian");

        userList.add(user001);
        userList.add(user002);
        userList.add(user003);
        userList.add(user004);

        //内部类写法示例
        try {
            Map<Integer, List<User.UserCheckInInfo.FellowPerson>> integerListMap = ListToMapUtils.changeListToMap(userList, new ListToMapUtils.AssignKeyAndValue<User, Integer, List<User.UserCheckInInfo.FellowPerson>>() {
                @Override
                public Integer getKey(User user) {
                    return user.getUserID();
                }

                @Override
                public List<User.UserCheckInInfo.FellowPerson> getValue(User user) {
                    return user.getUserInfoList().get(0).getPeople();
                }
            });
        } catch (DuplicatedKeyException e) {
            e.printStackTrace();
        }
    }

    public static void testListTomap() {
        List<User> userList = new ArrayList<>();
        User user001 = new User(1001, "WangYajun");
        User user002 = new User(1002, "ChangYunxin");
        User user003 = new User(1003, "GuanHao");
        User user004 = new User(1004, "LiQianqian");

        userList.add(user001);
        userList.add(user002);
        userList.add(user003);
        userList.add(user004);


        try {
            Map<Integer, User> integerUserMap = ListToMapUtils.changeListToMap(userList, new ListToMapUtils.AssignKeyAndValue<User, Integer, User>() {
                @Override
                public Integer getKey(User user) {
                    return user.getUserID();
                }

                @Override
                public User getValue(User user) {
                    return user;
                }
            });

            Iterator<Map.Entry<Integer, User>> iterator = integerUserMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, User> next = iterator.next();
                System.out.println("Map's Key==" + next.getKey());
                System.out.println("Map's Value  " +next.getValue());
            }
        } catch (DuplicatedKeyException e) {
            e.printStackTrace();
        }


//打印信息
//        Map's Key==1001
//        Map's Value  UserId==1001 Username==WangYajun
//        Map's Key==1002
//        Map's Value  UserId==1002 Username==ChangYunxin
//        Map's Key==1003
//        Map's Value  UserId==1003 Username==GuanHao
//        Map's Key==1004
//        Map's Value  UserId==1004 Username==LiQianqian
    }


}
