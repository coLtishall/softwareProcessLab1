package dimensions;

import OriginSets.IntervalSet;

public class NonOverlapIntervalSetImpl<L> implements NonOverlapIntervalSet<L>{
    private final long start;
    private final long end;
    private final IntervalSet<L> intervalset;
    // Abstraction function:
    // 表示一个时间轴，时间轴的起点为start，终点为end，
    // 时间轴上包含的所有时间段的集合为intervalset，且这个时间轴上的所有时间段不会有重叠
    //AF(start,end,intervalset): 一个时间轴，时间轴的起点为start，
    // 终点为end，时间轴上包含的所有时间段的集合为intervalset
    // Representation invariant:
    // start<=end
    // Safety from rep exposure:
    // 所有成员变量private final


    public NonOverlapIntervalSetImpl(long start, long end, IntervalSet<L> intervals) {
        this.start = start;
        this.end = end;
        this.intervalset = intervals;
    }

    /**
     * 用于每次插入前，判断是否可以插入该时间段
     * @param start 需要插入的时间段的开始时间
     * @param end 需要插入的时间段的结束时间
     * @param label 需要插入的时间段的label
     * @throws NonlapException 如果需要插入的时间段与时间轴上任意时间段有重叠，则抛出该异常
     */
    @Override
    public void checkIfCanInsert(long start, long end, L label) throws NonlapException {
        boolean flag = true;
        for (L l : intervalset.labels()) {
            //检查start是否在某个已有时间段内部
            if (intervalset.start(l)<=start && start <= intervalset.end(l)) {
                flag = false;
            }
            //检查end是否在某个时间段内部
            if (intervalset.start(l)<=end && end <= intervalset.end(l)) {
                flag = false;
            }
        }
        if (flag == false) {
            throw new NonlapException("这次插入会导致时间段的重叠，不予插入");
        }
    }
}
