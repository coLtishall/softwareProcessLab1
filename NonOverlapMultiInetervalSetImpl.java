package dimensions;

import OriginSets.CommonIntervalSet;
import OriginSets.MultiIntervalSet;

public class NonOverlapMultiInetervalSetImpl<L> implements NonOverlapMultiIntervalSet<L>{
    private final MultiIntervalSet<L> multiIntervalSet;
    // Abstraction function:
    // 表示一个时间轴，时间轴上包含的所有时间段的集合为multiIntervalSet，且这个时间轴上的所有时间段不会有重叠
    //AF(multiIntervalSet): 一个时间轴，时间轴上包含的所有时间段的集合为multiIntervalSet
    // Representation invariant:
    //遵循multiIntervalSet的RI
    // Safety from rep exposure:
    // 所有成员变量private final

    public NonOverlapMultiInetervalSetImpl(MultiIntervalSet<L> multiIntervalSet) {
        this.multiIntervalSet = multiIntervalSet;
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
        //需要与所有时间段做对比，于是对每个label代表的时间段循环
        for (L tempLabel : multiIntervalSet.labels()) {
            CommonIntervalSet<Integer> intervalSet = (CommonIntervalSet<Integer>) multiIntervalSet.intervals(tempLabel);
            for (int i = 0; i < intervalSet.labels().size(); i++) {
                boolean flag = true;
                if ( intervalSet.start(i) <= start && start <= intervalSet.end(i)){
                    flag = false;
                }
                if (intervalSet.start(i) <= end && end <=intervalSet.end(i)) {
                    flag = false;
                }
                if (flag == false) {
                    throw new NonlapException("this insert is forbidden for breaking NonOverlap");
                }
            }
        }
    }
}
