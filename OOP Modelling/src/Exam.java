import java.util.List;

public class Exam extends Content {
    private ExamType examType;
    private List<Question> questions;
    private int questionCount;
    private TimeLimit timeLimit;
    private PassingGrade passingGrade;

    // Getter and setter methods
    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public TimeLimit getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(TimeLimit timeLimit) {
        this.timeLimit = timeLimit;
    }

    public PassingGrade getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(PassingGrade passingGrade) {
        this.passingGrade = passingGrade;
    }
}
