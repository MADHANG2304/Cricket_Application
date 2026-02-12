package enumClass;

public class Order {
    enum OrderStatus{
        PLACED(0){
            void displayMessage(){
                System.out.println("Order has been Placed");
            }
        },
        SHIPPED(1){
            void displayMessage(){
                System.out.println("Order has been Shipped");
            }
        },
        DELIVERED(2){
            void displayMessage(){
                System.out.println("Order has been Delivered");
            }
        },
        CANCELLED(3){
            void displayMessage(){
                System.out.println("Order has been Cancelled");
            }
        };

        int status;

        OrderStatus(int status) {
            this.status = status;
        }   

        public int getStatus(){
            return status;
        }

        abstract void displayMessage();
    }
}
