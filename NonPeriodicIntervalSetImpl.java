package dimensions;

import OriginSets.IntervalSet;

public class NonPeriodicIntervalSetImpl<L> implements NonPeriodicIntervalSet<L>{

    private final long start;
    private final long length;
    // Abstraction function:
    // 表示一个时间轴范围，时间轴的起点为start，时间轴的长度为length
    // Representation invariant:
    // 插入的时间段在时间轴规定范围内部
    //·Safety from rep exposure:
    // 所有成员变量private final

    public NonPeriodicIntervalSetImpl(long start, long length, IntervalSet<L> intervalset) {
        this.start = start;
        this.length = length;
    }
    /**
     * 检查一个时间段是否可以插入到一个非周期性时间段中
     * @param start 插入时间段的开始时间
     * @param end 插入时间段的结束时间
     * @throws NonperiodicException 若需要插入的时间段的时间在时间轴规定范围之外，
     *                              即不能插入该period，则抛出该异常
     */
    @Override
    public void checkIfNonperiodic(long start, long end) throws NonperiodicException {
        if(start<this.start||this.start+this.length<end)
            throw new NonperiodicException("confict with insert in this period");
    }
}
