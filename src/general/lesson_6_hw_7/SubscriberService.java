package general.lesson_6_hw_7;

public interface SubscriberService {

    void subscribersWithExcessiveCityCallDuration(double duration);
    void subscribersWithInterCityCalls();
    void subscribersByLastName(String lastName);
    void totalInternetTrafficForCity(String city);
    void negativeBalanceSubscribersCount();

}
