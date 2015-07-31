package karanjagota.recruiters_test;

public class Questions {

    private int _id;
    private String _question_name;
    private String answer;

    // first create the getter and setter method .. ..

    public Questions() {

    }

    public Questions(int id, String questionname, String answer) {
        this._id = id;
        this._question_name = questionname;
        this.answer = answer;
    }

    public Questions(String questionname, String answer) {
        this._question_name = questionname;
        this.answer = answer;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setQuestionName(String questionname) {
        this._question_name = questionname;
    }

    public String getQuestionName() {
        return this._question_name;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }

}
