package SchoolManagementSystem;

public class SubjectData {
    int nOFFails;
    int noOFPasses;

    public int getNoOFFails() {
        return nOFFails;
    }

    public int getNoOFPasses() {
        return noOFPasses;
    }

    public SubjectData(int noOFPasses, int nOFFails) {
        this.nOFFails = nOFFails;
        this.noOFPasses = noOFPasses;
    }
}
