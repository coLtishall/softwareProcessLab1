package dimensions;

import OriginSets.IntervalSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NoBlankIntervalSetImpl<L> implements NoBlankIntervalSet<L>{
    private final long start;
    private final long end;
    private final IntervalSet<L> intervalSet;
    // Abstraction function:
    // 表示一个时间轴，时间轴的起点为start，终点为end，时间轴上包含的所有时间段的集合为intervalSet，
    // 且这个时间轴上的所有时间段之间不能有空隙，包括与start和end
    //AF(start,end,intervalSet): 一个时间轴，时间轴的起点为start，
    // 终点为end，时间轴上包含的所有时间段的集合为intervalSet
    // Representation invariant:
    // start<=end
    // Safety from rep exposure:
    // 所有成员变量private final

    /**
     * constructor
     * @param start 时间轴起点
     * @param end 时间轴终点
     * @param intervalSet 时间轴上包含的所有时间段的集合
     */
    public NoBlankIntervalSetImpl(long start, long end, IntervalSet<L> intervalSet) {
        this.start = start;
        this.end = end;
        this.intervalSet = intervalSet;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    /**
     * 判断一个已经处理完成的时间轴的start与end之间是否没有空隙
     * @return 无返回true，否则返回false
     */
    @Override
    public boolean checkIfNonblank() {
        List<L> sorted=sort();
        if(sorted.isEmpty())
            return false;
        if((intervalSet.start(sorted.get(0))!=start)||(intervalSet.end(sorted.get(sorted.size()-1))!=end))
            return false;
        for(int i=0;i<sorted.size()-1;i++){
            if(intervalSet.end(sorted.get(i))!= intervalSet.start(sorted.get(i+1))){
                return false;
            }
        }
        return true;
    }

    /**
     * 把所有时间段按照开始时间从大到小排列
     * @return 按照开始时间大小从大到小排列的时间段List
     */
    @Override
    public List<L> sort() {
        PriorityQueue<L> pq = new PriorityQueue<>(Comparator.comparing(intervalSet::start));
        pq.addAll(intervalSet.labels());
        List<L> sortedList = new ArrayList<>();
        while (!pq.isEmpty()) {
            sortedList.add(pq.poll());
        }
        return sortedList;
    }
}
