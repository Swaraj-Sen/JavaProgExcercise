package be.abis.courseadmin.enumeration;

public enum Gender
{
    MALE("he","him","his","M"),
    FEMALE("she","her","her","F"),
    Other("they","them","their","O");

    private final String subjectPronoun;
    private final String reflexivePronoun;
    private final String possessivePronoun;
    private final String abbreviationPronoun;

    Gender(String subjectPronoun,String reflexivePronoun,String possessivePronoun,String abbreviationPronoun)
    {
        this.subjectPronoun = subjectPronoun;
        this.reflexivePronoun = reflexivePronoun;
        this.possessivePronoun = possessivePronoun;
        this.abbreviationPronoun = abbreviationPronoun;
    }

    public String getAbbreviationPronoun() {
        return abbreviationPronoun;
    }

    public String getPossessivePronoun() {
        return possessivePronoun;
    }

    public String getSubjectPronoun() {
        return subjectPronoun;
    }

    public String getReflexivePronoun() {
        return reflexivePronoun;
    }
}
