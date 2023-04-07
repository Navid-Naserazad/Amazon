public class Request {
    private String username;
    private double fund;

    public Request(String username, double fund)
    {
        this.username = username;
        this.fund = fund;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    @Override
    public String toString() {
        return "Request{" +
                "username='" + username + '\'' +
                ", fund=" + fund +
                '}';
    }
}