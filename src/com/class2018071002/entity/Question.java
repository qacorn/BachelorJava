package com.class2018071002.entity;

import com.class2018071001.entity.QuestionState;
import com.class2018071001.entity.QuestionType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Question implements Comparable<Question> {
    private int questionID;
    private int type;
    private String[] scope;
    private String stem;
    private List<String> options;
    private String key;
    private String explanation;
    private QuestionState questionState;
    private long addTime;
    private long updateTime;

    public Question() {
    }

    public Question(int questionID, int type, String[] scope, String stem, List<String> options, String key, String explanation, long addTime) {
        this.questionID = questionID;
        this.type = type;
        this.scope = scope;
        this.stem = stem;
        this.options = options;
        this.key = key;
        this.explanation = explanation;
        this.addTime = addTime;
    }


    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getScope() {
        return scope;
    }

    public void setScope(String[] scope) {
        this.scope = scope;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (getType() == QuestionType.SINGLE_CHOICE.ordinal()) {
            stringBuffer.append("单选题:").append("\n");
        }else if (getType() == QuestionType.MULTI_CHOICE.ordinal()){
            stringBuffer.append("多选题").append("\n");
        }
        stringBuffer.append(getQuestionID()).append("\n").append(getStem()).append("\n").append(getOptions().get(0)).append("\n").append(getOptions().get(1)).append("\n").append(getOptions().get(2)).append("\n").append(getOptions().get(3)).append("\n").append(getKey()).append("\n").append(getExplanation()).append("\n");
        Date date = new Date(getAddTime());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd E hh:mm:ss",Locale.CHINA);
        stringBuffer.append(dateFormat.format(date)).append("\n");
        return stringBuffer.toString();
    }

//升序排列
//    @Override
//    public int compareTo(Question o) {
//        if (this.getAddTime() > o.getAddTime()){
//            return 1;
//        }else if(this.getAddTime() < o.getAddTime()){
//            return -1;
//        }
//        return 0;
//    }

        @Override
    public int compareTo(Question o) {
        if (this.getAddTime() > o.getAddTime()){
            return -1;
        }else if(this.getAddTime() < o.getAddTime()){
            return 1;
        }
        return 0;
    }

    public void printQuestionForExaminee(){
        StringBuffer stringBuffer = new StringBuffer();
        if (getType() == QuestionType.SINGLE_CHOICE.ordinal()) {
            stringBuffer.append("单选题:").append("\n");
        }else if (getType() == QuestionType.MULTI_CHOICE.ordinal()){
            stringBuffer.append("多选题").append("\n");
        }
        stringBuffer.append(getStem()).append("\n").append(getOptions().get(0)).append("\n").append(getOptions().get(1)).append("\n").append(getOptions().get(2)).append("\n").append(getOptions().get(3)).append("\n");
        System.out.println(stringBuffer);
    }

    public void printQuestionForAdmin(){
        StringBuffer stringBuffer = new StringBuffer();
        if (getType() == QuestionType.SINGLE_CHOICE.ordinal()) {
            stringBuffer.append("单选题:").append("\n");
        }else if (getType() == QuestionType.MULTI_CHOICE.ordinal()){
            stringBuffer.append("多选题").append("\n");
        }
        stringBuffer.append(getStem()).append("\n").append(getOptions().get(0)).append("\n").append(getOptions().get(1)).append("\n").append(getOptions().get(2)).append("\n").append(getOptions().get(3)).append("\n").append("正确答案: ").append(getKey()).append("\n");
        System.out.println(stringBuffer);
    }
}
