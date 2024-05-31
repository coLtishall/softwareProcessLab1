package dimensions;

public interface NonOverlapIntervalSet<L> {
    /**
     * 用于每次插入前，判断是否可以插入该时间段
     * @param start 需要插入的时间段的开始时间
     * @param end 需要插入的时间段的结束时间
     * @param label 需要插入的时间段的label
     * @throws NonlapException 如果需要插入的时间段与时间轴上任意时间段有重叠，则抛出该异常
     */
    public void checkIfCanInsert(long start, long end, L label) throws NonlapException;
}
