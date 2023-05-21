import java.util.List;

public interface SubscriberService {

    void subscribersWithExcessiveCityCallDuration(int duration);
    void subscribersWithInterCityCalls();
    void subscribersByLastName(String lastName);
    void totalInternetTrafficForCity(String city);
    void negativeBalanceSubscribersCount();

}
