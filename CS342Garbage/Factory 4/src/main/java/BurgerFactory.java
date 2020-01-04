public class BurgerFactory {
    public static void main(String[] var0) {


    }

    static Burger getBurger(String burger){
        Burger burger_instance;
        switch(burger){
            case "sb":
                burger_instance = new SalmonBurger();
                break;
            case "by":
                burger_instance = new BeyondBurger();
                break;
            case "blb":
                burger_instance = new BlackBeanBurger();
                break;
            default:
                burger_instance = new BasicBurger();
        }
        return burger_instance;
    }

}


