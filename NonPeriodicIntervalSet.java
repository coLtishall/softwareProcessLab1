package dimensions;

public interface NonPeriodicIntervalSet<L> {
    /**
     * 检查一个时间段是否可以插入到一个非周期性时间段中
     * @param start 插入时间段的开始时间
     * @param end 插入时间段的结束时间
     * @throws NonperiodicException 若需要插入的时间段的时间在时间轴规定范围之外，
     *                              即不能插入该period，则抛出该异常
     */
    public void checkIfNonperiodic(long start, long end) throws NonperiodicException;
}
