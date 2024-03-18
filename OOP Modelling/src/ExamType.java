public enum ExamType {

    MCQ("Multiple Choice Question", MultipleChoiceQuestion.class),
    TRUE_FALSE("True/False Question", TrueFalseQuestion.class);
    private final String description;
    private final Class<? extends Question> questionClass;

    ExamType(String description, Class<? extends Question> questionClass) {
        this.description = description;
        this.questionClass = questionClass;
    }

    public String getDescription() {
        return description;
    }

    public Class<? extends Question> getQuestionClass() {
        return questionClass;
    }

    @Override
    public String toString() {
        return name() + " (" + description + ")";
    }

}
