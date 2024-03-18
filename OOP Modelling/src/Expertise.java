public enum Expertise {
    JAVA,
    PYTHON,
    CPP("C++"),
    WEB_DEVELOPMENT,
    DATA_SCIENCE;

    private final String displayName;

    Expertise() {
        this.displayName = name();
    }

    Expertise(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
