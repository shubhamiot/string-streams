public class SwitchExample {

    public static void main(String[] args) {
        int a = 2;
        fetch(a);
        fetchEnum();
        String s = fetchValueJava13();
        System.out.println("java 13 switch example: " + s);
        String s1 = fetchValueJavaArrow12();
        System.out.println(s1);
        String s2 = fetchValueJava12ArrowWithMutipleValue();
        System.out.println(s2);
//        String s3 = fetchValuePatternMatchjdk17("shubham");
//        System.out.println(s3);
    }

//    private static String fetchValuePatternMatchjdk17(Object s) {
//        return switch (s){
//            case Integer  -> "integer";
//            case String  -> "string";
//
//            default -> "no objec found";
//        };
//    }

    private static String fetchValueJava12ArrowWithMutipleValue() {
        Days monday = Days.MONDAY;
        return switch (monday){
            case MONDAY,TUE-> "working day";
            case WED,THRUS -> "boringdat";
            case FRI -> "weekend";
            default ->"off";
        };
    }

    private static String  fetchValueJavaArrow12() {

        Days monday = Days.MONDAY;
        return switch (monday){
            case MONDAY -> "working day";
            case TUE -> "boring day";
            default -> "off";
        };
    }

    private static String fetchValueJava13() {

        String s = "MON";
        return switch (s){
            case "MON":
                yield "working day";
            case "TUE":
                yield "boring day";
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        };
    }

    private static void fetchEnum() {
        Days monday = Days.MONDAY;
        switch (monday){
            case MONDAY:
                System.out.println("moday");
                break;
            case TUE:
                System.out.println("tues");
                break;
            case WED:
                System.out.println("wed");
                break;
            case THRUS:
                System.out.println("thrus");
            case FRI:
                System.out.println("fri");
            case SAT:
                System.out.println("sat");
            case SUN:
                System.out.println("sun");
            default:
                System.out.println("no days found");
        }
    }

    private static void fetch(int a) {

        switch (a){
            case 1:
                System.out.println(a);
                break;
            case 2:
                System.out.println(a);
                break;
            default:
                System.out.println("no found");
        }
    }
}

enum Days
{
    MONDAY, TUE, WED, THRUS, FRI,SAT,SUN
}
