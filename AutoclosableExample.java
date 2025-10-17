public class AutoclosableExample implements AutoCloseable{

    public static void main(String[] args) throws Exception {
//        Optional<String> o = Optional.ofNullable(null);
//        System.out.println(o.orElse("shubham"));
        try(AutoclosableExample a = new AutoclosableExample()){
            System.out.println("d");
        }

    }

    @Override
    public void close() throws Exception {
        System.out.println("closing the application");
    }
}
