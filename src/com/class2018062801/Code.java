package com.class2018062801;

public class Code implements Comparable<Code> {

    private int id;

    public Code(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null){
            return  false;
        }

        if (obj instanceof  Code){
            Code code = (Code) obj;

            if (this.getId() == code.getId()){
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Code o) {

        //从大到小
        //返回正值为排序后的顺序
        if (this.getId() > o.getId()){
            return 1;
        }else if (this.getId() < o.getId()){
            return  -1;
        }else {
            return 0;
        }
    }
}
