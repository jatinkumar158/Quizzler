package com.apkglobal.quizzler;

public class TrueFalse {

    private boolean answer;
    private int questionid;

    public TrueFalse(int questionResourceId,boolean ans)
    {
        questionid=questionResourceId;
        answer=ans;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }
}
