package dimensions;
/**
 * NonlapException类是一个自定义的异常类，用于处理时间段重叠的异常情况
 * 当插入的时间段与已存在的时间段重叠时，会抛出这个异常
 */
public class NonlapException extends Exception{

    /**
     * 构造一个新的NonlapException实例。
     * @param message 描述异常详细信息的字符串。这个信息可以通过{@link #getMessage()}方法获取。
     */
    public NonlapException(String message) {
        super(message);
    }
}
