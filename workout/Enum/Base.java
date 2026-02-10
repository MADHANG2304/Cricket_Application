package Enum;

import Enum.Order.OrderStatus;

public class Base {
    public static void main(String[] args) {
        OrderStatus status = OrderStatus.PLACED;
        System.out.println("Current Status: " + status);
        System.out.println("Current Status Number is: " + status.getStatus());
        status.displayMessage();

        switch (status) {
            case PLACED:
                System.out.println("Preparing the package");
                break;
            case SHIPPED:
                System.out.println("Track the shipment");
                break;
            case DELIVERED:
                System.out.println("Close the order");
                break;
            case CANCELLED:
                System.out.println("Refund Initiated");
                break;
        }

        System.out.println("\nAll Order Status:");
        for(OrderStatus i : OrderStatus.values()){
            System.out.println("Status Type: " + status + " Status Code: " + status.getStatus() + " Ordinal(): " + status.ordinal());
        }

        OrderStatus status2 = OrderStatus.DELIVERED;
        System.out.println("\nCurrent Status: " + status2);
        System.out.println("Current Status Number is: " + status2.getStatus());
        status2.displayMessage();
    }   
}
