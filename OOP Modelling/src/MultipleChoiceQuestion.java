import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<AnswerOption> answerOptions;
    private int correctAnswer;

    // Getter and setter methods
    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
