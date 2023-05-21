public class SubscriberServiceImpl implements SubscriberService {

    @Override
    public void subscribersWithExcessiveCityCallDuration(int duration) {
        Subscriber[] subscribers = SubGeneration.generateSubArray();
            for (Subscriber s : subscribers) {
                if (s.getCityCallDuration() > duration);
                System.out.println(s);
            }
    }

    @Override
    public void subscribersWithInterCityCalls() {

    }

    @Override
    public void subscribersByLastName(String lastName) {

    }

    @Override
    public void totalInternetTrafficForCity(String city) {

    }

    @Override
    public void negativeBalanceSubscribersCount() {

    }
}
    



