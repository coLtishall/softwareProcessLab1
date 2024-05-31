package dimensions;
/**
 * NonperiodicException类是一个自定义的异常类，用于处理非周期性检查中出现的异常情况
 * 当插入的时间段与时间轴规定的范围冲突时，会抛出这个异常
 */
public class NonperiodicException extends Exception{
    /**
     * 构造一个新的NonperiodicException实例。
     * @param message 描述异常详细信息的字符串。这个信息可以通过{@link #getMessage()}方法获取。
     */
    public NonperiodicException(String message) {
        super(message);
    }
}
