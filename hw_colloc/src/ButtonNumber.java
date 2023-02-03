public class ButtonNumber implements Callable{
    public Integer call(Integer num, Integer radix) {
        return num * 10 + radix;
    }
}
