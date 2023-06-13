package lesson_6_hw_7;

public class Main {
    public static void main(String[] args) {

        SubscriberService subscriberService = new SubscriberServiceImpl();
        subscriberService.subscribersWithExcessiveCityCallDuration(50);
        System.out.println("__________________________________________");

        subscriberService.subscribersWithInterCityCalls();
        System.out.println("__________________________________________");

        subscriberService.subscribersByLastName("Bulgakov");
        System.out.println("__________________________________________");

        subscriberService.totalInternetTrafficForCity("Miami");
        System.out.println("__________________________________________");

        subscriberService.negativeBalanceSubscribersCount();
    }
}
