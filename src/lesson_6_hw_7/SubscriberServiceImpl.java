package lesson_6_hw_7;

public class SubscriberServiceImpl implements SubscriberService {

    @Override
    public void subscribersWithExcessiveCityCallDuration(double duration) {
        Subscriber[] subscribers = SubGeneration.generateSubArray();
        for (Subscriber s : subscribers) {
            if (s.getCityCallDuration() > duration) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void subscribersWithInterCityCalls() {
        Subscriber[] subscribers = SubGeneration.generateSubArray();
        for (Subscriber s : subscribers) {
            if (s.getInterCityCallDuration() > 0) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void subscribersByLastName(String lastName) {
        Subscriber[] subscribers = SubGeneration.generateSubArray();
        for (Subscriber s : subscribers) {
            if (s.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void totalInternetTrafficForCity(String city) {
        Subscriber[] subscribers = SubGeneration.generateSubArray();
        double totalTraffic = 0;
        for (Subscriber s : subscribers) {
            if (s.getCity().equalsIgnoreCase(city)) {
                totalTraffic += s.getInternetTraffic();
            }
        }
        System.out.println("Total internet traffic for "
                + city + ": " + totalTraffic);
    }

    @Override
    public void negativeBalanceSubscribersCount() {
        Subscriber[] subscribers = SubGeneration.generateSubArray();
        int count = 0;
        for (Subscriber s : subscribers) {
            if (s.getBalance() < 0) {
                count++;
            }
        }
        System.out.println("Number of subscribers with negative balance: "
                + count);
    }
}
    



